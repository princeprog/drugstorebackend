package com.pach.drugstore.service;

import com.pach.drugstore.entity.OrderDetails;
import com.pach.drugstore.repository.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepository;

    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderDetailsById(int id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public OrderDetails updateOrderDetails(OrderDetails orderDetails, int id) {
        OrderDetails existingOrderDetails = orderDetailsRepository.findById(id).orElse(null);
        if (existingOrderDetails != null) {
            existingOrderDetails.setOrderId(orderDetails.getOrderId());
            existingOrderDetails.setProduct(orderDetails.getProduct());
            existingOrderDetails.setQuantity(orderDetails.getQuantity());
            existingOrderDetails.setSubtotal(orderDetails.getSubtotal());
            return orderDetailsRepository.save(existingOrderDetails);
        }
        return null;
    }

    public void deleteOrderDetails(int id) {
        orderDetailsRepository.deleteById(id);
    }
}
