package com.school.controller;

import com.school.dto.Student;
import com.school.service.StudentService;

public class TestDelete {

	public static void main(String[] args) {


		StudentService studentService=new StudentService();
		
		boolean a=studentService.deleteStudentById(1);
		
		System.out.println(a);
		
		
	}

}
