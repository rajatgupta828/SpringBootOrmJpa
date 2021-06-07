package com.rajat.learning.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rajat.learning.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	

}
