package com.example.webspring.test.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.webspring.application.WebspringApplication;
import com.example.webspring.application.service.HealthStatusService;
@SpringBootTest(classes=WebspringApplication.class)
public class HealthServiceTest {
@Autowired	
private HealthStatusService healthService;
@Test
public void readStatusTest() {
	var healthStatus = this.healthService.readHealthStatus();
	assertTrue(healthStatus.isSpringStatus());
	assertTrue(healthStatus.isTomcatStatus());
}
}
