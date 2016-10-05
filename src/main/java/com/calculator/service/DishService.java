package com.calculator.service;

import com.calculator.filter.DishFilter;
import com.calculator.filter.ProductFilter;
import com.calculator.model.Dish;
import com.calculator.repository.BaseRepositoryCustom;
import com.calculator.repository.dish.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Service for Dish
 */
@org.springframework.stereotype.Service
public class DishService implements BaseCRUDService<Dish, DishFilter> {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public JpaRepository<Dish, Long> getRepository() {
        return dishRepository;
    }

    @Override
    public BaseRepositoryCustom<Dish, DishFilter> getRepositoryCustom() {
        return dishRepository;
    }

    public Dish findProductByName(String name) {
        return dishRepository.findDishByName(name);
    }

    public Dish create(Dish product) {
        return dishRepository.save(product);
    }
}
