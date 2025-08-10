package com.mycompany.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
      //Load the Spring Context - Creating the Spring Container
        //  ApplicationContext context = new ClassP
          ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
          
          
          //GreetingService greetService = new GreetingService()
          //Fetch the bean using id which defined in the context / beans xml
  		
  		  GreetingService greetService = (GreetingService)context.getBean("greetingService");
  		  System.out.println(greetService.hello());
    }
}
