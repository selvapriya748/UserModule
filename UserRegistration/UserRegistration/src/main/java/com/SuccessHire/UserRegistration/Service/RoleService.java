package com.SuccessHire.UserRegistration.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SuccessHire.UserRegistration.Model.Role;
import com.SuccessHire.UserRegistration.Model.User;
import com.SuccessHire.UserRegistration.Repository.RoleRepository;
import com.SuccessHire.UserRegistration.Repository.UserRepository;


@Service
public class RoleService {

	@Autowired
	private RoleRepository rolerepo;
	
	@Autowired
	private UserRepository userrepo;
	
	public Set<Role> getByRole(User user)
	{
		return user.getRole();
	}
	
	public List<Role> roleFindAll()
	{
		return rolerepo.findAll();
	}
	
	public Optional<Role> roleFindById(long id)
	{
		return rolerepo.findById(id);
	}

	public void roleDelete(long id)
	{
		rolerepo.deleteById(id);
	}
	
	public void roleSave(Role role)
	{
		rolerepo.save(role);
	}
	
	public void allocateRole(Long userId, Long roleId){
	    User user  = userrepo.findById(userId).orElse(null);
	    Role role = rolerepo.findById(roleId).orElse(null);
	   Set<Role> userRole = user.getRole();
	   userRole.add(role);
	   user.setRole(userRole);
	   userrepo.save(user);
	}
	
	public void deAllocateRole(Long userId, Long roleId){
	    User user  = userrepo.findById(userId).orElse(null);
	    Set<Role> userRole = user.getRole();
	    userRole.removeIf(x -> x.getId()==roleId);
	    userrepo.save(user);
	}
	
	public Set<Role> getByUser(User user)
	{
		return rolerepo.getByUser(user.getId());
	}
	
	
}