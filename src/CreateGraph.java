import com.company.Graph;
import com.utils.Utils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateGraph {
    private static Graph<Label> graph;
    private final ReaderInt reader;
    private int clauseNumber;

    CreateGraph(File file) throws FileNotFoundException {
        this.reader = new ReaderInt(file);

        graph = new Graph<>(2* reader.nextInt());
        clauseNumber = reader.nextInt();
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
        }

        if (literalTwo > 0 && literalOne < 0){
            graph.addArc(
                    literalToIndex(literalOne),
                    literalToIndex(literalTwo),
                    createLabel(literalOne,literalTwo)
            );
            return;
        }

        /* (literalOne > 0 && literalTwo > 0) or (literalOne < 0 && literalTwo < 0)
            Clause gives two edges
         */
        graph.addArc(
                literalToIndexOpposite(literalOne),
                literalToIndex(literalTwo),
                createLabel(-literalOne,literalTwo)
        );

        graph.addArc(
                literalToIndexOpposite(literalTwo),
                literalToIndex(literalOne),
                createLabel(-literalTwo,literalOne)
        );
    }


    private static String createLabel(int literalOne, int literalTwo) {
        return "E(" + literalOne + "=>" + literalTwo + ")";
    }


    private int literalToIndexOpposite(int literal) {
        if (literal < 0) {
            return Math.abs(literal)-1;
        }
        return graph.order()-literal;
    }


    private int literalToIndex(int literal) {
        if (literal > 0) {
            return literal-1;
        }
        return graph.order()+literal;
    }


     private void addClausesIncidences() {
        do {
            reader.toNewline();
            clauseToEdges(reader.nextIntInLine(),reader.nextIntInLine());
        } while (reader.hasNext()&& (--clauseNumber) > 0);
    }

    Graph<Label> inverseGraph() throws IOException {
        return inverseGraph(this.getGraph());
    }

    public static Graph<Label> inverseGraph(Graph<Label> graph) throws IOException {
        ReaderInt reader = new ReaderInt(Utils.write(graph));
        Graph<Label> graph1 = new Graph<>(reader.nextIntInLine());

        addInverseEdges(graph1,reader);
        return graph1;
    }

    private static void addInverseEdges(Graph<Label> graph, ReaderInt reader) {

        do {
            reader.toNewline();
            int destination = reader.nextIntInLine();
            int source = reader.nextIntInLine();
            String label = createLabel(indexToLiteral(source,graph),
                    indexToLiteral(destination,graph)
            );
            graph.addArc(source,destination,label);
        } while (reader.hasNext());
    }

    private static int indexToLiteral(int index, Graph<Label> graph) {
        if (index < (graph.order()/2)) {
            return index+1;
        }
        return index-graph.order();
    }

}