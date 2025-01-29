package com.pach.drugstore.repository;

import com.pach.drugstore.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories, Long> {
}
