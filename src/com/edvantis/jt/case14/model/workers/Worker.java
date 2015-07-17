package com.edvantis.jt.case14.model.workers;

import java.sql.Date;


public class Worker implements java.io.Serializable {

	public Worker(Integer id, String name, String position,
			Date birthDate, int accessLevel, String carNumber,
			String password, Boolean logget) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.birthDate = birthDate;
		this.accessLevel = accessLevel;
		this.carNumber = carNumber;
		this.password = password;
		this.logget = logget;
	}

		public Worker() {
	}

	public Worker(int id) {
		this.id = id;
	}
	
	
	private static final long serialVersionUID = 7462052656308925727L;
	
	private Integer id;
	private String 	name;
	private String 	position;
	private Date birthDate;
	private Integer accessLevel;
	private String 	carNumber;
	private String 	password;
	private Boolean logget;
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getLogget() {
		return logget;
	}
	
	public void setLogget(Boolean logget) {
		this.logget = logget;
	}
	
	
	
	
}
