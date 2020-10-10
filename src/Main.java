import com.company.Graph;
import com.university.creator.Creator2SatGraph;
import com.university.research.DepthFirstSearch;
import com.university.research.StronglyConnectedComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public class Main {
    static Creator2SatGraph<Integer> maker;
    static {
        try {
            maker = new Creator2SatGraph<>(new File("formule-conflict.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static int order = maker.getGraph().order();
    static StronglyConnectedComponents components = new StronglyConnectedComponents(maker.getGraph());
    static DepthFirstSearch search = new DepthFirstSearch(maker.getGraph());
    public static void main(String[] args) {
        System.out.println(components.StronglyConnected());
    }

    public static boolean isSatisfied() {
        for (List<Integer> component : components.StronglyConnected())
            for (Object summit : component) {

                boolean contains = component.contains(order - ((int) summit + 1));
                if (contains) { return false; }
            }
        return true;
    }

}