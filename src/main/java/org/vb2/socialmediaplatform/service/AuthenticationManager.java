package org.vb2.socialmediaplatform.service;

import org.vb2.socialmediaplatform.models.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthenticationManager {
    private final Map<String, User> users; // Map of username and user object
    private final Set<String> loggedInUsers; // Set of currently logged-in users

    public AuthenticationManager() {
        this.users = new HashMap<>();
        this.loggedInUsers = new HashSet<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public boolean authenticateUser(String username, String password) {
        if (isValidCredentials(username, password)) {
            loggedInUsers.add(username);
            return true;
        }
        return false;
    }

    public void logoutUser(String username) {
        loggedInUsers.remove(username);
    }

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }

    private boolean isValidCredentials(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
