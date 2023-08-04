package com.example.demo.Task.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks") // Set the table name to "tasks"
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment for the primary key,can not used data type String for id
    private Long id; // Changed the type of id to Long to support auto-increment

    @Column(name = "Task_title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

	//geter and setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	//to String 
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getDueDate()=" + getDueDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	//cunstroctor
	public Task(Long id, String title, String description, Date dueDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}

    
}
