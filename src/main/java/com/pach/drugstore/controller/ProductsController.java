package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Products;
import com.pach.drugstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                                @RequestParam(value = "image", required = false) MultipartFile image,
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
        if (image != null && !image.isEmpty()) {
            product.setImage(image.getBytes());
        } else {
            product.setImage(null);
        }
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
    public Products updateProduct(@PathVariable Long id,
                                  @RequestParam("genericName") String genericName,
                                  @RequestParam("brandName") String brandName,
                                  @RequestParam("dosage") String dosage,
                                  @RequestParam("description") String description,
                                  @RequestParam(value = "image", required = false) MultipartFile image,
                                  @RequestParam("price") int price,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("group") String group,
                                  @RequestParam("classification") String classification,
                                  @RequestParam("categoryId") Long categoryId) throws IOException {
        System.out.println("Received data:");
        System.out.println("genericName: " + genericName);
        System.out.println("brandName: " + brandName);
        System.out.println("dosage: " + dosage);
        System.out.println("description: " + description);
        System.out.println("image: " + (image != null ? image.getOriginalFilename() : "null"));
        System.out.println("price: " + price);
        System.out.println("quantity: " + quantity);
        System.out.println("group: " + group);
        System.out.println("classification: " + classification);
        System.out.println("categoryId: " + categoryId);

        Products existingProduct = productsService.findProductById(id);
        existingProduct.setGenericName(genericName);
        existingProduct.setBrandName(brandName);
        existingProduct.setDosage(dosage);
        existingProduct.setDescription(description);
        if (image != null && !image.isEmpty()) {
            existingProduct.setImage(image.getBytes());
        } else {
            existingProduct.setImage(null);
        }
        existingProduct.setPrice(price);
        existingProduct.setQuantity(quantity);
        existingProduct.setGroup(group);
        existingProduct.setClassification(classification);
        existingProduct.setCategories(productsService.findCategoryById(categoryId));
        return productsService.updateProduct(existingProduct, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Products> findProductsBySearchTerm(@RequestParam String searchTerm) {
        return productsService.findProductsBySearchTerm(searchTerm);
    }

    @GetMapping("/getbystartingletter/{letter}")
    public List<Products> findProductsByStartingLetter(@PathVariable String letter) {
        return productsService.findProductsByStartingLetter(letter);
    }

    @GetMapping("/getimage/{id}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long id) {
        Products product = productsService.findProductById(id);
        if (product != null && product.getImage() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpeg"); // or the appropriate image type
            return new ResponseEntity<>(product.getImage(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}