package com.pach.drugstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String genericName;
    private String brandName;
    private String dosage;
    private String description;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;

    private int price;
    private int quantity;

    @Column(name = "product_group")
    private String group;

    private String classification;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @JsonIgnoreProperties("products")
    private Categories categories;

    public Products() {
    }

    public Products(String genericName, String brandName, String dosage, String description, byte[] image,int quantity, int price, String group, String classification, Categories categories) {
        this.genericName = genericName;
        this.brandName = brandName;
        this.dosage = dosage;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
        this.classification = classification;
        this.categories = categories;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
