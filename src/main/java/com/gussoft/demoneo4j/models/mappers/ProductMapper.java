package com.gussoft.demoneo4j.models.mappers;

import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.ProductForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper mapper;

    public ProductForm toProductResponse(Product product) {
        return mapper.map(product, ProductForm.class);
    }

    public List<ProductForm> toProductListResponse(List<Product> products) {
        return products.stream()
                .map(pro -> mapper.map(pro, ProductForm.class))
                .collect(Collectors.toList());
    }
}


/*
@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}*/
