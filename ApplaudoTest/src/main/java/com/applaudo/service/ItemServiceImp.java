package com.applaudo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.applaudo.entity.Item;
import com.applaudo.entity.ItemStatus;
import com.applaudo.repository.ItemRepository;
import com.applaudo.service.definition.ItemService;
import com.applaudo.utils.ApiResult;

@Service
public class ItemServiceImp implements ItemService{

	static final String ITEM_EXIST = "Item exists on database";
	static final String ITEM_NOT_FOUND = "Item not found";
	static final String SUCCESS = "Success";
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public ResponseEntity<ApiResult> saveItem(Item item) {
		
		item.setItemEnteredDate(LocalDateTime.now());
		item.setItemLastModifiedDate(LocalDateTime.now());
		
		if(itemRepository.findById(item.getItemId()).isPresent())
			return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.BAD_REQUEST.value()),ITEM_EXIST,null), HttpStatus.BAD_REQUEST);
		
		
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.CREATED.value()),SUCCESS,itemRepository.save(item)) , HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<ApiResult> getItem(long itemId) {
		
		Optional<Item> item = itemRepository.findById(itemId);
		if(item.isPresent())
			return  new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.OK.value()),SUCCESS,item.get()), HttpStatus.OK); 
		
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.NOT_FOUND.value()),ITEM_NOT_FOUND,null), HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ApiResult> getItems(ItemStatus itemStatus, String itemName) {
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.OK.value()),SUCCESS,itemRepository.findByItemStatusAndItemNameIgnoreCase(itemStatus,itemName)),HttpStatus.OK);
		
	}

	ApiResult generateApiResult(String code, String message, Object data){
		return new ApiResult(code,message,data);
	}
	
}
