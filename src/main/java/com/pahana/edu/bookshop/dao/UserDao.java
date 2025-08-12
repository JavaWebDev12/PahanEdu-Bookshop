package com.pahana.edu.bookshop.dao;

import com.pahana.edu.bookshop.model.User;
import com.pahana.edu.bookshop.util.DataStore;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final ServletContext context;

    public UserDao(ServletContext context) {
        this.context = context;
    }

    public boolean validate(String username, String password) {
        for (User user : getAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        File file = DataStore.resolveDataFile(context, DataStore.USERS_FILE);
        ensureSeedData(file);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read users file", e);
        }
        return users;
    }

    private void ensureSeedData(File file) {
        if (file.exists()) return;
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("# username,password\n");
            writer.write("admin,admin\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to seed users file", e);
        }
    }
}

