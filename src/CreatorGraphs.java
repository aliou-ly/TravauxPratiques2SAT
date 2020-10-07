import com.company.Graph;

import java.awt.*;

public interface CreatorGraphs<E> {

    Graph<Label> getGraph();

    default Graph<Label> inverseGraph() {
        return inverseGraph(this.getGraph());
    }

    Graph<Label> inverseGraph(Graph<Label> graph);

    void addClause(Clause<Literal<E>> clause);

    int indexLiteral(Literal<E> literal,int order);

    void addImplicationFirstToSecond(Literal<E> first, Literal<E> second, Graph<Label> graph);

    String implicationLabelFirstToSecond(Literal<E> literal, Literal<E> other);
}
