package com.mamytov.moneytransferapp;


import com.mamytov.moneytransferapp.model.User;
import com.mamytov.moneytransferapp.repository.UserRepository;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testFindByFirstName() throws Exception {
        User mockUser = new User();
        mockUser.setFirstName("Chyngyz");
        mockUser.setLastName("Aitmatov");
        this.entityManager.persist(mockUser);

        Iterable<User> users = this.repository.findByFirstName("Chyngyz");

        List<User> userList = new ArrayList<>();

        users.forEach(userList::add);

        assertThat(userList).isNotEmpty();
        assertThat(userList).contains(mockUser);

        User user = userList.get(0);

        assertThat(user.getLastName()).isEqualTo("Aitmatov");
        assertThat(user.getFirstName()).isEqualTo("Chyngyz");
    }

    @Test
    public void testFindByFirstNameAndLastNameTopTen() throws Exception {
        User mockUser = new User();
        mockUser.setFirstName("Chyngyz");
        mockUser.setLastName("Aitmatov");
        mockUser.setFirstName("Mamat");
        mockUser.setLastName("Muktar");
        mockUser.setFirstName("Elmira");
        mockUser.setLastName("Koichubaeva");
        mockUser.setFirstName("Nargiz");
        mockUser.setLastName("Tursunuva");
        mockUser.setFirstName("Almambet");
        mockUser.setLastName("Sherimbekov");
        mockUser.setFirstName("Anara");
        mockUser.setLastName("Narbaeva");
        this.entityManager.persist(mockUser);

        Iterable<User> users = this.repository.findTop10ByFirstNameAndLastName("Mamat", "Muktar");

        List<User> userList = new ArrayList<>();

        users.forEach(userList::add);

//        assertThat(userList).isNotEmpty();
        assertThat(userList).contains(mockUser);

        User user = userList.get(0);

        assertThat(user.getLastName()).isEqualTo("Mamat");
        assertThat(user.getFirstName()).isEqualTo("Muktar");
    }

}

