package com.onlinelearning.apiGateway;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
public class ServlrtInitilizer extends SpringBootServletInitializer {
     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApiGatewayApplication.class);
    }
}
