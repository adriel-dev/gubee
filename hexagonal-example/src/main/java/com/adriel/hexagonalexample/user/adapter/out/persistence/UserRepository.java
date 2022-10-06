package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM myapp_user u WHERE u.username = ?1")
    UserJpa findUserByUsername(String username);

}