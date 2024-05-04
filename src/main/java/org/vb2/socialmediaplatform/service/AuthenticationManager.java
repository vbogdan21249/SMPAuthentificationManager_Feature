package org.vb2.socialmediaplatform.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthenticationManager {
    private final Map<String, String> users; // Map of username and password
    private final Set<String> loggedInUsers; // Set of currently logged-in users

    public AuthenticationManager() {
        this.users = new HashMap<>();
        this.loggedInUsers = new HashSet<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
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
}
