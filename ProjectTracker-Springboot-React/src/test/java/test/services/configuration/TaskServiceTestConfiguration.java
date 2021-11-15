package test.services.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.tracker.project.projecttracker.services.impl.TaskServiceImpl;


@Configuration
public class TaskServiceTestConfiguration {

	@Bean
	@Primary
	public TaskServiceImpl TaskServiceImpl() {
		return Mockito.mock(TaskServiceImpl.class);
	}
}



	

