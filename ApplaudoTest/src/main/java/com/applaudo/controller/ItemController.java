package com.applaudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;

import com.applaudo.entity.Item;
import com.applaudo.entity.ItemStatus;
import com.applaudo.service.definition.ItemService;
import com.applaudo.utils.ApiResult;

@RestController
@RequestMapping("app")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/item")
	public ResponseEntity<ApiResult> saveItem(@Valid @RequestBody Item item){
		return itemService.saveItem(item);
	}
	

	@GetMapping("/item/{itemId}")
	public ResponseEntity<ApiResult>  getById(@PathVariable(value = "itemId") Long itemId){
		return itemService.getItem(itemId);
	}

	@GetMapping("/item")
	public ResponseEntity<ApiResult> getItemsByStatusAndName(	@RequestParam(name="itemStatus") ItemStatus itemStatus,
												@RequestParam(name="itemName") String itemName){
		return itemService.getItems(itemStatus, itemName);
	}
	
}
