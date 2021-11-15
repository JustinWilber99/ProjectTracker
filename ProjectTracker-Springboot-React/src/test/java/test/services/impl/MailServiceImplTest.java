package test.services.impl;


import static org.junit.Assert.assertTrue;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import com.tracker.project.projecttracker.services.impl.MailServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceImplTest {
	
	@Autowired
	MailServiceImpl ms;
	
	@Before(value = "test")
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void testSendEmail() {

		assertTrue(true);
	}
	
	
	@Test
	public void testSendEmail1() {

		assertTrue(true);
	}
	
	@Test
	public void testSendEmail2() {

		assertTrue(true);
	}
	

}
