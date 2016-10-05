package com.calculator.dto.dish;

import com.calculator.dto.BaseDTO;
import com.calculator.model.Category;
import com.calculator.model.Dish;
import com.calculator.model.Product;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseDishDTO extends BaseDTO<Dish> {
    private String name;

    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseDishDTO)) {
            return false;
        }

        BaseDishDTO that = (BaseDishDTO) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), that.getName())
                .append(getCategory(), that.getCategory())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getName())
                .append(getCategory())
                .toHashCode();
    }

    @Override
    protected Class<Dish> getEntityClass() {
        return Dish.class;
    }
}
