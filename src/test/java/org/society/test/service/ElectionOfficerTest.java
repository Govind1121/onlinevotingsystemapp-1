package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.repository.ElectionOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionOfficerTest {
	
	@Autowired
	private ElectionOfficerDao eoservice;
	
	@MockBean
	private ElectionOfficerRepository repo;
	
	@Test
	@DisplayName("Test for adding Election officer in database")
	public void addElectionOfficerDetailsTest() {
		//when - then
		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "lsfj", "male", "5555", "jsfj", "lsjf", "jsflj", "null", 0);
		when(repo.save(officer)).thenReturn(officer);
		assertEquals(officer, eoservice.save(officer));
		
		
		
		
		
	}

}
