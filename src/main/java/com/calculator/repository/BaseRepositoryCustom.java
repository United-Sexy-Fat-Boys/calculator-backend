package com.calculator.repository;

import com.calculator.filter.SearchFilter;
import com.calculator.model.PersistentObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Base interface for custom repositories
 *
 * @param <E> entity
 * @param <F> filter
 */
public interface BaseRepositoryCustom<E extends PersistentObject, F extends SearchFilter> {

    /**
     * Find all entities use search filter
     *
     * @param searchFilter filter
     * @return List<E>, right entities
     */
    List<E> findAll(F searchFilter);

    /**
     * Find entities count use search filter
     *
     * @param searchFilter filter
     * @return Long, entities count
     */
    long count(F searchFilter);

    /**
     * Find all entities use search filter
     *
     * @param searchFilter filter
     * @param pageable     pageable params
     * @return Page<E>, right entities
     */
    Page<E> findAll(F searchFilter, Pageable pageable);

    /**
     * Find entity use search filter
     *
     * @param filter filter
     * @return Entity
     */
    E findOne(F filter);
}
