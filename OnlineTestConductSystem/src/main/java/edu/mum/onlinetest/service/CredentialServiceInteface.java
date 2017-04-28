package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Credential;

public interface CredentialServiceInteface {

	public List<Credential>getAllCredentials(); 
	public Credential getCredentialByID(Integer id);
	public void saveCredential(Credential credential);
	public void deleteByID(Integer id);
	public Credential findByUsername(String username);
}
