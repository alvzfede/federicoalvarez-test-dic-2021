package com.applaudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.applaudo.entity.Item;
import com.applaudo.entity.ItemStatus;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>{

	List<Item> findByItemStatusAndItemNameIgnoreCase(ItemStatus itemStatus, String itemName);

}
