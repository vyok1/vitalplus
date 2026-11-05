
package com.example.devops_project.repository;
import com.example.devops_project.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.example.devops_project.domain.User;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsernameTest() {

        // 1. Arrange: Create a test user
        User user = new User(
            "arun_test",
            "test123",
            "CLIENT"
        );

        // 2. Act: Save the user
        userRepository.save(user);

        // 3. Act: Search for the user
        Optional<User> result =
            userRepository.findByUsername("arun_test");

        // 4. Assert: Verify the result
        assertTrue(result.isPresent());

        assertEquals(
            "arun_test",
            result.get().getUsername()
        );

        assertEquals(
            "CLIENT",
            result.get().getRole()
        );
    }
}
