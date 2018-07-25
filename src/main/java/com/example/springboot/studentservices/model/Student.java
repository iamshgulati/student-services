package com.example.springboot.studentservices.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {

	private Long studentId;
	private String studentName;
	private Map<Long, LocalDate> enrolledCoursesMap;
	
	public Student(Long studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.enrolledCoursesMap = new HashMap<>();
	}
	
	public Student(int studentId, String studentName) {
		this((Long)(long)studentId, studentName);
	}
	
	public Long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Map<Long, LocalDate> getEnrolledCoursesMap() {
		return enrolledCoursesMap;
	}
	
	public List<Long> viewEnrolledCourses() {
		return new ArrayList<>(enrolledCoursesMap.keySet());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) return true;
		if(!(obj instanceof Student)) return false;
		Student s = (Student) obj;
		return this.studentId == s.studentId && Objects.equals(this.studentName, s.studentName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.studentId, this.studentName);
	}
	
}
