import com.company.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateGraphTest {
    private static final File file = new File ("./formule-2-sat.txt");
    private static CreateGraph createGraph;
    static {
        try {
             createGraph = new CreateGraph(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getGraph() {
        Graph graph = new Graph(6);
        graph.addArc(1,0,"E("+2+"=>"+1+")");
        graph.addArc(0,2,"E("+1+"=>"+3+")");
        graph.addArc(graph.order()-1,2,"E("+(-1)+"=>"+3+")");
        graph.addArc(graph.order()-3,0,"E("+(-3)+"=>"+1+")");
        graph.addArc(1,graph.order()-3,"E("+(1)+"=>"+(-3)+")");
        graph.addArc(2, graph.order()-2, "E("+(3)+"=>"+(-2)+")");
        assertEquals(createGraph.getGraph().toString(),graph.toString());
    }

    @Test
    void inverseGraph() {
    }

    @Test
    void testInverseGraph() {
    }
}