package com.HelloEvents.HelloEvents.Services;

import com.HelloEvents.HelloEvents.DTO.UserDto;
import com.HelloEvents.HelloEvents.Entity.User;
import com.HelloEvents.HelloEvents.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register user and hash password
    public User register(UserDto request) {
        User user = new User(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),request.getRole());
        return userRepository.save(user);
    }

    // Login user by checking hashed password
    public User login(String email, String password) {
        // Fetch user by email
        User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email)
                .getSingleResult();

        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable pour l'email: " + email);
        }

        // Use passwordEncoder.matches() to compare hashed passwords
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect.");
        }

        return user;
    }

    // Helper method to find user by email
    public User findByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }
}
