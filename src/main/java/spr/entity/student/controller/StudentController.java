package spr.entity.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spr.entity.Student;
import spr.entity.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService stdservice;

	@GetMapping("/")
	public String index() {
		return "students";
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", stdservice.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		stdservice.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", stdservice.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from database by id
		Student existingStudent = stdservice.getStudentById(id);
		int index = id.intValue();
		existingStudent.setId(index);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		stdservice.updateStudent(existingStudent);
		return "redirect:/students";
	}

	// handler method to handle delete student request

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		stdservice.deleteStudentById(id);
		return "redirect:/students";
	}

}
