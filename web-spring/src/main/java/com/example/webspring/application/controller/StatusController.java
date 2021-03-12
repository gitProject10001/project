package com.example.webspring.application.controller;

import java.awt.PageAttributes.MediaType;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webspring.application.service.HealthStatusService;
import com.example.webspring.model.domain.HealthStatus;

@RequestMapping("/health")
@RestController
public class StatusController {
	@Inject
	private HealthStatusService healthStatusService;
	
	@GetMapping(produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
	public String getHealth() {
		var healthStatus = this.healthStatusService.readHealthStatus(); 
		StringBuilder message = new StringBuilder();
		message.append("Spring ");
		if(healthStatus.isSpringStatus()) {
			message.append(" Ok ");
		}
		else {
			message.append(" Warning ");
		}
		message.append("\nTomcat");
		if(healthStatus.isTomcatStatus()) {
			message.append(" Ok ");
		}
		else {
			message.append(" Warning ");
		}
		return message.toString();
	}

}
