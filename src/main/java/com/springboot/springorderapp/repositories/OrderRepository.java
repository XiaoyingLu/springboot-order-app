package com.springboot.springorderapp.repositories;

import com.springboot.springorderapp.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
