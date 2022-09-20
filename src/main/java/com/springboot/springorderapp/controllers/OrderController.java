package com.springboot.springorderapp.controllers;

import com.springboot.springorderapp.model.OrderLineItem;
import com.springboot.springorderapp.model.PurchaseOrder;
import com.springboot.springorderapp.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order API")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create an order")
    @PostMapping()
    public ResponseEntity<PurchaseOrder> createOrder(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder.setCreatedDate(LocalDate.now());
        return new ResponseEntity<>(orderService.saveOrder(purchaseOrder), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all orders")
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @Operation(summary = "Find an order by id")
    @GetMapping("{id}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable("id") long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update an order")
    @PutMapping("{id}")
    public ResponseEntity<PurchaseOrder> updateOrder(@RequestBody PurchaseOrder purchaseOrder, @PathVariable("id") long id) {
        return new ResponseEntity<>(orderService.updateOrder(purchaseOrder, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete an order")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        // delete employee from DB
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
    }

    @Operation(summary = "Cancel an order in 'IN_PROGRESS' status")
    @PutMapping("{id}/cancel")
    public ResponseEntity<PurchaseOrder> cancelOrder(@PathVariable("id") long id) {
        return new ResponseEntity<>(orderService.cancelOrder(id), HttpStatus.OK);
    }

}
