package com.examples.hibernate.dao;

import org.hibernate.Session;

import java.math.BigInteger;
import java.util.List;


import org.hibernate.Transaction;

import com.examples.hibernate.entity.Student;
import com.examples.hibernate.util.HibernateUtil;


import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;

public class StudentDao {
	
	
	public void saveStudent(Student stud) {
		
		Transaction tx = null;
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			tx = session.beginTransaction();
			
			session.save(stud);
			
			tx.commit();
			System.out.println(" Saving the student details");
		
			
		
			session.close();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
	}
	
	public List<Student> getAllStudents(){
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		 return session.createQuery("from Student", Student.class).list();
	}
	
	public Student getStudentById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		 return session.createQuery("from Student where id= "+id, Student.class).getSingleResult();
		
		
	}
	public Student getStudentByAge(Integer stu) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		 return session.createQuery("from Student where age= "+stu, Student.class).getSingleResult();
		
		
	}
	
	public Student findMaxAgeStudentUsingCriteria() {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		CriteriaBuilder cb = HibernateUtil.getSessionFactory().getCriteriaBuilder();
		CriteriaQuery<Integer> critQuery = cb.createQuery(Integer.class);
		Root<Student> root = critQuery.from(Student.class);
		
		
		critQuery.select(cb.max(root.get("age")));
		Query stuQuery = session.createQuery(critQuery);
		List<Integer> maxAge = stuQuery.getResultList();
		System.out.println(maxAge);
		Integer stu = maxAge.get(0);
		Student maxAgeStu = getStudentByAge(stu);
		
		return maxAgeStu;
		
	}

	public Student findMaxAgeStudentUsingQuery() {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Integer maxAge = session.createQuery("select max(age) from Student", Integer.class).getSingleResult();
		
		System.out.println(maxAge);
		
		Student maxAgeStu = getStudentByAge(maxAge);
		
		return maxAgeStu; 
	}
	
	public void removeStudent(int studId) {
		Student stu = getStudentById(studId);
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		session.remove(stu);
		tx.commit();
		
		session.close();
			
	}

	public void updateStudent(int stuId) {
		
	}

	public Student findMinAgeStudentUsingCriteria() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		CriteriaBuilder cb = HibernateUtil.getSessionFactory().getCriteriaBuilder();
		CriteriaQuery<Integer> critQuery = cb.createQuery(Integer.class);
		Root<Student> root = critQuery.from(Student.class);
		
		
		critQuery.select(cb.min(root.get("age")));
		Query stuQuery = session.createQuery(critQuery);
		List<Integer> maxAge = stuQuery.getResultList();
		System.out.println(maxAge);
		Integer stu = maxAge.get(0);
		Student minAgeStu = getStudentByAge(stu);
		
		return minAgeStu;
		
	}

	public Student findMinAgeStudentUsingQuery() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Integer minAge = session.createQuery("select min(age) from Student", Integer.class).getSingleResult();
		
		System.out.println(minAge);
		
		Student minAgeStu = getStudentByAge(minAge);
		
		return minAgeStu;
	}

	public Double findAverageAgeUsingCriteria() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		CriteriaBuilder cb = HibernateUtil.getSessionFactory().getCriteriaBuilder();
		CriteriaQuery<Double> critQuery = cb.createQuery(Double.class);
		Root<Student> root = critQuery.from(Student.class);
		
		//Expression avgAge = cb.avg(root.get("age"));
		
		
		critQuery.multiselect(cb.avg(root.get("age")));
		//critQuery.select(cb.avg(root.get("age")));
	
		Query stuQuery = session.createQuery(critQuery);
		List<Double> ages = stuQuery.getResultList();
		System.out.println(ages);
		
		return ages.get(0);
	}

	public Double findAverageAgeUsingQuery() {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Double minAge = session.createQuery("select avg(age) from Student", Double.class).getSingleResult();
		
		System.out.println(minAge);
		
		//Student minAgeStu = getStudentByAge(minAge);
		
		return minAge;
	}

	public Long findSumAgeUsingCriteria() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		CriteriaBuilder cb = HibernateUtil.getSessionFactory().getCriteriaBuilder();
		CriteriaQuery<Long> critQuery = cb.createQuery(Long.class);
		Root<Student> root = critQuery.from(Student.class);
		
		//Expression avgAge = cb.avg(root.get("age"));
		
		
		critQuery.multiselect(cb.sum(root.get("age")));
		//critQuery.select(cb.avg(root.get("age")));
	
		Query stuQuery = session.createQuery(critQuery);
		List<Long> ages = stuQuery.getResultList();
		System.out.println(ages);
		
		return ages.get(0);
	}

	public Long findSumAgeUsingQuery() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Long sumAge = session.createQuery("select sum(age) from Student", Long.class).getSingleResult();
		//Go with pure SQL query from MySQL Workbench
		//session.createNativeQuery("").getResultList();
		System.out.println(sumAge);
		
		//Student minAgeStu = getStudentByAge(minAge);
		
		return sumAge; 
	}
}
