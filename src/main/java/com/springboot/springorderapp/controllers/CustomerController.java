package com.springboot.springorderapp.controllers;

import com.springboot.springorderapp.exception.EntityNotFoundException;
import com.springboot.springorderapp.model.Customer;
import com.springboot.springorderapp.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // the data returned by each method will be written straight into the response body instead of rendering a template
@RequestMapping("/api/customers")
@Tag(name = "Customer API")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @Operation(summary = "Create a customer")
    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all customers")
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @Operation(summary = "Get a customer by id")
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) throws EntityNotFoundException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update customer information with given id")
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id) throws EntityNotFoundException{
        return new ResponseEntity<>(customerService.updateCustomer(customer, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a customer by id")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) throws EntityNotFoundException{
        // delete employee from DB
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Employee deleted successfully!", HttpStatus.OK);
    }
}
