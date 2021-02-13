package com.pim.domain.entity;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@NotNull
	@Column(name="name")
	private String name;

	@NotNull
	@Column(name="pass")
	private String pass;

	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<meeting> roomList;

	@Column(name="createdDate")
	private Date createdDate;

	@Column(name="updatedDate")
	private Date updatedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
