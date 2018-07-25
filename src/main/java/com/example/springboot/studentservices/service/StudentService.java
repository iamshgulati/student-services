package com.example.springboot.studentservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.studentservices.model.Course;
import com.example.springboot.studentservices.model.Registrar;
import com.example.springboot.studentservices.model.Student;
import com.example.springboot.studentservices.response.CourseEnrollmentResponse;

@Component
public class StudentService {
	
	@Autowired
	private Registrar registrar;
	
	public void addStudent(Student student) {
		registrar.addStudent(student);
	}
	
	public void addCourse(Course course) {
		registrar.addCourse(course);
	}
	
	public void registerForCourse(Long studentId, Long courseId) {
		registrar.registerForCourse(studentId, courseId);
	}
	
	public List<Student> retrieveAllStudents() {
		return registrar.retrieveAllStudents();
	}
	
	public Student retrieveStudentDetails(Long studentId) {
		return registrar.retrieveStudent(studentId);
	}
	
	public List<Course> retrieveAllCourses() {
		return registrar.retrieveAllCourses();
	}
	
	public Course retrieveCourseDetails(Long courseId) {
		return registrar.retrieveCourse(courseId);
	}
	
	public List<Student> retrieveStudentsForCourse(Long courseId) {
		List<Student> studentsList = new ArrayList<>();
		List<Long> enrolledStudentsIdList = registrar.retrieveStudentsEnrolledForCourse(courseId);
		for(Long studentId:enrolledStudentsIdList) {
			Student student = registrar.retrieveStudent(studentId);
			studentsList.add(student);
		}
		return studentsList;
	}

	public List<Course> retrieveCoursesForStudent(Long studentId) {
		List<Course> coursesList = new ArrayList<>();
		List<Long> enrolledCoursesIdList = registrar.retrieveCoursesForStudent(studentId);
		for(Long courseId:enrolledCoursesIdList) {
			Course course = registrar.retrieveCourse(courseId);
			coursesList.add(course);
		}
		return coursesList;
	}

	public CourseEnrollmentResponse retrieveCourseDetailsForStudent(Long studentId, Long courseId) {
		CourseEnrollmentResponse response = null;
		Course course = null;
		Student student = null;
		student = registrar.retrieveStudent(studentId);
		if(student.getEnrolledCoursesMap().containsKey(courseId)) {
			course = registrar.retrieveCourse(courseId);
		}
		response = new CourseEnrollmentResponse();
		response.setCourseId(course.getCourseId());
		response.setCourseName(course.getCourseName());
		response.setEnrollmentDate(student.getEnrolledCoursesMap().get(courseId));
		return response;
	}

}
