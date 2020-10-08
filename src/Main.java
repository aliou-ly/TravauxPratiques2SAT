import com.university.creator.Creator2SatGraph;
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
    static StronglyConnectedComponents components = new StronglyConnectedComponents(maker.getGraph());

    public static void main(String[] args) {
       System.out.println(isSatisfied());
    }

    public static boolean isSatisfied() {
        for (List<Integer> component : components.StronglyConnected())
            for (Object summit : component) {

                boolean contains = component.contains(maker.getGraph().order() - ((int) summit + 1));
                if (contains) { return false; }
            }
        return true;
    }

}