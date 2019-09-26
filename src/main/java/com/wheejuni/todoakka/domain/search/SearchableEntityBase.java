package com.wheejuni.todoakka.domain.search;

/**
 * @author Hwi Jun Jeong(KR19385) created on 2019-09-26
 */
public interface SearchableEntityBase<P extends SearchPredicate> {

    boolean isMatchingPredicate(P predicate);

}
