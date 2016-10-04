package com.calculator.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Category extends PersistentObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }

        Category category = (Category) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), category.getName())
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
