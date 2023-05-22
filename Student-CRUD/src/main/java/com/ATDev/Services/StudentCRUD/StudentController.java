package com.ATDev.Services.StudentCRUD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;

@RestController
public class StudentController {

	ArrayList<StudentDetails> al = new ArrayList<>();

	@Autowired
	SessionFactory sf;
	StudentDetails stud;

	@PostMapping("Insert_Data") // TO CREATE DATA
	StudentDetails addStudent(@RequestBody StudentDetails student) {

		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		ss.save(student);
		System.out.println("Record Inserted Successfully Done... " + student);
		tx.commit();
		return student;
	}

	@GetMapping("Get_Data/{id}") // TO READ DATA
	public StudentDetails getStudent(@PathVariable int id) {

		Session ss = sf.openSession();
		stud = ss.load(StudentDetails.class, id);
		System.out.println(stud);

		StudentDetails student = stud;
		for (StudentDetails ss1 : al) {
			if (ss1.getId() == id) {
				student = ss1;
			}
		}
		System.out.println("One Record Show Successfully Done... " + student);
		return student;
	}

	@PutMapping("Update_Data") // TO UPDATE THE DATA
	StudentDetails updateStudent(@RequestBody StudentDetails student) {

		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		ss.update(student);
		System.out.println("Record Updated Successfully Done... " + student);
		tx.commit();
		return student;
	}

	@DeleteMapping("deleteStudent/{id}") // TO DELETE THE DATA
	public int deleteStudent(@PathVariable int id) {

		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		stud = ss.load(StudentDetails.class, id);
		System.out.println(stud);

		ss.delete(stud);

		System.out.println("Record Deleted Successfully Done... " + id);
		tx.commit();
		return id;
	}

	@RequestMapping("Show all data") // TO SHOW ALL THE DATA PRESENT IN TABLE
	public List<StudentDetails> show() {
		Session ss = sf.openSession();
		Query q1 = ss.createQuery("from StudentDetails"); // USE TO SHOW ALL INFO OF TABLE (MULTI RECORDS)...
		List<StudentDetails> l1 = q1.getResultList();
		return l1;
	}

}
