package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Products;
import com.pach.drugstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("/save")
    public Products saveProduct(@RequestBody Products product) {
        return productsService.saveProduct(product);
    }

    @GetMapping("/getall")
    public List<Products> findAllProducts() {
        return productsService.findAllProducts();
    }

    @GetMapping("/get/{id}")
    public Products findProductById(@PathVariable Long id) {
        return productsService.findProductById(id);
    }

    @PutMapping("/update/{id}")
    public Products updateProduct(@RequestBody Products updatedProduct, @PathVariable Long id) {
        return productsService.updateProduct(updatedProduct, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }
}
