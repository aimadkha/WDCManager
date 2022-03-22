package com.code.windigitalcenter.repository;

import com.code.windigitalcenter.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
