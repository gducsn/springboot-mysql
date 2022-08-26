package spr.entity.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spr.entity.Student;
import spr.entity.repository.StudentRepository;


@Service
public class StudentService  implements StudentServiceInterface {

	@Autowired
	StudentRepository stdrepo;
	
	@Override
	public List<Student> getAllStudents() {

		return stdrepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {

		return stdrepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		int index = id.intValue();
		return stdrepo.findById(index).get();
	}

	@Override
	public Student updateStudent(Student student) {

		return stdrepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		int index = id.intValue();
		stdrepo.deleteById(index);
		
	}
	

}
