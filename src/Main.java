import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File ("./formule-conflict.txt");
        CreateGraph createGraph = new CreateGraph(file);
        System.out.println(createGraph.inverseGraph());
    }


}