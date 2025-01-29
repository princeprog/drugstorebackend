package com.pach.drugstore.service;

import com.pach.drugstore.entity.Order;
import com.pach.drugstore.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrderById(long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(Order order, long id) {
        Order existingOrder = orderRepo.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setUser(order.getUser());
            existingOrder.setPaymentStatus(order.getPaymentStatus());
            existingOrder.setTotalAmount(order.getTotalAmount());
            return orderRepo.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(long id) {
        System.out.println("Deleting order with id: " + id);
        orderRepo.deleteById(id);
    }
}
