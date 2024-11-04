package com.logistics.logisticsapp.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logistics.logisticsapp.model.User;
import com.logistics.logisticsapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, String username, String email, String phone, String password, String role, MultipartFile profilePicture) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(role);

        if (profilePicture != null && !profilePicture.isEmpty()) {
            try {
                user.setProfilePicture(profilePicture.getBytes());
            } catch (IOException e) {
                throw new IOException("Error processing profile picture file", e);
            }
        }

        return userRepository.save(user);
    }
}
