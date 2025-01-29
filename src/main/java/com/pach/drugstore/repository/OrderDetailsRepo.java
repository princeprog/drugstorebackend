package com.pach.drugstore.repository;

import com.pach.drugstore.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
}
