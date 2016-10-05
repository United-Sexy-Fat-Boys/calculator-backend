package com.calculator.repository.dish;


import com.calculator.filter.DishFilter;
import com.calculator.model.Dish;
import com.calculator.repository.BaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Repository for Dish
 */
public interface DishRepository
        extends JpaRepository<Dish, Long>,
        QueryDslPredicateExecutor<Dish>,
        DishRepositoryCustom {

    /**
     * Find Dish by name
     *
     * @param name name
     * @return Dish
     */
    Dish findDishByName(String name);
}

interface DishRepositoryCustom
        extends BaseRepositoryCustom<Dish, DishFilter> {
}
