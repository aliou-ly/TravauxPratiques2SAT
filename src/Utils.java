import com.company.Graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

        static File write(Graph graph) throws IOException {
            File file = new File("./graph.txt");
            FileWriter writer = new FileWriter(file);

            writer.write(graph.toString());
            writer.close();

            return file;
        }

}
