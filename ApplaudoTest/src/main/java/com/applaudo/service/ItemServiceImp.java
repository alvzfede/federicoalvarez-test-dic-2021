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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ItemServiceImp implements ItemService{
	
	private Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	private static final String ITEM_EXIST = "Item exists on database";
	private static final String ITEM_NOT_FOUND = "Item not found";
	private static final String SUCCESS = "Success";
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	/**
	 * This method insert data and return the inserted item.
	 * 
	 * @param item Object with data to save
	 * @return ResponseEntity<> Object with the response.
	 * 
	 */
	
	@Override
	public ResponseEntity<ApiResult> saveItem(Item item) {
		
		log.info("-- saveItem --");
		
		item.setItemEnteredDate(LocalDateTime.now());
		item.setItemLastModifiedDate(LocalDateTime.now());
		
		if(itemRepository.findById(item.getItemId()).isPresent())
			return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.BAD_REQUEST.value()),ITEM_EXIST,null), HttpStatus.BAD_REQUEST);
		
		
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.CREATED.value()),SUCCESS,itemRepository.save(item)) , HttpStatus.CREATED);
		
	}

	/**
	 * This method return a specific item.
	 * 
	 * @param itemId Id item to search 
	 * @return ResponseEntity<> Object with the response.
	 * 
	 */
	@Override
	public ResponseEntity<ApiResult> getItem(long itemId) {
		
		log.info("-- getItem {} --",itemId);
		
		Optional<Item> item = itemRepository.findById(itemId);
		if(item.isPresent())
			return  new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.OK.value()),SUCCESS,item.get()), HttpStatus.OK); 
		
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.NOT_FOUND.value()),ITEM_NOT_FOUND,null), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method return a List items in base two parameters.
	 * 
	 * @param itemStatus Item status to search, can be AVAILABLE or SOLD
	 * @param itemName Name of item to search, ignore case.
	 * @return ResponseEntity<> Object with the response.
	 * 
	 */
	@Override
	public ResponseEntity<ApiResult> getItems(ItemStatus itemStatus, String itemName) {
		
		log.info("-- getItems by {} and {} --",itemStatus,itemName);
		
		return new ResponseEntity<>(generateApiResult(String.valueOf(HttpStatus.OK.value()),SUCCESS,itemRepository.findByItemStatusAndItemNameIgnoreCase(itemStatus,itemName)),HttpStatus.OK);
		
	}

	ApiResult generateApiResult(String code, String message, Object data){
		return new ApiResult(code,message,data);
	}
	
}
