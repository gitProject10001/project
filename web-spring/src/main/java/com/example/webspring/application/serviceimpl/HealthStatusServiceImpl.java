package com.example.webspring.application.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.webspring.application.service.HealthStatusService;
import com.example.webspring.model.domain.HealthStatus;

@Service
public class HealthStatusServiceImpl implements HealthStatusService {

@Override
public HealthStatus readHealthStatus() {
	HealthStatus status = new HealthStatus();
	status.setSpringStatus(true);
	status.setTomcatStatus(true);
	return status;
}
}
