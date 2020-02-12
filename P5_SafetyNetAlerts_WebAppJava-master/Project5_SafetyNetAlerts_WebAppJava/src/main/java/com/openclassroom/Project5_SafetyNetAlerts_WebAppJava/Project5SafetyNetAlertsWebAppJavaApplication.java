package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ParseJsonData;

@SpringBootApplication
public class Project5SafetyNetAlertsWebAppJavaApplication {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IOException {
		ParseJsonData.main(args);
		SpringApplication.run(Project5SafetyNetAlertsWebAppJavaApplication.class, args);
	}

}
