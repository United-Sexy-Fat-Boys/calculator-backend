package com.calculator.service;

import com.calculator.filter.CategoryFilter;
import com.calculator.model.Category;
import com.calculator.repository.BaseRepositoryCustom;
import com.calculator.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * Service for category
 */
@Service
public class CategoryService implements BaseCRUDService<Category, CategoryFilter> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    public BaseRepositoryCustom<Category, CategoryFilter> getRepositoryCustom() {
        return categoryRepository;
    }

    /**
     * Find Category by name
     *
     * @param username name
     * @return Category
     */
    public Category findAccountByUsername(String username) {
        return categoryRepository.findCategoryByName(username);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }
}
