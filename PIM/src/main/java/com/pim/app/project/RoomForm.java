package com.pim.app.project;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pim.domain.entity.Employees;
import com.sun.istack.NotNull;


public class RoomForm {
	
	@GeneratedValue
	@Id
	private int id ;
	
	private String branch ;
	
	private int building ;
	
	private int floor ;
	
	private int capacity ;
	
	private String name ;
	
	private boolean statuRoom ;
	
	private Date  bookDate ;
	
	public RoomForm(int id , 
			String branch , 
			int building , 
			int floor, 
			int capacity, 
			String name,
			boolean statuRoom,
			Date bookDate
			) 
	{
		this.id = id ;
		this.branch = branch;
		this.building = building;
		this.floor = floor ;
		this.capacity = capacity ;
		this.name = name ;
		this.statuRoom = statuRoom ;
		this.bookDate = bookDate ;
	}
	
	public RoomForm() {
		
	}
	
	

	public boolean getStatuRoom() {
		return statuRoom;
	}

	public void setStatuRoom(boolean statuRoom) {
		this.statuRoom = statuRoom;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
