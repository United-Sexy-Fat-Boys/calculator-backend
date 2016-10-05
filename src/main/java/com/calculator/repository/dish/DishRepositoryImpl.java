package com.calculator.repository.dish;

import com.calculator.filter.DishFilter;
import com.calculator.model.Dish;
import com.calculator.repository.BaseRepositoryImpl;
import com.querydsl.core.BooleanBuilder;

/**
 * Category repository impl
 */
public class DishRepositoryImpl
        extends BaseRepositoryImpl<Dish, DishFilter>
        implements DishRepositoryCustom {

    /**
     * Base constructor
     */
    public DishRepositoryImpl() {
        super(Dish.class);
    }

    @Override
    protected BooleanBuilder getQueryPredicate(DishFilter searchFilter) {
        return null;
    }
}
