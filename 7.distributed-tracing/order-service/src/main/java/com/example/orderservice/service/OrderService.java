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

import brave.Span;
import brave.Tracer;
import brave.Tracer.SpanInScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	private static final String INVENTORY_SERVICE_URI = "http://inventory-service/api/inventory";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient.Builder webClientBuilder;

	private Tracer tracer;


	public String placeOrder(OrderRequest orderRequest) {
		log.info("OrderService | placeOrder method called ");
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

		Span inventoryServiceLookup = tracer.nextSpan().name("InventoryServiceLookup");

		try (Tracer.SpanInScope isLookup = tracer.withSpanInScope(inventoryServiceLookup.start())){
			inventoryServiceLookup.tag("call", "inventory-service");

			// Call Inventory Service, and place order if product is in stock
			boolean allProductsInStock = webClientBuilder.build()
					.get()
					.uri(INVENTORY_SERVICE_URI, uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
					.retrieve()
					.bodyToMono(InventoryResponse[].class)
					.map(e -> Arrays.stream(e))
					.block()
					.allMatch(InventoryResponse::isInStock);

			if(allProductsInStock){
				orderRepository.save(order);
				return "Order Placed Successfully";
			} else {
				throw new IllegalArgumentException("Product is not in the stock, please try again later");
			}

		}finally {
			inventoryServiceLookup.flush();
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
