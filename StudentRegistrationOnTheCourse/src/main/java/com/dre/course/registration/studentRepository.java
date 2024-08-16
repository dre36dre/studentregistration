package com.dre.course.registration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dre.course.registration.entities.Student;

public interface studentRepository extends JpaRepository<Student, Long> {
	
	

}
