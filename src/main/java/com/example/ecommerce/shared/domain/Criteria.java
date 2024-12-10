package com.example.ecommerce.shared.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Criteria {

    private List<Filter> filters;

    public List<Filter> getFilters() {
        return this.filters;
    }

    public Criteria() {
        this.filters = new ArrayList<>();
    }

    public Criteria(Filter ...filters) {
        this();
        Collections.addAll(this.filters, filters);
    }

    public Criteria(ArrayList<Filter> filters) {
        this.filters = filters;
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}
