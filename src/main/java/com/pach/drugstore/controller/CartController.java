package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Cart;
import com.pach.drugstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @GetMapping("/getall")
    public List<Cart> getCart() {
        return cartService.getCart();
    }

    @PutMapping("/update/{cartId}")
    public Cart updateCart(@RequestBody Cart cart, @PathVariable Long cartId) {
        cart.setCartId(cartId);
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public String deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return "Cart deleted successfully";
    }
}
