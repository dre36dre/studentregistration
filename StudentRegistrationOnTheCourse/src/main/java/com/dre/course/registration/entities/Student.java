package com.dre.course.registration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_student")
public class Student {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String email;
private String name;
private int registration;

@ManyToOne
@JoinColumn(name="course_id")
private Course course;

public Student() {
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getRegistration() {
	return registration;
}

public void setRegistration(int registration) {
	this.registration = registration;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



}
