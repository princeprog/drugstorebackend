package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Products;
import com.pach.drugstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("/save")
    public Products saveProduct(@RequestParam("genericName") String genericName,
                                @RequestParam("brandName") String brandName,
                                @RequestParam("dosage") String dosage,
                                @RequestParam("description") String description,
                                @RequestParam("image") MultipartFile image,
                                @RequestParam("price") int price,
                                @RequestParam("quantity") int quantity,
                                @RequestParam("group") String group,
                                @RequestParam("classification") String classification,
                                @RequestParam("categoryId") Long categoryId) throws IOException {
        Products product = new Products();
        product.setGenericName(genericName);
        product.setBrandName(brandName);
        product.setDosage(dosage);
        product.setDescription(description);
        product.setImage(image.getBytes());
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setGroup(group);
        product.setClassification(classification);
        product.setCategories(productsService.findCategoryById(categoryId));
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
