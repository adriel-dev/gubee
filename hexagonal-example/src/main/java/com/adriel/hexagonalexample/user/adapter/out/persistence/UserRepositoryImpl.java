package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions.UserNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserJpa save(UserJpa user) {
        return jdbcTemplate.queryForObject("INSERT INTO MYAPP_USER(USERNAME, PASSWORD) VALUES(?, ?)", UserJpa.class, user.getUsername(), user.getPassword());
    }

    @Override
    public Optional<UserJpa> findById(Long id) {
        var queryResult = jdbcTemplate.query("SELECT * FROM MYAPP_USER WHERE MYAPP_USER.ID = ?", (rs, rowNum) -> new UserJpa(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        ), id);
        return queryResult.stream().findFirst();
    }

    @Override
    public Optional<UserJpa> findUserByUsername(String username) {
        var queryResult = jdbcTemplate.query("SELECT * FROM MYAPP_USER WHERE MYAPP_USER.USERNAME = ?", (rs, rowNum) -> new UserJpa(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        ), username);
        return queryResult.stream().findFirst();
    }

    @Override
    public void deleteById(Long id) {
        var rowsAffected = jdbcTemplate.update("DELETE FROM MYAPP_USER WHERE MYAPP_USER.ID = ?", id);
        if(rowsAffected == 0) throw new UserNotFoundException();
    }

    @Override
    public void update(UserJpa user) {
        var rowsAffected = jdbcTemplate.update("UPDATE MYAPP_USER SET USERNAME=?, PASSWORD=? WHERE ID=?",
                user.getUsername(), user.getPassword(), user.getId());
        if(rowsAffected == 0) throw new RuntimeException("Erro ao atualizar usuário!");
    }

}
