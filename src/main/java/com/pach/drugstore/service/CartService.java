package com.pach.drugstore.service;

import com.pach.drugstore.entity.Cart;
import com.pach.drugstore.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public void deleteCart(Long cartId) {
        cartRepo.deleteById(cartId);
    }

    public List<Cart> getCart() {
        return cartRepo.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public Cart updateCart(Cart cart) {
        Cart existingCart = cartRepo.findById(cart.getCartId()).orElse(null);
        existingCart.setQuantity(cart.getQuantity());
        return cartRepo.save(existingCart);
    }

    public List<Cart> getCartByUserEmail(String email) {
        return cartRepo.findByUserEmail(email);
    }

    public long countCartByUserEmail(String email) {
        return cartRepo.countByUserEmail(email);
    }
}
