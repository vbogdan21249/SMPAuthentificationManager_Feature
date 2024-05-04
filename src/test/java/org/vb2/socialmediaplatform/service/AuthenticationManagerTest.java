package org.vb2.socialmediaplatform.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationManagerTest {
    private AuthenticationManager authManager;

    @BeforeEach
    public void setUp() {
        authManager = new AuthenticationManager();
        authManager.registerUser("testUser", "password");
    }

    @Test
    public void testRegisterUser() {
        assertTrue(authManager.authenticateUser("testUser", "password"));
    }

    @Test
    public void testAuthenticateUser_ValidCredentials() {
        assertTrue(authManager.authenticateUser("testUser", "password"));
    }

    @Test
    public void testAuthenticateUser_InvalidPassword() {
        assertFalse(authManager.authenticateUser("testUser", "wrongPassword"));
    }

    @Test
    public void testAuthenticateUser_NonExistingUser() {
        assertFalse(authManager.authenticateUser("nonExistingUser", "password"));
    }

    @Test
    public void testLogoutUser() {
        authManager.logoutUser("testUser");
        assertFalse(authManager.isUserLoggedIn("testUser"));
    }

    @Test
    public void testIsUserLoggedIn_LoggedIn() {
        assertTrue(authManager.isUserLoggedIn("testUser"));
    }

    @Test
    public void testIsUserLoggedIn_NotLoggedIn() {
        authManager.logoutUser("testUser");
        assertFalse(authManager.isUserLoggedIn("testUser"));
    }
}
