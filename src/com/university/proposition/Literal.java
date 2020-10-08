package com.university.proposition;
public interface Literal<E> {

    boolean isPositive();

    int getValue() ;

    Literal<E> opposite();

}
