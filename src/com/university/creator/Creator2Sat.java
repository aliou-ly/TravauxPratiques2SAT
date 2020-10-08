package com.university.creator;

import com.company.Graph;
import com.university.proposition.Clause;
import com.university.proposition.Literal;

import java.awt.*;

public abstract class Creator2Sat<E> implements CreatorGraphs {
    protected Graph<Label> graph;
    //protected List<Clause<? extends Literal<E>>> listOfClauses = new ArrayList<>();

    @Override
    public Graph<Label> getGraph() { return graph; }

    @Override
    public Graph<Label> inverseGraph() { return inverseGraph(this.graph); }


    /*public List<Clause> getListOfClauses() {
        return new ArrayList<>(listOfClauses);
    }*/

    /*
     * cette méthose permet de determiner le sens de l'implication littérale.
     * c'est à dire si le premier littéral est négative (@first) et le second (@second) positive
     * cela traduit que l'implication dans la clause va de l'opposé de la
     * première proposition atomique à la seconde propostion.
     * */

    protected String implicationLabelFirstToSecond(Literal<E> literal, Literal<E> second) {
        return "edge("+literal+" => "+second+")";
    }

    /*
     * Dans ce cas de figure du probleme 2sat la clause est constituée de deux littéraux donc
     * elle est de taille 2. @first represente le premier littéral et de manière analoque
     * pour @second.
     * Dans cette méthode on ajoute une clause dans le graphe tout en évaluant la clause
     * en terme d'implications.
     * */
    protected <T extends Literal<E>> void addClause(Clause<T> clause) {
        T first = clause.getIndexOf(0);
        T second = clause.getIndexOf(1);
            addImplication(first.opposite(), second, this.graph);
            addImplication(second.opposite(), first, this.graph);
    }

    public <T extends Literal<E>> void addImplication(T first, T second, Graph<Label> graph) {
        String label = implicationLabelFirstToSecond(first,second);
        int source = indexLiteral(first,graph.order());
        int destination = indexLiteral(second, graph.order());
        graph.addArc(source,destination,label);
    }

    public Graph<Label> inverseGraph(Graph<Label> graph) {
        Graph<Label> inverseGraph = new Graph<>(graph.order());
        for (int summit = 0; summit < graph.order(); summit++) {
            for (int adjacent: graph.listAdjacentTo(summit)) {
                addImplication(
                        indexToLiteral(adjacent,inverseGraph.order())
                        ,indexToLiteral(summit,inverseGraph.order())
                        ,inverseGraph);
            }
        }

        return inverseGraph;
    }

    protected abstract <T extends Literal<E>> int indexLiteral(T first, int order);

    protected abstract Literal<E> indexToLiteral(int adjacent, int order);

    protected abstract void addClauses();
}
