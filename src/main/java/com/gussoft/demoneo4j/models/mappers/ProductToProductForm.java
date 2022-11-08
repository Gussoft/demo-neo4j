package com.gussoft.demoneo4j.models.mappers;

import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.ProductForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {

    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        productForm.setStock(product.getStock());
        productForm.setStatus(product.getStatus());
        return productForm;
    }
}
