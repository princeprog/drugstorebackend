package com.pach.drugstore.controller;

import com.pach.drugstore.entity.OrderDetails;
import com.pach.drugstore.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/save")
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
        return orderDetailsService.saveOrderDetails(orderDetails);
    }

    @GetMapping("/getall")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @GetMapping("/get/{id}")
    public OrderDetails getOrderDetailsById(@PathVariable int id) {
        return orderDetailsService.getOrderDetailsById(id);
    }

    @PutMapping("/update/{id}")
    public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails, @PathVariable int id) {
        return orderDetailsService.updateOrderDetails(orderDetails, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderDetails(@PathVariable int id) {
        orderDetailsService.deleteOrderDetails(id);
    }
}
