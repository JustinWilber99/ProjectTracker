package test.services.impl;

import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tracker.project.projecttracker.services.impl.ProjectServiceImpl;

@SpringBootTest
public class ProjectServiceImplTest {

	@Autowired
	ProjectServiceImpl ps;
	
	
	@Before(value = "test")
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void testFindAll() {

		assertTrue(true);
	}
	
	
	@Test
	public void testFindById() {

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

	
}
