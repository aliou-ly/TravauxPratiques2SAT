import java.util.List;

public interface Clauses<Literal> {

    List<Literal> listOfLiteral();

    Literal getIndexOf(int index);

    default int size() {
        return listOfLiteral().size();
    }
}
