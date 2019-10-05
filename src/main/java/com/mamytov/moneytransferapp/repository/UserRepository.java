package com.mamytov.moneytransferapp.repository;

import com.mamytov.moneytransferapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByFirstName(String firstName);
}
