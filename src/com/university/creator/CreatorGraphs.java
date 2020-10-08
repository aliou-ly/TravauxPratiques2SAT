package com.university.creator;
import com.company.Graph;
import java.awt.*;

public interface CreatorGraphs {

    Graph<Label> getGraph();

    default Graph<Label> inverseGraph() {
        return inverseGraph(this.getGraph());
    }

    Graph<Label> inverseGraph(Graph<Label> graph);

}
