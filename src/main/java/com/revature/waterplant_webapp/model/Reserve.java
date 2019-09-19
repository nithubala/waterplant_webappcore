package com.revature.waterplant_webapp.model;

public class Reserve {
	
	private int reserveId;
	private int userId;
	private String name;
	private long mobileNo;
	private int reserveCans;
	private String reserveStatus;
	private String orderCans;
	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getReserveCans() {
		return reserveCans;
	}
	public void setReserveCans(int reserveCans) {
		this.reserveCans = reserveCans;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public String getOrderCans() {
		return orderCans;
	}
	public void setOrderCans(String orderCans) {
		this.orderCans = orderCans;
	}
	@Override
	public String toString() {
		return "Reserve [reserveId=" + reserveId + ", userId=" + userId + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", reserveCans=" + reserveCans + ", reserveStatus=" + reserveStatus + ", orderCans=" + orderCans
				+ "]";
	}

}
