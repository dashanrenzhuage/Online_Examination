package edu.mum.onlinetest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.serviceImpl.CredentialServiceImpl;

@Service
public class LoginService {
	
	@Autowired
	CredentialServiceImpl credentialService;
	
	public Credential login(String username, String password){
		Credential credential = credentialService.findByUsername(username);
		if(null == credential) return null;
		if(!password.equals(credential.getPassword())){
			return null;
		}
		
		return credential;
		
	
		
	}
}
