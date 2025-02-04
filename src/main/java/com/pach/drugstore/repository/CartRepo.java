package com.pach.drugstore.repository;

import com.pach.drugstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUserEmail(String email);
    long countByUserEmail(String email);
}