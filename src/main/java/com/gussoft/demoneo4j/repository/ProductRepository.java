package com.gussoft.demoneo4j.repository;

import com.gussoft.demoneo4j.models.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long> {
}
