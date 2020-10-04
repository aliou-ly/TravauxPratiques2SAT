import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

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
    }

    @Test
    void inverseGraph() {
    }

    @Test
    void testInverseGraph() {
    }
}