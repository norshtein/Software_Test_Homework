package main;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import test.TestManager;
import utils.CsvManipulator;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	try{
            SpringApplication.run(Application.class, args);	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
