package test.services.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.tracker.project.projecttracker.services.impl.ProjectServiceImpl;


@Configuration
public class ProjectServiceTestConfiguration {
	
	@Bean
	@Primary
	public ProjectServiceImpl rojectServiceImpl() {
		return Mockito.mock(ProjectServiceImpl.class);
	}
	
	
}
