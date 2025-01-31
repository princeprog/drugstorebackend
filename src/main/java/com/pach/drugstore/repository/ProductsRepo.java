package com.pach.drugstore.repository;

import com.pach.drugstore.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products, Long> {
    @Query("SELECT p FROM Products p WHERE p.genericName LIKE :letter%")
    List<Products> findByGenericNameStartingWith(@Param("letter") String letter);
}