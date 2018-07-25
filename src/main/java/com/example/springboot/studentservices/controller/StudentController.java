package com.example.springboot.studentservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.studentservices.model.Course;
import com.example.springboot.studentservices.model.Student;
import com.example.springboot.studentservices.response.CourseEnrollmentResponse;
import com.example.springboot.studentservices.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student-service/ListAllStudents")
	public List<Student> listAllStudents() {
		return studentService.retrieveAllStudents();
	}
	
	@RequestMapping("/student-service/ListAllCourses")
	public List<Course> listAllCourses() {
		return studentService.retrieveAllCourses();
	}
	
	@RequestMapping("/student-service/student/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@RequestParam(value="studentId") String studentId, @RequestParam(value="courseId") String courseId) {
		return studentService.retrieveCoursesForStudent(Long.valueOf(studentId));
	}
	
	@RequestMapping("/student-service/student/{studentId}/course/{courseId}")
	public CourseEnrollmentResponse retrieveCourseDetailsForStudent(@RequestParam(value="studentId") String studentId, @RequestParam(value="courseId") String courseId) {
		return studentService.retrieveCourseDetailsForStudent(Long.valueOf(studentId), Long.valueOf(courseId));
	}

}
