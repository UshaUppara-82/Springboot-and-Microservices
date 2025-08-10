package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.model.DevelopmentDataSource;
import com.mycompany.app.model.Message;
import com.mycompany.app.model.Profile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        Message message = context.getBean(Message.class);
        System.out.println(message);
        message.printUsers();
        
        Profile profile = context.getBean(Profile.class);
        System.out.println(profile);
        profile.showDetails();
        
        
        
    }
}
