package com.HelloEvents.HelloEvents.Repository;

import com.HelloEvents.HelloEvents.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
