package com.revature.waterplant_webapp.model;

public class Order {
	
	private int orderId;
	private int userId;
	private int reserveId;
	private String name;
	private long mobileNo;
	private String address;
	private int orderCans;
	private String orderStatus;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOrderCans() {
		return orderCans;
	}
	public void setOrderCans(int orderCans) {
		this.orderCans = orderCans;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", reserveId=" + reserveId + ", name=" + name
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", orderCans=" + orderCans + ", orderStatus="
				+ orderStatus + "]";
	}
	
	

}
