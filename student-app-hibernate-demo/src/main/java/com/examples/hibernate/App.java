package com.examples.hibernate;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.examples.hibernate.dao.StudentDao;
import com.examples.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        StudentDao studDao = new StudentDao();
        
        //Saving the student
        Student stud = new Student("John", "John@gmail.com", 20);
       studDao.saveStudent(stud);
        
        
        //Fetch all students
        List<Student> studs =  studDao.getAllStudents();
        
        //Fetch individual student
        Student stu = studDao.getStudentById(1);
        System.out.println(stu.getName()+"\t "+stu.getEmail());
        
        //Update the student
        
        Student maxAge = studDao.findMaxAgeStudentUsingCriteria();
      //  System.out.println(maxAge.getName()+"\t "+maxAge.getEmail());
        
        
        Student maxAgeQuery = studDao.findMaxAgeStudentUsingQuery();
        
        
//        Scanner sc = new Scanner(System.in);
//        System.out.println(" Enter stud id to delete");
//        int stuId = sc.nextInt();
//  
//        studDao.removeStudent(stuId);

        
        Student minAge = studDao.findMinAgeStudentUsingCriteria();
      //  System.out.println(minAge.getName()+"\t "+minAge.getEmail());
        
        
        Student minAgeQuery = studDao.findMinAgeStudentUsingQuery();
      //  System.out.println(minAgeQuery.getName()+"\t "+minAgeQuery.getEmail());
        
        
        Double avgAge = studDao.findAverageAgeUsingCriteria();
     //   System.out.println("Average Age using criteria : "+avgAge);
        Double avgAgeQuery = studDao.findAverageAgeUsingQuery();
      //  System.out.println("Average Age using query : "+avgAgeQuery);
        
        
        
        Long sumAge = studDao.findSumAgeUsingCriteria();
      //  System.out.println("Sum Age using criteria : "+sumAge);
        Long sumAgeQuery = studDao.findSumAgeUsingQuery();
      //  System.out.println("Sum Age using query : "+sumAgeQuery);
        
               
        
        
        System.out.println(" Student App Statistics");
        System.out.println(" List of All students ");
        System.out.println(" ***************************************** ");
        studs.forEach(s-> System.out.println(s.getName()));
        System.out.println(" ***************************************** ");
        System.out.println(" Student App - Aggregate Function Results");
        
        System.out.println(" Max age student by criteria");
        System.out.println(maxAge.getName()+"\t "+maxAge.getEmail());
        System.out.println(" Max age student by query");
        System.out.println(maxAgeQuery.getName()+"\t "+maxAgeQuery.getEmail());
        
        System.out.println(" Min age student by criteria");
        System.out.println(minAge.getName()+"\t "+minAge.getEmail());
        System.out.println(" Min age student by query");
        System.out.println(minAgeQuery.getName()+"\t "+minAgeQuery.getEmail());
        
        
        System.out.println(" Average age  by criteria : "+avgAge);
        System.out.println(" Average age  by query : "+avgAgeQuery);
        
        System.out.println("Sum Age using criteria : "+sumAge);
        System.out.println("Sum Age using query : "+sumAgeQuery);
        
        
    }
}
