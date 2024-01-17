package com.SuccessHire.UserRegistration.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SuccessHire.UserRegistration.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value="select * from Role where id not in (select RoleId from UserRole where UserId = ?1",nativeQuery=true)
	Set<Role> getByUser(Long Id);
}
