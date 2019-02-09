package com.Tsfproject.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tsfproject.model.StudentModel;
import com.Tsfproject.repository.StudentRepo;

@RestController
@RequestMapping("/")


public class StudentController {
	StudentModel studModel;
	
	
	@Autowired
	StudentRepo studRepo;
	
	@GetMapping("students")
	private List<StudentModel> getAll()
	{
		return studRepo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Optional<StudentModel> findstudent(@Valid @PathVariable long id)
	{
		return studRepo.findById(id);
	}
	
	@PostMapping("addStudent")
	private StudentModel createStud(@Valid @RequestBody StudentModel studM)
	{
		return studRepo.save(studM);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent (@Valid @PathVariable long id)
	{
		Optional<StudentModel> studentModel = findstudent(id);
		if(studentModel.isPresent())
			studRepo.deleteById(id);
		
			
	}
	
	@PutMapping("students/{id}")
	public void UpdateStud(@Valid @RequestBody StudentModel student, @PathVariable long id) 
	{
		Optional<StudentModel> studentOptional = studRepo.findById(id);
		
		student.setId(id);
		
		studRepo.save(student);


	}
}
