package com.calculator.dto.product;

import com.calculator.dto.BaseDTO;
import com.calculator.model.Category;
import com.calculator.model.Product;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseProductDTO extends BaseDTO<Product> {
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

        if (!(o instanceof BaseProductDTO)) {
            return false;
        }

        BaseProductDTO that = (BaseProductDTO) o;

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
                .append(getCategory())
                .toHashCode();
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
