package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.CredentialDao;
import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.service.CredentialServiceInteface;

@Service
public class CredentialServiceImpl implements CredentialServiceInteface {

	@Autowired
	CredentialDao credentialDao;

	@Override
	public List<Credential> getAllCredentials() {
		return credentialDao.findAll();
	}

	@Override
	public Credential getCredentialByID(Integer id) {
		return credentialDao.getOne(id);
	}

	@Override
	public void saveCredential(Credential credential) {
		credentialDao.saveAndFlush(credential);
	}

	@Override
	public void deleteByID(Integer id) {
		credentialDao.delete(id);

	}

	@Override
	public Credential findByUsername(String username) {
		return credentialDao.findByUsername(username);
	}

}
