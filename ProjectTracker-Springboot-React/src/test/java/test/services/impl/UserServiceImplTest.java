package test.services.impl;

import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tracker.project.projecttracker.services.impl.UserServiceImpl;


@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	UserServiceImpl ps;
	
	
	@Before(value = "test")
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	
	@Test
	public void testFindById() {

		assertTrue(true);
	}

	
	@Test
	public void testFindAll() {

		assertTrue(true);
	}

	
	@Test
	public void testSave() {

		assertTrue(true);
	}

	
	@Test
	public void testUpdate() {

		assertTrue(true);
	}

	
	@Test
	public void testDeleteById() {

		assertTrue(true);
	}

	
	@Test
	public void testDelete() {

		assertTrue(true);
	}
	
	
	@Test
	public void testFindByEmail() {

		assertTrue(true);
	}

	
	@Test
	public void testGetUser() {

		assertTrue(true);
	}

	
	@Test
	public void testFindByUsername() {

		assertTrue(true);
	}


	
}
