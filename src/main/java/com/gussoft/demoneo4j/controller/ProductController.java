package com.gussoft.demoneo4j.controller;

import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.GenericResponse;
import com.gussoft.demoneo4j.models.dto.ProductForm;
import com.gussoft.demoneo4j.models.mappers.ProductMapper;
import com.gussoft.demoneo4j.models.mappers.ProductToProductForm;
import com.gussoft.demoneo4j.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping("/products/")
    public ResponseEntity<List<ProductForm>> listAll() {
        return ResponseEntity.ok(mapper.toProductListResponse(service.listAll()));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductForm> listById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toProductResponse(service.getById(id)));
    }

    @PostMapping("/products/")
    public ResponseEntity<ProductForm> saved(@RequestBody Product product) {
        return ResponseEntity.ok(mapper.toProductResponse(service.save(product)));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductForm> updated(
            @RequestBody Product product, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toProductResponse(service.update(product, id)));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
