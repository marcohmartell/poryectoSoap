package com.proyecto.soap.proyectoSoap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.proyecto.soap.proyectoSoap.producer.UserRepository;

import https.www_proyecto_com.userservice.GetUserDetailsRequest;
import https.www_proyecto_com.userservice.GetUserDetailsResponse;
import https.www_proyecto_com.userservice.User;


@Endpoint
public class UserServiceEndpoint {
	private final String NAMESPACE = "https://www.proyecto.com/UserService";
	@Autowired
	private UserRepository userRepository;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "getUserDetailsRequest")
	@ResponsePayload
	public GetUserDetailsResponse getUser(@RequestPayload final GetUserDetailsRequest request) {
		GetUserDetailsResponse response = new GetUserDetailsResponse();
		response.getUsers().addAll(userRepository.getUsers(request.getName()));
		return response;
	}
	

}
