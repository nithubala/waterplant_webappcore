package com.revature.waterplant_webapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Stock {
	private int availableCans;
	private int oderedCans;
	private int reservedCans;
	private int cans;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private LocalDate date;
	
	public int getOderedCans() {
		return oderedCans;
	}

	public void setOderedCans(int oderedCans) {
		this.oderedCans = oderedCans;
	}

	public int getReservedCans() {
		return reservedCans;
	}

	public void setReservedCans(int reservedCans) {
		this.reservedCans = reservedCans;
	}

	public int getCans() {
		return cans;
	}

	public void setCans(int cans) {
		this.cans = cans;
	}
	
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAvailableCans() {
		return availableCans;
	}

	public void setAvailableCans(int availableCans) {
		this.availableCans = availableCans;
	}

	@Override
	public String toString() {
		return "Stock [availableCans=" + availableCans + ", oderedCans=" + oderedCans + ", reservedCans=" + reservedCans
				+ ", cans=" + cans + ", date=" + date + "]";
	}
	

}
