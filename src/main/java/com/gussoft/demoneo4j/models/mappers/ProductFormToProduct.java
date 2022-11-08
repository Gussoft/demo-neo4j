package com.gussoft.demoneo4j.models.mappers;

import com.gussoft.demoneo4j.models.Product;
import com.gussoft.demoneo4j.models.dto.ProductForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        if (productForm.getId() != null  && !StringUtils.isEmpty(productForm.getId())) {
            product.setId(productForm.getId());
        }
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());
        product.setStock(productForm.getStock());
        product.setStatus(productForm.getStatus());
        return product;
    }
}
