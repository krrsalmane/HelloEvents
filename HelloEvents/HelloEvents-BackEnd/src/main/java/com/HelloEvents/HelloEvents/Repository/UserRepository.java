package com.HelloEvents.HelloEvents.Repository;

import com.HelloEvents.HelloEvents.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

@Query(value = "select  count(role) from user where role = 'admin' ",nativeQuery = true)
    int findByRole(@Param("role") String role);


}
