import java.util.List;

public interface Clauses<E> {
    List<E> listOfLiteral();

    E getIndexOf(int index);

    default int size() {
        return listOfLiteral().size();
    };
}
