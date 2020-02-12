package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.controller.SafetyNetAlertsPersonController;

@Component
public class HealthCheck implements HealthIndicator {

	@Autowired
	
	SafetyNetAlertsPersonController safetyNetAlertsPersonController;
	
	@Override
	public Health health() {
		
		if(safetyNetAlertsPersonController.getPersonByInfo("John", "Boyd").isEmpty()) {
			return Health.down().withDetail("Cause", "Information is not available").build();
		} 
		return Health.up().build();
	}

}
