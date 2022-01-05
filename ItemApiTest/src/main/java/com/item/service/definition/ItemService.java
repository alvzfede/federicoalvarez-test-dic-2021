package com.item.service.definition;

import org.springframework.http.ResponseEntity;

import com.item.entity.Item;
import com.item.entity.ItemStatus;
import com.item.utils.ApiResult;

public interface ItemService {

	ResponseEntity<ApiResult> saveItem(Item item);
	
	ResponseEntity<ApiResult> getItem(long itemId);
	
	ResponseEntity<ApiResult> getItems(ItemStatus itemStatus, String itemName);
}
