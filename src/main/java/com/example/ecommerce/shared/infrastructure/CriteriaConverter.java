package com.example.ecommerce.shared.infrastructure;

import com.example.ecommerce.shared.domain.Criteria;
import com.example.ecommerce.shared.domain.Filter;
import com.example.ecommerce.shared.domain.OperationFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CriteriaConverter<T> {

    private HashMap<OperationFilter, BiFunction<Filter, Root<T>, Predicate>> operations = new HashMap<>() {{
        put(OperationFilter.EQUALS, CriteriaConverter.this::equalsPredicate);
        put(OperationFilter.NOT_EQUALS, CriteriaConverter.this::notEqualsPredicate);
        put(OperationFilter.GREATER_THAN, CriteriaConverter.this::greaterThanPredicate);
        put(OperationFilter.LESS_THAN, CriteriaConverter.this::lessThanPredicate);
        put(OperationFilter.CONTAINS, CriteriaConverter.this::containsPredicate);

    }};

    private final CriteriaBuilder builder;
    Root<T> root;

    public CriteriaConverter(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery<T> convert(Criteria criteria, Class<T> object) {
        CriteriaQuery<T> query = builder.createQuery(object);
        root = query.from(object);

        return query.where(formatPredicates(criteria.getFilters(), root));
    }

    private Predicate[] formatPredicates(List<Filter> filters, Root<T> root) {
        List<Predicate> predicates = filters.stream().map(filter -> formatPredicate(filter, root))
                .collect(Collectors.toList());

        Predicate[] predicatesArray = new Predicate[predicates.size()];
        predicatesArray = predicates.toArray(predicatesArray);

        return predicatesArray;
    }

    private Predicate formatPredicate(Filter filter, Root<T> root) {
        BiFunction<Filter, Root<T>, Predicate> transformer = operations.get(OperationFilter
                .fromValue(filter.getOperator()));

        return transformer.apply(filter, root);
    }

    private Predicate equalsPredicate(Filter filter, Root<T> root) {
        return builder.equal(root.get(filter.getField()), filter.getValue());
    }

    private Predicate notEqualsPredicate(Filter filter, Root<T> root) {
        return builder.notEqual(root.get(filter.getField()), filter.getValue());
    }

    private Predicate greaterThanPredicate(Filter filter, Root<T> root) {
        return builder.greaterThan(root.get(filter.getField()), filter.getValue());
    }

    private Predicate lessThanPredicate(Filter filter, Root<T> root) {
        return builder.greaterThan(root.get(filter.getField()), filter.getValue());
    }

    private Predicate containsPredicate(Filter filter, Root<T> root) {
        return builder.like(root.get(filter.getField()),  String.format("%%%s%%", filter.getValue()));
    }
}
