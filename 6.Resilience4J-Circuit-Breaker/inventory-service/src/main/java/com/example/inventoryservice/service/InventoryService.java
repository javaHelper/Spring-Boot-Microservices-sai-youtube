package com.example.inventoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCodes) {
		log.info("Wait Started !!");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			log.error("Exception :: "+e);
		}
		log.info("Wait Ended !!");

		return inventoryRepository.findBySkuCodeIn(skuCodes)
				.stream()
				.map(inventory -> InventoryResponse.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity() > 0)
						.build())
				.collect(Collectors.toList());

	}
}
