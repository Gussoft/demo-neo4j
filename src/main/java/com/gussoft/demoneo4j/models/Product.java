package com.gussoft.demoneo4j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.math.BigDecimal;

@Node("product")
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private Integer stock;

    private String status;

}
