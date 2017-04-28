package edu.mum.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Credential;

@Repository
public interface CredentialDao extends JpaRepository<Credential, Integer> {
	
	public Credential findByUsername(String username);

}
