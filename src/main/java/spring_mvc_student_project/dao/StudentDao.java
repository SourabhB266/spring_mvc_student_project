package spring_mvc_student_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mvc_student_project.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	private EntityManager entityManager;

	public Student saveStudent(Student student) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(student);
		transaction.commit();
		return student;
	}

	public List<Student> getAllStudents() {
		Query query = entityManager.createQuery("select s from Student s");
		List<Student> list = query.getResultList();
		return list;
	}

	public boolean deleteStudent(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			transaction.begin();
			entityManager.remove(student);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Student getStudentById(int id) {
		return entityManager.find(Student.class, id);
	}

	public Student updateStudent(Student student) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(student);
		transaction.commit();
		return student;

	}
}
