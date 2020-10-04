import com.company.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
    private enum Color {
        White,
        Black,
        Grey
    }

    public Stack<Integer> stackOfFinalDiscovered = new Stack<>();
    private int date = 0;
    //private
    final int[] dates;
    //private
    final int[] finalDates;
    private final Color[] colors;
    //private
    final int[] parents;
    private final Graph graph;

    public Stack<LinkedList<Integer>> getConnexes() {
        return connexes;
    }

    public Stack<LinkedList<Integer>> connexes = new Stack<>();

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        colors = new Color[graph.order()];
        parents = new int[graph.order()];
        dates = new int[graph.order()];
        finalDates = new int[graph.order()];

        Arrays.fill(parents, -1);
        Arrays.fill(colors,Color.White);

    }

    public void explore() {
        for (int source = 0; source < graph.order(); source++) {
            if (colors[source] == Color.White) {
                connexes.push(new LinkedList<>());
                explore(source);
                System.out.print(source + "\t");
            }
        }
        System.out.println();
    }

    public Stack<Integer> StackOfFinalDiscovered() {
        return stackOfFinalDiscovered;
    }

    public void explorable(int source) {
        if (isWhite(source)) {
            connexes.push(new LinkedList<>());
            explore(source);
        }
    }

    public void exploreFlowingStack(Stack<Integer> stack) {
        int source;
        while( ! stack.empty() ) {
            source = stack.pop();
            explorable(source);
        }
    }

    private boolean isWhite(int source) {
        return colors[source] == Color.White;
    }

    public void explore(int source) {
        date++;
        dates[source] = date;
        colors[source] = Color.Grey;
        connexes.peek().add(source);
        for (Object adjacent: graph.listAdjacentTo(source)) {

            if (isWhite((int) adjacent)) {
                parents[(int) adjacent] = source;
                explore((int) adjacent);
            }
        }
        colors[source] = Color.Black;
        finalDates[source] = ++date;
        stackOfFinalDiscovered.push(source);
    }
}
