import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        CreateGraph graph = new CreateGraph(new File("formule-conflict.txt"));
        StronglyConnectedComponents components =
                new StronglyConnectedComponents(graph.getGraph());

        StronglyConnectedComponents components1 =
                new StronglyConnectedComponents(graph.inverseGraph());

        while (! components1.depthSearchInverseGraph.connexes.empty())
            System.out.println(components1.depthSearchInverseGraph.connexes.pop());
        System.out.println("================================================");

        while (! components.depthSearchInverseGraph.connexes.empty())
            System.out.println(components.depthSearchInverseGraph.connexes.pop());
    }
}