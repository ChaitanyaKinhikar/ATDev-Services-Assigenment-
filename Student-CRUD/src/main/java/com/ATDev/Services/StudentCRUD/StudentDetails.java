package com.ATDev.Services.StudentCRUD;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class StudentDetails {

	@Id
	private int id;
	private String name;
	private String dept;
	private String year;
	private String rank;

	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDetails(int id, String name, String dept, String year, String rank) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.year = year;
		this.rank = rank;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", dept=" + dept + ", year=" + year + ", rank=" + rank
				+ "]";
	}

}
