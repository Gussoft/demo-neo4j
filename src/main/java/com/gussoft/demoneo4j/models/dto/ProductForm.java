package com.gussoft.demoneo4j.models.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductForm {

    private Long id;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private Integer stock;

    private String status;

}
