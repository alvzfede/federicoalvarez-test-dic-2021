package com.applaudo.service.definition;

import org.springframework.http.ResponseEntity;

import com.applaudo.entity.Item;
import com.applaudo.entity.ItemStatus;
import com.applaudo.utils.ApiResult;

public interface ItemService {

	ResponseEntity<ApiResult> saveItem(Item item);
	
	ResponseEntity<ApiResult> getItem(long itemId);
	
	ResponseEntity<ApiResult> getItems(ItemStatus itemStatus, String itemName);
}
