package com.example.springboot.studentservices.response;

import java.time.LocalDate;

public class CourseEnrollmentResponse {
	
	private Long courseId;
	private String courseName;
	private LocalDate enrollmentDate;
	
	
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
	
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}
