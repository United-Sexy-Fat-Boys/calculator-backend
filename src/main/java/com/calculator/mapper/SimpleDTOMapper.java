package com.calculator.mapper;

import com.calculator.dto.BaseDTO;
import com.calculator.model.PersistentObject;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public abstract class SimpleDTOMapper<T extends PersistentObject, D extends BaseDTO<T>> extends BaseMapper {

    @Override
    protected PropertyMap<T, D> getEntityToDTOMapping() {

        return new PropertyMap<T, D>() {
            @Override
            protected void configure() {
                //comment for sonar
            }
        };
    }

    @Override
    protected PropertyMap<D, T> getDTOToEntityMapping() {

        return new PropertyMap<D, T>() {
            @Override
            protected void configure() {
                //comment for sonar
            }
        };
    }
}
