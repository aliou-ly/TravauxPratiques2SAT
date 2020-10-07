import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Clause<Literal> implements Clauses<Literal> {
    private List<Literal> listOfLiteral;

    public Clause(Collection<Literal> collection) {
        listOfLiteral = new ArrayList<>(collection);
    }


    @Override
    public List<Literal> listOfLiteral() {
        return listOfLiteral;
    }

    @Override
    public Literal getIndexOf(int index) {
        return listOfLiteral.get(index);
    }

}
