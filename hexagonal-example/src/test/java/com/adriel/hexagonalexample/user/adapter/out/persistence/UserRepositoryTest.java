package com.adriel.hexagonalexample.user.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAnUserByUsername() {

        //given
        UserJpa user = new UserJpa(null, "teste", "123");
        userRepository.save(user);

        //when
        var expected = userRepository.findUserByUsername(user.getUsername());

        //then
        assertThat(expected).isNotNull();

    }

}