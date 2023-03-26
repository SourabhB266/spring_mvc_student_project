package spring_mvc_student_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_student_project.dao.StudentDao;
import spring_mvc_student_project.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}

	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView();
		dao.saveStudent(student);
		List<Student> list = dao.getAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean b = dao.deleteStudent(id);
		if (b) {
			List<Student> list = dao.getAllStudents();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("display.jsp");
		} else {
			modelAndView.setViewName("home.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		Student student = dao.getStudentById(id);
		modelAndView.addObject(student);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView();
		dao.updateStudent(student);
		List<Student> list = dao.getAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
}
