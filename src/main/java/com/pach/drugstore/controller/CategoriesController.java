package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Categories;
import com.pach.drugstore.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoryService;

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Categories> getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @PostMapping
    public Categories createCategory(@RequestBody Categories category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Categories updateCategory(@PathVariable Long id, @RequestBody Categories category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
