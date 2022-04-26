package com.code.windigitalcenter.repository;

import static org.assertj.core.api.Assertions.assertThat;


import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void saveUser(){

        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("aimad", "elkha","male", "98798798", "lkql@test.com", "aimadaimad", false, roleAdmin);
        User user1 = new User("some", "some", "male", "987987987", "some@some.com", "somesome", true, roleAdmin);
        User savedUser = userRepository.save(user1);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testDeleteUser() {
        Integer userId = 17;
        userRepository.deleteById(userId);
    }

    @Test
    public void testUpdateUseretails() {
        User userAimad = userRepository.findById(19).get();

        userAimad.setEmail("aimad@test.com");
        userAimad.setStateUser(true);

        userRepository.save(userAimad);
    }

}