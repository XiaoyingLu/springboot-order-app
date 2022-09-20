package com.springboot.springorderapp.controllers;

import com.springboot.springorderapp.exception.EntityNotFoundException;
import com.springboot.springorderapp.model.Customer;
import com.springboot.springorderapp.model.Product;
import com.springboot.springorderapp.services.CustomerService;
import com.springboot.springorderapp.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @Operation(summary = "Create a product")
    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Get a product by id")
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update product information with given id")
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product customer, @PathVariable("id") long id) {
        return new ResponseEntity<>(productService.updateProduct(customer, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a product by id")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        // delete employee from DB
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }
}
