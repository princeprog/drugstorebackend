package com.pach.drugstore.service;

import com.pach.drugstore.entity.Categories;
import com.pach.drugstore.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepo categoryRepository;

    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Categories> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Categories saveCategory(Categories category) {
        return categoryRepository.save(category);
    }

    public Categories updateCategory(Long id, Categories updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
