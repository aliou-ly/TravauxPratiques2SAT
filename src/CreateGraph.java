import com.company.Graph;
import com.utils.Utils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateGraph {
    private static Graph<Label> graph;
    private final ReadFile<Integer> reader;
    private int clauseNumber;

    CreateGraph(File file) throws FileNotFoundException {
        reader = new ReaderInt(file);

        graph = new Graph<>(2* reader.next());
        clauseNumber = reader.next();
        addClausesIncidences();
    }

    public Graph<Label> getGraph() { return graph; }

    private void clauseToEdges(int literalOne, int literalTwo){
        if (literalOne > 0 && literalTwo < 0) {
            graph.addArc(
                    literalToIndex(literalTwo),
                    literalToIndex(literalOne),
                    createLabel(literalTwo,literalOne)
            );
            return;
        } else if (literalOne < 0 && literalTwo > 0) {
            graph.addArc(
                    literalToIndex(literalOne),
                    literalToIndex(literalTwo),
                    createLabel(literalOne,literalTwo)
            );
            return;
        } else {
                graph.addArc(
                    literalToIndexOpposite(literalOne),
                    literalToIndex(literalTwo),
                    createLabel(-literalOne, literalTwo)
                );

                graph.addArc(
                    literalToIndexOpposite(literalTwo),
                    literalToIndex(literalOne),
                    createLabel(-literalTwo, literalOne)
                );
        }
    }


     private void addClausesIncidences() {
        do {
            clauseToEdges(reader.next(),reader.next());
            reader.next();
        } while (reader.hasNext()&& (--clauseNumber) > 0);
    }

    Graph<Label> inverseGraph() throws IOException {
        return inverseGraph(this.getGraph());
    }

    public static Graph<Label> inverseGraph(Graph<Label> graph) throws IOException {
        ReadFile<Integer> reader;
        reader = new ReaderInt(Utils.write(graph));
        Graph<Label> graph1 = new Graph<>(reader.next());

        addInverseEdges(graph1,reader);
        return graph1;
    }

    private static void addInverseEdges(Graph<Label> graph, ReadFile<Integer> reader) {

        while (reader.hasNext()) {
            int destination = reader.next();
            int source = reader.next();
            String label = createLabel(
                    indexToLiteral(source,graph),
                    indexToLiteral(destination,graph)
            );
            graph.addArc(source,destination,label);
        }
    }

    private static String createLabel(int literalOne, int literalTwo) {
        return "E(" + literalOne + "=>" + literalTwo + ")";
    }

    private int literalToIndex(int literal) {
        if (literal > 0) {
            return literal-1;
        }
        return graph.order()+literal;
    }

    private int literalToIndexOpposite(int literal) {
        if (literal < 0) {
            return Math.abs(literal)-1;
        }
        return graph.order()-literal;
    }

    private static int indexToLiteral(int index, Graph<Label> graph) {
        if (index < (graph.order()/2)) {
            return index+1;
        }
        return index-graph.order();
    }

}