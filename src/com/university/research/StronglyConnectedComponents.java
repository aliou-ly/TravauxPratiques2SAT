package com.university.research;
import com.company.Graph;
import com.university.creator.Creator2SatGraph;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class StronglyConnectedComponents {
    private DepthFirstSearch depthSearchGraph;
    private DepthFirstSearch depthSearchInverseGraph;

    public StronglyConnectedComponents(Graph<Label> graph) {
        depthSearchGraph = new DepthFirstSearch(graph);
        depthSearchInverseGraph =
                new DepthFirstSearch(new Creator2SatGraph<Integer>(graph).inverseGraph());
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
