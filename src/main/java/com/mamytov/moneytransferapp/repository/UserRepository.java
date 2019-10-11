package com.mamytov.moneytransferapp.repository;

import com.mamytov.moneytransferapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findTop10ByFirstName(String firstName);

    Iterable<User> findTop10ByFirstNameAndLastName(String firstName, String lastName);

    Iterable<User> findTop10ByLastName(String lastName);

    @Query(value = "Select * from users limit 10", nativeQuery = true)
    Iterable<User> fetchByTop10();

    Iterable<User> findByFirstName(String firstName);
}
