import com.company.Graph;

import java.awt.*;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class StronglyConnectedComponents {
    private DepthFirstSearch depthSearchGraph;
    private DepthFirstSearch depthSearchInverseGraph;

    public StronglyConnectedComponents(Graph<Label> graph, Graph<Label> inverseGraph) {
        depthSearchGraph = new DepthFirstSearch(graph);
        depthSearchInverseGraph =
                new DepthFirstSearch(inverseGraph);
        connectedComponents();
    }

    public Collection<LinkedList<Integer>> StronglyConnected() {
        return depthSearchInverseGraph.getWaysExploration();
    }

    private void connectedComponents() {

        depthSearchGraph.explore();
        depthSearchInverseGraph.exploreFlowingStack(
                depthSearchGraph.StackOfFinalDiscovered()
        );

    }
}
