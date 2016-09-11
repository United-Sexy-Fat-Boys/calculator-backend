package com.calculator.api;

import com.calculator.dto.BaseDTO;
import com.calculator.model.PersistentObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Base class for Controllers
 */
public abstract class BaseController {

    @Autowired
    private ModelMapper modelMapper;

    protected <E extends PersistentObject, D extends BaseDTO> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    protected <E extends PersistentObject, D extends BaseDTO> List<D> convertToDto(List<E> entities, Class<D> dtoClass) {
        return entities.stream().map(e -> modelMapper.map(e, dtoClass)).collect(toList());
    }

    protected <E extends PersistentObject, D extends BaseDTO> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
