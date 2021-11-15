package test.services.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.tracker.project.projecttracker.services.impl.MailServiceImpl;

@Configuration
public class MailServiceTestConfiguration {

	@Bean
	@Primary
	public MailServiceImpl MailServiceImpl() {
		return Mockito.mock(MailServiceImpl.class);
	}
	
}
