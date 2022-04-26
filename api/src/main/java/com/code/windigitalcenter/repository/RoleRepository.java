package com.code.windigitalcenter.repository;

import com.code.windigitalcenter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findRoleByNomRole(String roleName);

}
