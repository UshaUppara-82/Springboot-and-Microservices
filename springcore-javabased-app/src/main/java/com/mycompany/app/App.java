package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.config.ApplicationConfiguration;
import com.mycompany.app.model.Author;
import com.mycompany.app.model.Country;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Mentor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
       // ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        
        Country country = (Country) context.getBean("countryObj");
        
        System.out.println(country);
        
        
        System.out.println(country.getCountryName());
        
        
        Author author = (Author) context.getBean(Author.class);
        
        System.out.println(author);
        
        
        System.out.println(author.getAuthorAddress());
        
        
        Mentor mentor = (Mentor)context.getBean(Mentor.class);
        mentor.display();
        
        
        Employee  emp = (Employee)context.getBean(Employee.class);
        System.out.println(emp);
        
        
        //Constructor based injection
        Country count = context.getBean("getCountryWithState", Country.class);
        
        System.out.println(count);
        
    }
}
