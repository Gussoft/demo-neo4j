package com.gussoft.demoneo4j.service.impl;

import com.gussoft.demoneo4j.exception.UserException;
import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.ProductForm;
import com.gussoft.demoneo4j.models.mappers.ProductFormToProduct;
import com.gussoft.demoneo4j.repository.ProductRepository;
import com.gussoft.demoneo4j.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductFormToProduct productFormToProduct;

    @Override
    @Transactional(readOnly = true)
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UserException("Id no encontrado!"));
        /*if (data == null) {
            throw new UserException("Id no encontrado!");
        }
        return data;*/
    }

    @Override
    @Transactional
    public Product save(Product obj) {
        return repo.save(obj);
    }

    @Override
    @Transactional
    public Product update(Product obj, Long id) {
        Product data = getById(id);
        if (data != null) {
            obj.setId(id);
            return repo.save(obj);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product data = getById(id);
        if (data != null) {
            repo.delete(data);
        }
    }

    @Override
    public Product saveProForm(ProductForm obj) {
        return save(productFormToProduct.convert(obj));
    }
}
