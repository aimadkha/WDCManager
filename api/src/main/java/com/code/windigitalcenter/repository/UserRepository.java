package com.code.windigitalcenter.repository;

import com.code.windigitalcenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);

    public User findUserByNomUser(String username);

    public Long countById(Integer id);
}
