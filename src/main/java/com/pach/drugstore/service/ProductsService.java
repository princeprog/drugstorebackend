package com.pach.drugstore.service;

import com.pach.drugstore.entity.Products;
import com.pach.drugstore.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepo productsRepository;

    public Products saveProduct(Products product) {
        return productsRepository.save(product);
    }

    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    public Products findProductById(Long id) {
        Optional<Products> product = productsRepository.findById(id);
        return product.orElse(null);
    }

    public Products updateProduct(Products updatedProduct, Long id) {
        Products existingProduct = findProductById(id);
        if (existingProduct != null) {
            updatedProduct.setProductId(id);
            return productsRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
