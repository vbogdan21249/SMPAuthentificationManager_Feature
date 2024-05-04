package org.vb2.socialmediaplatform.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testUser", "password");
    }

    @Test
    public void testGetUsername() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", user.getPassword());
    }
}
