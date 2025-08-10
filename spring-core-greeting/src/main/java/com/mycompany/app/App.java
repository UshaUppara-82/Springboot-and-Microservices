package com.mycompany.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.model.TechnicalWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //Load the Spring Context - Creating the Spring Container
      //  ApplicationContext context = new ClassP
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        
        //GreetingService greetService = new GreetingService()
        //Fetch the bean using id which defined in the context / beans xml
		/*
		 * GreetingService greetService = (GreetingService)
		 * context.getBean("greetingService");
		 * 
		 * WelcomeService welcomeService = (WelcomeService)
		 * context.getBean("welcomeService"); //(int) -
		 * 
		 * // System.out.println(greetService.hello());
		 * System.out.println(welcomeService.welcome());
		 * 
		 * welcomeService.sayWelcomeWithMessage();
		 * 
		 * //Accessing with class - constructor based injection Book book =
		 * context.getBean(Book.class); System.out.println(book); book.setId(7895);
		 * book.setName("Spring Tutorials"); System.out.println(book);
		 * 
		 * //setter based injection Address addr = context.getBean(Address.class);
		 * 
		 * 
		 * Employee emp = context.getBean(Employee.class); //emp.setAddress(addr);
		 * System.out.println("Employee Name :"+emp.getName());
		 * System.out.println("Employee Number :"+emp.getEmployeeNumber());
		 * System.out.println("Employee Address :"+emp.getAddress());
		 * 
		 * Customer c1 = (Customer) context.getBean("customer1");
		 * System.out.println(" output: " + c1);
		 * 
		 * Customer c2 = (Customer) context.getBean("customer2");
		 * System.out.println(" output: " + c2);
		 * 
		 * 
		 * Mentor m1 = (Mentor) context.getBean("mentor1"); m1.display();
		 * 
		 * List<String> modules = new ArrayList<>(); modules.add("Spring");
		 * modules.add("React"); m1.setModules(modules); m1.display();
		 * 
		 * EmailNotification email = context.getBean(EmailNotification.class);
		 * email.sendNotification("Monday Morning Meeting scheduled @ 11 am");
		 * 
		 * SMSNotification sms = context.getBean(SMSNotification.class);
		 * sms.sendNotification("Meeting postponded to 12 pm");
		 * 
		 * //property based injection Car car = context.getBean(Car.class);
		 * System.out.println(car);
		 * 
		 * 
		 */       
		/*
		 * Character charObj = context.getBean(Character.class);
		 * System.out.println(charObj.getName());
		 * 
		 * context.registerShutdownHook();
		 * 
		 * 
		 * BlogService blogService = context.getBean(BlogService.class);
		 * blogService.start(); System.out.println(blogService.hashCode());
		 * 
		 * BlogService blogServiceOneMore = context.getBean(BlogService.class);
		 * System.out.println(blogServiceOneMore.hashCode());
		 * 
		 * 
		 * TechnicalWriter technical = context.getBean(TechnicalWriter.class);
		 * technical.write(); technical.getAward();
		 * System.out.println(technical.hashCode());
		 * 
		 * TechnicalWriter technicalOneMore = context.getBean(TechnicalWriter.class);
		 * System.out.println(technicalOneMore.hashCode());
		 */ 
        Book b = context.getBean(Book.class);
        System.out.println(b);
        
        Employee emp = context.getBean(Employee.class);
        System.out.println(emp);
        
        
        TechnicalWriter technical1 = context.getBean(TechnicalWriter.class);
        System.out.println(technical1.hashCode());
    }
    
    
}
