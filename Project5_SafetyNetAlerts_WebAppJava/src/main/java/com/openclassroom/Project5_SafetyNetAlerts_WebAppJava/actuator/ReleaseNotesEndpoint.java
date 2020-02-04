package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="release-notes")
public class ReleaseNotesEndpoint {
	
	String version10 = "** Version 1.0 ** \n\n "
			+ "* Homepage added \n"
			+ "* Models added \n"
			+ "* Json data imported \n"
			+ "* Endpoints added \n";
    
	@ReadOperation
	public String releaseNotes() {
		
		return version10;
	}
}
