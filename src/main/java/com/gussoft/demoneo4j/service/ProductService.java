package com.gussoft.demoneo4j.service;

import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.ProductForm;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product save(Product obj);

    Product update(Product obj, Long id);

    void delete(Long id);

    Product saveProForm(ProductForm obj);

}
