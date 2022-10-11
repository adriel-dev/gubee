package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions.UserAlreadyExistsException;
import com.adriel.hexagonalexample.user.adapter.out.persistence.exceptions.UserNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try{
            var savedUserId = jdbcTemplate.queryForObject("INSERT INTO myapp_user(username, password) VALUES(?, ?) RETURNING id", Long.class, user.getUsername(), user.getPassword());
            return findById(savedUserId).get();
        } catch (DuplicateKeyException e) {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public Optional<UserJpa> findById(Long id) {
        var queryResult = jdbcTemplate.query("SELECT * FROM myapp_user WHERE myapp_user.id = ?", (rs, rowNum) -> new UserJpa(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        ), id);
        return queryResult.stream().findFirst();
    }

    @Override
    public Optional<UserJpa> findUserByUsername(String username) {
        var queryResult = jdbcTemplate.query("SELECT * FROM myapp_user WHERE myapp_user.username = ?", (rs, rowNum) -> new UserJpa(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        ), username);
        return queryResult.stream().findFirst();
    }

    @Override
    public void deleteById(Long id) {
        var rowsAffected = jdbcTemplate.update("DELETE FROM myapp_user WHERE myapp_user.id = ?", id);
        if(rowsAffected == 0) throw new UserNotFoundException();
    }

    @Override
    public UserJpa update(UserJpa user) {
        try{
            var updatedUserId = jdbcTemplate.queryForObject("UPDATE myapp_user SET username=?, password=? WHERE id=? RETURNING id", Long.class,
                    user.getUsername(), user.getPassword(), user.getId());
            return findById(updatedUserId).get();
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException();
        }
    }

}
