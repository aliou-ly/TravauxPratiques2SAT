import com.company.Graph;

import java.io.IOException;

public class StronglyConnectedComponents {
    Graph graph;
    DepthFirstSearch depthSearchGraph;
    DepthFirstSearch depthSearchInverseGraph;
    public StronglyConnectedComponents(Graph graph) throws IOException {
        this.graph = graph;
        depthSearchGraph = new DepthFirstSearch(graph);
        depthSearchInverseGraph =
                new DepthFirstSearch(CreateGraph.inverseGraph(graph));
        connectedComponents();
    }

    private void connectedComponents() throws IOException {

        depthSearchGraph.explore();
        depthSearchInverseGraph.exploreFlowingStack(
                depthSearchGraph.StackOfFinalDiscovered()
        );

    }
}
