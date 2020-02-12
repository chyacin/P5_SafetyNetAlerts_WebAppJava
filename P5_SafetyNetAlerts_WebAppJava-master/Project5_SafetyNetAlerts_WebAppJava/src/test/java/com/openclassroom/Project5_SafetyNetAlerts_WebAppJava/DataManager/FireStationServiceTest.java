package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.DataManager;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.FireStationService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;

@RunWith(MockitoJUnitRunner.class)
public class FireStationServiceTest {

	@Mock
	FireStationService fireStationService;
	@Mock
	FireStation fireStation;
	
	@InjectMocks
	ApplicationData applicationData;
	
	@Test
	public void createFSAddressMapping_returnFSAddressMapping() {
		
		//Arrange
		FireStation fireStation = new FireStation();
		fireStation.setAddress("188 Culver St");
		fireStation.setStationNumber("2");
		
		//Act
		FireStationService.createFireStationAddressMapping("2", "188 Culver St");
	
		//Assert
		Mockito.verify(fireStationService, times(1));
		
	}
	@Test
	public void updateFSAddressMapping_returnFSAddressMapping() {
		
		//Arrange
		FireStation fireStation = new FireStation();
		fireStation.setAddress("175 Culver St");
		fireStation.setStationNumber("3");
		
		//Act
	    
		FireStationService.updateAddressFireStationNumber("2", "175 Culver St");
	
		//Assert
		assertEquals("2", fireStationService.getStationFromStationAddress("175 Culver St").getStationNumber());
	}
	
	
}
