package com.pach.drugstore.repository;

import com.pach.drugstore.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products, Long> {
}
