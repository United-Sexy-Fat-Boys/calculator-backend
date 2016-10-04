package com.calculator.dto.category;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Info about account from client
 */
public class CategoryDTO extends BaseCategoryDTO {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CategoryDTO)) {
            return false;
        }

        CategoryDTO that = (CategoryDTO) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), that.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getName())
                .toHashCode();
    }
}