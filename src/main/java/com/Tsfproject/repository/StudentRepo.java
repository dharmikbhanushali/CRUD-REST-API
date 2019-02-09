package com.Tsfproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tsfproject.model.StudentModel;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Long>{

	void deleteById(int id);
	
	
}

