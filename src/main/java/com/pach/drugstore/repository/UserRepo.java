package com.pach.drugstore.repository;

import com.pach.drugstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByPhone(String phone);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
