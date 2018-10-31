package com.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private Address address;
	private List<String> hobby;
	private Map<String, String> job;
	private String[] friends;
	private BigDecimal salary;
	

	
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public Map<String, String> getJob() {
		return job;
	}

	public void setJob(Map<String, String> job) {
		this.job = job;
	}

	public String[] getFriends() {
		return friends;
	}

	public void setFriends(String[] friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", address=" + address + ", hobby=" + hobby + ", job=" + job
				+ ", friends=" + Arrays.toString(friends) + ", salary=" + salary;
	}

	
}
