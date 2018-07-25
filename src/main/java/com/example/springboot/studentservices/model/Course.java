package com.example.springboot.studentservices.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course {
	
	private Long courseId;
	private String courseName;
	private Map<Long, LocalDate> enrolledStudentsMap;
	
	public Course(Long courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.enrolledStudentsMap = new HashMap<>();
	}
	
	public Course(int courseId, String courseName) {
		this((Long)(long)courseId, courseName);
	}
	
	public Long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Map<Long, LocalDate> getEnrolledStudentsMap() {
		return enrolledStudentsMap;
	}
	
	public List<Long> viewEnrolledStudents() {
		return new ArrayList<>(enrolledStudentsMap.keySet());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof Course)) return false;
		Course c = (Course) obj;
		return this.courseId == c.courseId && Objects.equals(this.courseName, c.courseName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.courseId, this.courseName);
	}

}
