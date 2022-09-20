package com.springboot.springorderapp.services;

import com.springboot.springorderapp.model.PurchaseOrder;

import java.util.List;

public interface OrderService {
    PurchaseOrder saveOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getAllOrders();
    PurchaseOrder getOrderById(long id);
    PurchaseOrder updateOrder(PurchaseOrder purchaseOrder, long id);
    void deleteOrder(long id);

    PurchaseOrder cancelOrder(long id);
}
