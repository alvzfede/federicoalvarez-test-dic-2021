package com.applaudo.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "APPLAUDO_ITEM")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 7457009100391972878L;
	
	private Long itemId;
	private String itemName;
	private String itemEnteredByUser;
	private LocalDateTime itemEnteredDate;
	private double itemBuyingPrice;
	private double itemSellingPrice;
	private LocalDateTime itemLastModifiedDate;
	private String itemLastModifiedByUser;
	private ItemStatus itemStatus;
	
	@Id
	@Column(name="ItemId")
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@NotNull
	@Column(name="ItemName")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@NotNull
	@Column(name="ItemEnteredByUser")
	public String getItemEnteredByUser() {
		return itemEnteredByUser;
	}
	public void setItemEnteredByUser(String itemEnteredByUser) {
		this.itemEnteredByUser = itemEnteredByUser;
	}
	
	@NotNull
	@Column(name="ItemEnteredDate")
	public LocalDateTime getItemEnteredDate() {
		return itemEnteredDate;
	}
	public void setItemEnteredDate(LocalDateTime itemEnteredDate) {
		this.itemEnteredDate = itemEnteredDate;
	}
	
	@NotNull
	@Column(name="ItemBuyingPrice")
	public double getItemBuyingPrice() {
		return itemBuyingPrice;
	}
	public void setItemBuyingPrice(double itemBuyingPrice) {
		this.itemBuyingPrice = itemBuyingPrice;
	}
	
	@NotNull
	@Column(name="ItemSellingPrice")
	public double getItemSellingPrice() {
		return itemSellingPrice;
	}
	public void setItemSellingPrice(double itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}
	
	@NotNull
	@Column(name="ItemLastModifiedDate")
	public LocalDateTime getItemLastModifiedDate() {
		return itemLastModifiedDate;
	}
	public void setItemLastModifiedDate(LocalDateTime itemLastModifiedDate) {
		this.itemLastModifiedDate = itemLastModifiedDate;
	}
	
	@NotNull
	@Column(name="ItemLastModifiedByUser")
	public String getItemLastModifiedByUser() {
		return itemLastModifiedByUser;
	}
	public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
		this.itemLastModifiedByUser = itemLastModifiedByUser;
	}
	
	@NotNull
	@Column(name="ItemStatus")
	public ItemStatus getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}
	
}
