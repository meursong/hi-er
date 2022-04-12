package com.mulcam.hier.dto;

import java.sql.Date;

public class Orders {
	private int order_id;
	private int order_status;
	private int buyer_id;
	private int seller_id;
	private int product_id;
	private Date createdAt;
	private String order_pkg;
	private int delivery_date;
	private int order_qty;
	private int order_price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getOrder_pkg() {
		return order_pkg;
	}
	public void setOrder_pkg(String order_pkg) {
		this.order_pkg = order_pkg;
	}
	public int getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(int delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	
	
}
