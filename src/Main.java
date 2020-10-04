import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readerInt = new ReaderInt<>(new File("./formule-2-sat.txt"));
        CreateGraph graph = new CreateGraph(new File("./formule-2-sat.txt"));
        System.out.println(graph.getGraph().toString());
    }


}