package com.university.proposition;

public class AtomicProposition<Integer> implements Literal<Integer> {
    private final int atomicProposition;

    public AtomicProposition(int atomicProp) {
        atomicProposition = atomicProp;
    }

    @Override
    public boolean isPositive() {
        return atomicProposition > 0;
    }

    @Override
    public int getValue() {
        return atomicProposition;
    }

    @Override
    public Literal<Integer> opposite() {
        return new AtomicProposition<>(-atomicProposition);
    }

    @Override
    public String toString() {
        return String.valueOf(atomicProposition);
    }
}
