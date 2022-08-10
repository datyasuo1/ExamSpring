package com.example.phamthanhdat.api;

import com.example.phamthanhdat.entity.Product;
import com.example.phamthanhdat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin(origins = "*")
public class ProductApi {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> crete(@RequestBody Product employees) {
        return ResponseEntity.ok(productService.save(employees));
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Product> optionalEmployees = productService.findById(id);
        if (optionalEmployees.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalEmployees.get());
    }
}
