import com.company.Graph;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Creator2SatGraph maker = new Creator2SatGraph(new File("formule-2-sat.txt"));

        System.out.println(maker.inverseGraph()+"\t"+maker.getGraph());
    }
}