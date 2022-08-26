package spr.entity.student.service;

import java.util.List;

import spr.entity.Student;

public interface StudentServiceInterface {
	
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(Long id);

}
