import com.company.Graph;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Main {
    static ReaderInteger readerInteger;
    static File file = new File("/home/incognito/graph.txt");
    static FileWriter writer;
    static {
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readerInteger = new ReaderInteger(new File ("/home/incognito/Téléchargements/formule-conflict.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static Graph graph = new Graph(2*readerInteger.nextInt());

    public static void main(String[] args) throws IOException {
        addIncidency(graph,readerInteger);
        Files.createFile()
       writer.write(graph.toString());
       writer.close();
        Stream.of(file).forEach(System.out::println);
    }

    static void clauseToEdge(Graph<Label> graph, int literalOne, int literalTwo){
        if (literalOne > 0 && literalTwo < 0) {
               addArc(graph,
                       literalToIndex(graph, literalTwo),
                       literalToIndex(graph, literalOne),
                       createLabel(literalTwo,literalOne)
               );
                return;
            }

            if (literalTwo > 0 && literalOne < 0){
                addArc(graph,
                        literalToIndex(graph, literalOne),
                        literalToIndex(graph, literalTwo),
                        createLabel(literalOne,literalTwo));
                return;
            }
            addArc(graph,
                    literalToIndexOpposite(literalOne,graph),
                    literalToIndex(graph, literalTwo),
                    createLabel(-literalOne,literalTwo)
            );

            addArc(graph,
                    literalToIndexOpposite(literalTwo,graph),
                    literalToIndex(graph, literalOne),
                    createLabel(-literalTwo,literalOne)
            );
    }

    static void addArc(Graph<Label> graph, int source, int destination,String label) {
        graph.addArc(source,destination,label);
    }

    static String createLabel(int literalOne, int literalTwo) {
        return "E(" + literalOne + "=>" + literalTwo + ")";
    }

    static int literalToIndexOpposite(int literal, Graph<Label> graph) {
        if (literal < 0) {
            return Math.abs(literal)-1;
        }
        return graph.order()-literal;
    }

    static int literalToIndex(Graph<Label> graph, int literal) {
        if (literal > 0) {
            return literal-1;
        }
        return graph.order()+literal;
    }

    static void addIncidency(Graph<Label> graph, ReaderInteger reader) {
        reader.nextInt();
        while(reader.hasNextInt()) {
            clauseToEdge(graph,reader.nextInt(),reader.nextInt());
            reader.nextInt();

        }
    }
}