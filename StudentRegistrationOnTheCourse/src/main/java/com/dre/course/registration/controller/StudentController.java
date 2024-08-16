package com.dre.course.registration.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dre.course.registration.studentRepository;
import com.dre.course.registration.entities.Student;

@RestController
@RequestMapping(value="students")
public class StudentController {
	
@Autowired	
studentRepository studentRepository;

@GetMapping
public List<Student> findAll(){
	List<Student> result=studentRepository.findAll();
	return result;
}

@GetMapping(value="/{id}")
public Student findById(@PathVariable Long id) {
	Student result=studentRepository.findById(id).get();
	return result;
	}

//Salvar
@PostMapping(value="{id}")
public Student insert(@RequestBody Student student) {
	Student result=studentRepository.save(student);
	return result;
}

//Update
@PutMapping("/{id")
public Student toUpdate(@PathVariable Long id, @RequestBody Student student ) {
	Student current= studentRepository.findById(id).get();
	BeanUtils.copyProperties(student, current,"id");
	return studentRepository.save(current);
}

//Delete
@DeleteMapping(value="delete")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id) {
	studentRepository.deleteById(id)								;
}
	
}
