package com.pach.drugstore.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private Products product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    private int quantity;
    private float subtotal;

    // Default constructor
    public OrderDetails() {
    }

    // Parameterized constructor
    public OrderDetails(Products product, int quantity, float subtotal, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.order = order;
    }

    // Getters and setters
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
