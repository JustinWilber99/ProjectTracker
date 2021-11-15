package com.tracker.project.projecttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.tracker.project.projecttracker.logging.Logging;

@SpringBootApplication
public class ProjectTrackerApplication {

    public static void main(String[] args) {
    	
    	SpringApplication.run(ProjectTrackerApplication.class, args);
    	
    	Logging.logDebugMessage("Application Start up...");

    }


}
