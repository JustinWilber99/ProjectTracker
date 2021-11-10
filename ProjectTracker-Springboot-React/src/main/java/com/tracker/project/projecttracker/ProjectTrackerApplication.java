package com.tracker.project.projecttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ProjectTrackerApplication {

    public static void main(String[] args) {
    	
    	while(true)
    	{
    		try
    		{
    		 SpringApplication.run(ProjectTrackerApplication.class, args);
    		}catch(Exception ex) 
    		{
    			ex.printStackTrace();
    		}
    	}
        
    }


}
