package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.ControllerTest;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.DataManager;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ParseJsonData;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SafetyNetAlertsControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webContext;
	
	@Autowired
	private DataManager dataManager;
	private ParseJsonData parseJsonData;
	private Person person;
	
	@Before
	public void setupMockmvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
}	
