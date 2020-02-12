package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.ControllerTest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.PersonService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonContollerTest {
	
    private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webContext;
	
	
	@Autowired
	private  Person person;
	@Autowired
	private ApplicationData applicationData;
	
	@Before
	public void setupMockmvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
//	@Test
//	public void CreatePerson() {
//		
//		person = new Person();
//		
//		person.setFirstName("Jason");
//		person.setLastName("Bourne");
//		person.setAddress("188 Culver St");
//		person.setCity("Culver");
//		person.setZip("97451");
//		person.setPhone("897-890-1212");
//		person.setEmail("jason@email.com");
//		
//		person = applicationData.persons.add(person);
//		
		
	
	
	
	@Test
	public void testCreatePerson() throws Exception{
		mockMvc.perform(post("/person")
				.param("firstName", "Jason")
				.param("lastName", "Bourne")
				.param("address", "188 Culver St")
				.param("city", "Culver")
				.param("zip", "97451")
				.param("phone", "897-890-1212")
				.param("email", "jason@email"))
		        .andExpect(status().isOk())
		        .andExpect(model().errorCount(0));
		
	}
	
	@Test
	public void testDeletePerson() throws Exception{
		 mockMvc.perform(post("/person")
		        .param("first", person.getFirstName().toString())
		        .param("lastName", person.getLastName().toString()))
		        .andExpect(view().name("redirect:/person"))
		        .andExpect(model().errorCount(0))
		        .andExpect(status().is2xxSuccessful());
		        
	}

}
