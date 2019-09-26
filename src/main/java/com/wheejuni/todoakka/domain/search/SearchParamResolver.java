package com.wheejuni.todoakka.domain.search;

import java.util.List;

/**
 * @author Hwi Jun Jeong(KR19385) created on 2019-09-26
 */
public interface SearchParamResolver<T, E extends SearchPredicate> {

    T matches(E predicate);
    List<T> multiMatches(E predicate);

}
