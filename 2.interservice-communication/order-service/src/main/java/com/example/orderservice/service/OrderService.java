package com.example.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient webClient;


	public void placeOrder(OrderRequest orderRequest) {
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());

		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItemsList(orderLineItems);


		List<String> skuCodes = order.getOrderLineItemsList()
				.stream()
				.map(orderLineItem -> orderLineItem.getSkuCode())
				.collect(Collectors.toList());

		// Call Inventory Service, and place order if product is in stock
		boolean allProductsInStock = webClient.get()
				.uri("http://localhost:8092/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.map(e -> Arrays.stream(e))
				.block()
				.allMatch(InventoryResponse::isInStock);

		if(allProductsInStock){
			orderRepository.save(order);
		} else {
			throw new IllegalArgumentException("Product is not in stock, please try again later");
		}

	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}
