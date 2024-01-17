package com.SuccessHire.UserRegistration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SuccessHire.UserRegistration.Model.User;
import com.SuccessHire.UserRegistration.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepo;
	

	public User userFindById(long id) {
		
		return userFindById(id);
	}
}
