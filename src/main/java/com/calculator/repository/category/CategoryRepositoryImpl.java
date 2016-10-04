package com.calculator.repository.category;

import com.calculator.filter.CategoryFilter;
import com.calculator.model.Category;
import com.calculator.repository.BaseRepositoryImpl;
import com.querydsl.core.BooleanBuilder;

/**
 * Category repository impl
 */
public class CategoryRepositoryImpl
        extends BaseRepositoryImpl<Category, CategoryFilter>
        implements CategoryRepositoryCustom {

    /**
     * Base constructor
     */
    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    protected BooleanBuilder getQueryPredicate(CategoryFilter searchFilter) {
        return null;
    }
}
