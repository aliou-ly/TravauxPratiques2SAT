public interface Literal<E> {

    boolean isPositive();

    E getValue() ;

    Literal<E> opposite();

}
