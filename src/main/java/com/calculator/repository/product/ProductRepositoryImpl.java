package com.calculator.repository.product;

import com.calculator.filter.CategoryFilter;
import com.calculator.filter.ProductFilter;
import com.calculator.model.Category;
import com.calculator.model.Product;
import com.calculator.repository.BaseRepositoryImpl;
import com.querydsl.core.BooleanBuilder;

/**
 * Category repository impl
 */
public class ProductRepositoryImpl
        extends BaseRepositoryImpl<Product, ProductFilter>
        implements ProductRepositoryCustom {

    /**
     * Base constructor
     */
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    protected BooleanBuilder getQueryPredicate(ProductFilter searchFilter) {
        return null;
    }
}
