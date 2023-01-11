package com.luv2code.servletdemo.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

	public static List<Student> getStudents(){
		
		// create an empty list
		List<Student> students = new ArrayList<>();
		
		// adding data
		students.add(new Student("Mary", "Public", "mary@public.com"));
		students.add(new Student("John", "Doe", "john@public.com"));
		students.add(new Student("Ajay", "Rao", "ajay@public.com"));
		
		// return the list
		return students;
		
	}
}
