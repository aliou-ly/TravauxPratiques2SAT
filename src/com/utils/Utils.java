package com.utils;
import com.company.Graph;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

        public static File write(Graph<Label> graph) throws IOException {
            File file = new File("./graph.txt");
            FileWriter writer = new FileWriter(file);

            writer.write(graph.toString());
            writer.close();

            return file;
        }

}
