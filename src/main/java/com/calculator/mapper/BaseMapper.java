package com.calculator.mapper;

import com.calculator.dto.BaseDTO;
import com.calculator.filter.SearchFilter;
import com.calculator.model.PersistentObject;
import com.calculator.service.BaseCRUDService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Base mapper
 *
 * @param <E> entity
 * @param <D> dto
 */
public abstract class BaseMapper<E extends PersistentObject, D extends BaseDTO<E>, F extends SearchFilter> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    protected void initMappings() {
        modelMapper.addMappings(getEntityToDTOMapping());
        modelMapper.addMappings(getDTOToEntityMapping()).setProvider(getEntityProvider());
    }

    protected abstract PropertyMap<E, D> getEntityToDTOMapping();

    protected abstract PropertyMap<D, E> getDTOToEntityMapping();

    protected abstract BaseCRUDService<E, F> getEntityProviderService();

    protected Provider<E> getEntityProvider() {
        return request -> {
            @SuppressWarnings("unchecked") D dto = (D) request.getSource();
            Long entityId = dto.getId();
            if (entityId == null) {
                return dto.instantiateEntity();
            }
            return getEntityProviderService().findOne(entityId);
        };
    }

    protected <T extends Converter> T getConverter(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
