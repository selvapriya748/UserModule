package com.SuccessHire.UserRegistration.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private long id;
	
	private String rolename;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Role() {
		
		// TODO Auto-generated constructor stub
	}

	public Role(long id, String rolename) {
	
		this.id = id;
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}
	
	
	
}
