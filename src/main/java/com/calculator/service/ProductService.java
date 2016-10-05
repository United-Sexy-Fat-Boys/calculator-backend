package com.calculator.service;

import com.calculator.filter.ProductFilter;
import com.calculator.model.Product;
import com.calculator.repository.BaseRepositoryCustom;
import com.calculator.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * Service for Product
 */
@Service
public class ProductService implements BaseCRUDService<Product, ProductFilter> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public BaseRepositoryCustom<Product, ProductFilter> getRepositoryCustom() {
        return productRepository;
    }

    public Product findProductByName(String name) {
        return productRepository.findCategoryByName(name);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
