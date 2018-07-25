package com.example.springboot.studentservices.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Registrar {
	
	private Map<Long, Student> collectionOfStudents;
	private Map<Long, Course> collectionOfCourses;
	
	private static Registrar instance;
	
	private Registrar() {
		this.collectionOfStudents = new HashMap<>();
		this.collectionOfCourses = new HashMap<>();
		this.init();
	}
	
	private void init() {
		addStudent(new Student(1, "Shubham"));
		addStudent(new Student(2, "Ankit"));
		
		addCourse(new Course(101, "Advanced English"));
		addCourse(new Course(102, "Basic English"));
		
		registerForCourse(1, 101);
		registerForCourse(2, 102);
	}
	
	public static Registrar getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new Registrar();
			return instance;
		}
	}
	
	public Student retrieveStudent(Long studentId) {
		return collectionOfStudents.get(studentId);
	}
	
	public List<Long> retrieveCoursesForStudent(Long studentId) {
		return retrieveStudent(studentId).viewEnrolledCourses();
	}
	
	public void addStudent(Student student) {
		if(!collectionOfStudents.containsValue(student)) {
			this.collectionOfStudents.put(student.getStudentId(), student);
		}
	}
	
	public void removeStudent(Long studentId) {
		collectionOfStudents.remove(studentId);
	}
	
	public List<Student> retrieveAllStudents() {
		return new ArrayList<>(collectionOfStudents.values());
	}
	
	public Course retrieveCourse(Long courseId) {
		return collectionOfCourses.get(courseId);
	}
	
	public List<Long> retrieveStudentsEnrolledForCourse(Long courseId) {
		return retrieveCourse(courseId).viewEnrolledStudents();
	}
	
	public void addCourse(Course course) {
		if(!collectionOfCourses.containsValue(course)) {
			this.collectionOfCourses.put(course.getCourseId(), course);
		}
	}
	
	public void removeCourse(Long courseId) {
		collectionOfCourses.remove(courseId);
	}
	
	public List<Course> retrieveAllCourses() {
		return new ArrayList<>(collectionOfCourses.values());
	}
	
	public void registerForCourse(Long studentId, Long courseId) {
		if(collectionOfStudents.containsKey(studentId) && collectionOfCourses.containsKey(courseId)) {
			collectionOfStudents.get(studentId).getEnrolledCoursesMap().put(courseId, LocalDate.now());
			collectionOfCourses.get(courseId).getEnrolledStudentsMap().put(studentId, LocalDate.now());
		}
	}
	
	public void registerForCourse(int studentId, int courseId) {
		registerForCourse((Long)(long)studentId, (Long)(long)courseId);
	}
	
	public void unregisterFromCourse(Long studentId, Long courseId) {
		if(collectionOfStudents.containsKey(studentId) && collectionOfCourses.containsKey(courseId)) {
			collectionOfStudents.get(studentId).getEnrolledCoursesMap().remove(courseId);
		}
	}
}
