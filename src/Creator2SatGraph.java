import com.company.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Creator2SatGraph<Integer> extends Creator2Sat<Integer> {
    private ReadFile<Integer> reader;
    private int clauseNumber;

    public Creator2SatGraph(File file) throws FileNotFoundException {
        reader = (ReadFile<Integer>) new ReaderInt<>(file);
        graph = new Graph<>(2* (int) reader.next());
        clauseNumber = (int) reader.next();

        addClauses();
    }

    @Override
    protected void addClauses(){
        Literal<Integer> first;
        Literal<Integer> second;
        int clauseNumber = this.clauseNumber;
        do{
            first = (Literal<Integer>) new AtomicProposition<Integer>((int) reader.next());
            second = (Literal<Integer>) new AtomicProposition<Integer>((int) reader.next());

            Clause<Literal> clause = new Clause<>(Arrays.asList(first,second));
            listOfClauses.add(clause);
            addClause(clause);
            reader.next();
        } while (reader.hasNext() && (--clauseNumber > 0));
    }


    @Override
    protected int indexLiteral(Literal<Integer> literal, int order) {
        if (literal.isPositive()) { return (int) literal.getValue() - 1; }

        return order/2 + (Math.abs((int)literal.getValue()) -1);
    }

    @Override
    protected Literal<Integer> indexToLiteral(int index, int order) {
        if (index < order/2) {
            return (Literal<Integer>) new AtomicProposition<>(index + 1);
        }
        return (Literal<Integer>) new AtomicProposition<>((order/2)-(index+1));
    }
}
