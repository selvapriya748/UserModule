package com.SuccessHire.UserRegistration.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.SuccessHire.UserRegistration.Model.Role;
import com.SuccessHire.UserRegistration.Model.User;
import com.SuccessHire.UserRegistration.Service.RoleService;
import com.SuccessHire.UserRegistration.Service.UserService;

@Controller
public class RoleController {

	@Autowired
	private RoleService rService;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("roles")
	public String roleFindAll(Model model)
	{
		model.addAttribute("roles", rService.roleFindAll());
		return "role";
	}
	
	@GetMapping("/user/Edit/{id}")
	public String editUser(@PathVariable Integer id, Model model){
	    User user = uService.userFindById(id);
	    model.addAttribute("user", user);
	    model.addAttribute("getRoles", rService.getByRole(user));
	    model.addAttribute("getUser", rService.getByUser(user));
	    return "/userEdit";
	}
	
	@GetMapping("roles/id")
	public Optional<Role> roleFindById(Long id)
	{
		return rService.roleFindById(id);
	}
	
	@PostMapping("roles/addnew")
	public String addNew(Role role)
	{
		rService.roleSave(role);
		return "redirect:/roles";
	}
	
	@PutMapping("roles/update")
	public String update(Role role)
	{
		rService.roleSave(role);
		return "redirect:/roles";
	}
	
	
}
