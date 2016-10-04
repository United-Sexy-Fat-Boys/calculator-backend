package com.calculator.repository.category;


import com.calculator.filter.CategoryFilter;
import com.calculator.model.Category;
import com.calculator.repository.BaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Repository for Category
 */
public interface CategoryRepository
        extends JpaRepository<Category, Long>,
        QueryDslPredicateExecutor<Category>,
        CategoryRepositoryCustom {

    /**
     * Find Category by name
     *
     * @param name name
     * @return Category
     */
    Category findCategoryByName(String name);
}

interface CategoryRepositoryCustom
        extends BaseRepositoryCustom<Category, CategoryFilter> {
}
