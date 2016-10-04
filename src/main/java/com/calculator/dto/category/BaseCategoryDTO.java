package com.calculator.dto.category;

import com.calculator.dto.BaseDTO;
import com.calculator.model.Category;
import com.calculator.model.accounts.Account;
import com.calculator.model.accounts.Role;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseCategoryDTO extends BaseDTO<Category> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseCategoryDTO)) {
            return false;
        }

        BaseCategoryDTO that = (BaseCategoryDTO) o;

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

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
