public class AtomicProposition<Integer> implements Literal<java.lang.Integer> {
    private final int atomicProposition;

    public AtomicProposition(int atomicProp) {
        atomicProposition = atomicProp;
    }

    @Override
    public boolean isPositive() {
        return atomicProposition > 0;
    }

    @Override
    public java.lang.Integer getValue() {
        return atomicProposition;
    }

    @Override
    public Literal<java.lang.Integer> opposite() {
        return new AtomicProposition<Integer>(-atomicProposition);
    }

    @Override
    public String toString() {
        return String.valueOf(atomicProposition);
    }
}
