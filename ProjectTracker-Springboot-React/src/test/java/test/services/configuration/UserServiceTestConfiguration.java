package test.services.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.tracker.project.projecttracker.services.impl.UserServiceImpl;


@Configuration
public class UserServiceTestConfiguration {

	@Bean
	@Primary
	public UserServiceImpl UserServiceImpl() {
		return Mockito.mock(UserServiceImpl.class);
	}
	
}
