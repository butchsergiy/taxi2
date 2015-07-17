package com.edvantis.jt.case14.model.data;

import java.sql.Timestamp;


 
public class Order implements java.io.Serializable{
	
	private static final long serialVersionUID = 3714126590731329262L;
	

	private Integer id;
	private Timestamp dateAndTime;
	private String addr1, addr2, addr34;
	private float distance;
	private float orderCost;
	private String customerPhone;
	private String customerName;
	private String carNumber;
	private String carDriver;
	private Boolean isDone;
	
	
	public Order() {
	}

	public Order(int orderID) {
		this.id = orderID;
	}

	public Order(int orderID, Timestamp dateAndTime, String addr1, String addr2,
			String addr34, float distance, float orderCost,
			String customerPhone, String customerName, String carNumber,
			String carDriver, Boolean isDone) {
		this.id = orderID;
		this.dateAndTime = dateAndTime;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr34 = addr34;
		this.distance = distance;
		this.orderCost = orderCost;
		this.customerPhone = customerPhone;
		this.customerName = customerName;
		this.carNumber = carNumber;
		this.carDriver = carDriver;
		this.isDone = isDone;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer orderNum) {
		this.id = orderNum;
	}
	
	public Timestamp getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getAddr34() {
		return addr34;
	}
	
	public void setAddr34(String addr34) {
		this.addr34 = addr34;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public float getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public String getCarDriver() {
		return carDriver;
	}
	
	public void setCarDriver(String carDriver) {
		this.carDriver = carDriver;
	}
	
	public Boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	public void printOrder(){
			System.out.println();
			System.out.println("Order ID= \t"+id);
			System.out.println("Date and time :\t"+dateAndTime);
			System.out.println("Adress 1: \t"+addr1);
			System.out.println("Adress 2: \t"+addr2);
			System.out.println("Adress 34: \t"+addr34);
			System.out.println(" km: \t"+distance);
			System.out.println(" grn: \t"+orderCost);
			System.out.println(" customerPhone \t"+customerPhone);
			System.out.println(" customer Name \t"+customerName);
			System.out.println(" car driver: \t"+carDriver); 
			System.out.println(" car number: \t"+carNumber);
			System.out.println(" is done: \t"+isDone);
			}
}
