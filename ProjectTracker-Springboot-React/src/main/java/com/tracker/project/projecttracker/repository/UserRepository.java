package com.tracker.project.projecttracker.repository;

import com.tracker.project.projecttracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);



    User findByEmail(String email);
}
