package com.university.research;

import com.company.Graph;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
    private enum Color {White, Black, Grey }
    private final Color[] colors;

    private Stack<Integer> stackOfFinalDiscovered = new Stack<>();
    private Stack<LinkedList<Integer>> waysExploration = new Stack<>();

    private int date = 0;
    private final int[] dates;
    private final int[] finalDates;

    private final int[] parents;
    private final Graph<Label> graph;


    public Stack<LinkedList<Integer>> getWaysExploration() {
        return waysExploration;
    }


    public DepthFirstSearch(Graph<Label> graph) {
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
            exploration(source);
        }
    }

    public Stack<Integer> StackOfFinalDiscovered() {
        return stackOfFinalDiscovered;
    }

    private void exploration(int source) {
        if (isWhite(source)) {
            waysExploration.push(new LinkedList<>());
            explore(source);
        }
    }

    public void exploreFlowingStack(Stack<Integer> stack) {
        int source;
        while( ! stack.empty() ) {
            source = stack.pop();
            exploration(source);
        }
    }

    private boolean isWhite(int source) {
        return colors[source] == Color.White;
    }

    public void explore(int source) {
        date++;
        dates[source] = date;
        colors[source] = Color.Grey;
       waysExploration.peek().add(source);
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
