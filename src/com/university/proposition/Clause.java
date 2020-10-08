package com.university.proposition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Clause<E> implements Clauses<E> {
    private List<E> listOfLiteral;

    public Clause(Collection<E> collection) {
        listOfLiteral = new ArrayList<>(collection);
    }


    @Override
    public List<E> listOfLiteral() {
        return listOfLiteral;
    }

    @Override
    public E getIndexOf(int index) {
        return listOfLiteral.get(index);
    }

    @Override
    public int size() {
        return listOfLiteral.size();
    }

}
