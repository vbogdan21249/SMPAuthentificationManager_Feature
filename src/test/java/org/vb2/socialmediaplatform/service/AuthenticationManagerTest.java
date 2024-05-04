package org.vb2.socialmediaplatform.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationManagerTest {
    @Test
    public void testRegisterUser() {
        AuthenticationManager authManager = new AuthenticationManager();
        authManager.registerUser("testUser", "password");
        assertTrue(authManager.authenticateUser("testUser", "password"));
    }

    @Test
    public void testAuthenticateUser() {
        AuthenticationManager authManager = new AuthenticationManager();
        authManager.registerUser("testUser", "password");
        assertTrue(authManager.authenticateUser("testUser", "password"));
    }

    @Test
    public void testLogoutUser() {
        AuthenticationManager authManager = new AuthenticationManager();
        authManager.registerUser("testUser", "password");
        authManager.authenticateUser("testUser", "password");
        authManager.logoutUser("testUser");
        assertFalse(authManager.isUserLoggedIn("testUser"));
    }
}
