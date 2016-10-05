package com.calculator.repository.product;


import com.calculator.filter.CategoryFilter;
import com.calculator.filter.ProductFilter;
import com.calculator.model.Category;
import com.calculator.model.Product;
import com.calculator.repository.BaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Repository for Category
 */
public interface ProductRepository
        extends JpaRepository<Product, Long>,
        QueryDslPredicateExecutor<Product>,
        ProductRepositoryCustom {

    /**
     * Find Product by name
     *
     * @param name name
     * @return Category
     */
    Product findCategoryByName(String name);
}

interface ProductRepositoryCustom
        extends BaseRepositoryCustom<Product, ProductFilter> {
}
