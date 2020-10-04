import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        CreateGraph graph = new CreateGraph(new File("formule-2-sat.txt"));
        DepthFirstSearch depthFirstSearch =
                        new DepthFirstSearch(graph.getGraph());
        DepthFirstSearch depth = new DepthFirstSearch(graph.inverseGraph());
        depthFirstSearch.explore();
        depth.exploreFlowingStack(depthFirstSearch.stackOfFinalDiscovered);

           while ( !depth.connexes.empty())
               System.out.println(depth.connexes.pop().toString());


    }
}