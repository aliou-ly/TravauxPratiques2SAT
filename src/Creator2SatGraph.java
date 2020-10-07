import com.company.Graph;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Creator2SatGraph<Integer> implements CreatorGraphs<Integer> {
    private Graph<Label> graph;
    private List<Clauses<Literal<Integer>>> listOfClauses = new ArrayList<>();
    private ReadFile<Integer> reader;
    private int clauseNumber;

    public Creator2SatGraph(File file) throws FileNotFoundException {
        reader = (ReadFile<Integer>) new ReaderInt<>(file);
        graph = new Graph<>(2* (int) reader.next());
        clauseNumber = (int) reader.next();

        addClauses();
    }

    @Override
    public Graph<Label> getGraph() {
        return graph;
    }

    @Override
    public Graph<Label> inverseGraph(Graph<Label> graph) {
        Graph<Label> inverseGraph = new Graph<>(graph.order());
        for (int summit = 0; summit < graph.order(); summit++) {
            for (int adjacent: graph.listAdjacentTo(summit)) {
                addImplicationFirstToSecond(
                        indexToLiteral(adjacent,inverseGraph.order())
                        ,indexToLiteral(summit,inverseGraph.order())
                        ,inverseGraph);
            }
        }

        return inverseGraph;
    }

    /*
    * cette méthose permet de determiner le sens de l'implication littérale.
    * c'est à dire si le premier littéral est négative et le second positive
    * cela traduit que l'implication dans la clause va de l'opposé de la
    * première proposition atomique à la seconde propostion.
    * */
    private boolean isToFirstOppositeFromSecond(Literal<Integer> first, Literal<Integer> second) {
        return  (!first.isPositive()) && (second.isPositive());
    }

    /*
    * Dans ce cas de figure du probleme 2sat la clause est constituée de deux littéraux donc
    * elle est de taille 2. @first represente le premier littéral et de manière analoque
    * pour @second.
    * Dans cette méthode on ajoute une clause dans le graphe tout en évaluant la clause
    * en terme d'implications.
    * */
    @Override
    public void addClause(Clause<Literal<Integer>> clause) {
        Literal<Integer> first = clause.getIndexOf(0);
        Literal<Integer> second = clause.getIndexOf(1);

        if (isToFirstOppositeFromSecond(first,second)) {
            addImplicationFirstToSecond(first.opposite(),second,this.graph);
        } else if (isToFirstOppositeFromSecond(second,first)) {
            addImplicationFirstToSecond(second.opposite(),first,this.graph);
        }   else {
            addImplicationFirstToSecond(first.opposite(),second,this.graph);
            addImplicationFirstToSecond(second.opposite(),first,this.graph);
        }
    }

    @Override
    public void addImplicationFirstToSecond(Literal<Integer> first, Literal<Integer> second,Graph<Label> graph) {
        String label = implicationLabelFirstToSecond(first,second);
        int source = indexLiteral(first,graph.order());
        int destination = indexLiteral(second,graph.order());
        graph.addArc(source,destination,label);
    }

    private void addClauses(){
        Literal<Integer> first;
        Literal<Integer> second;
        int clauseNumber = this.clauseNumber;
        do{
            first = (Literal<Integer>) new AtomicProposition<Integer>((int) reader.next());
            second = (Literal<Integer>) new AtomicProposition<Integer>((int) reader.next());
            Clause<Literal<Integer>> clause = new Clause<>(Arrays.asList(first,second));
            listOfClauses.add(clause);
            addClause(clause);
            reader.next();
        } while (reader.hasNext() && (--clauseNumber > 0));
    }


    @Override
    public int indexLiteral(Literal<Integer> literal, int order) {
        if (literal.isPositive()) { return (int) literal.getValue() - 1; }

        return order/2 + (Math.abs((int)literal.getValue()) -1);
    }

    @Override
    public String implicationLabelFirstToSecond(Literal<Integer> literal, Literal<Integer> second) {
        return "edge("+literal+" => "+second+")";
    }

    public Literal<Integer> indexToLiteral(int index, int order) {
        if (index < order/2) {
            return (Literal<Integer>) new AtomicProposition<>(index + 1);
        }
        return (Literal<Integer>) new AtomicProposition<>((order/2)-(index+1));
    }
}
