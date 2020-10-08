package com.university.creator;

import com.company.Graph;
import com.university.proposition.AtomicProposition;
import com.university.proposition.Clause;
import com.university.proposition.Literal;
import com.university.reader.ReadFile;
import com.university.reader.ReadInteger;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Creator2SatGraph<Integer> extends Creator2Sat<Integer> {
    private ReadFile<Integer> reader;
    private int clauseNumber;

    public Creator2SatGraph(File file) throws FileNotFoundException {
        reader = (ReadFile<Integer>) new ReadInteger(file);
        graph = new Graph<>(2* (int) reader.next());
        clauseNumber = (int) reader.next();

        addClauses();
    }

    public Creator2SatGraph(Graph<Label> graph) { this.graph = graph;}

    protected <T extends Literal<Integer>> int indexLiteral(T first, int order) {
        if (first.isPositive()) { return first.getValue() - 1; }

        return order/2 + (Math.abs(first.getValue()) -1);
    }

    @Override
    protected  Literal<Integer> indexToLiteral(int index, int order) {
        if (index < order/2) {
            return (Literal<Integer>) new AtomicProposition<>(index + 1);
        }
        return (Literal<Integer>) new AtomicProposition<>((order/2)-(index+1));
    }

    @Override
    protected void addClauses(){
        Literal<Integer> first;
        Literal<Integer> second;
        int clauseNumber = this.clauseNumber;
        do{
            first =  new AtomicProposition<>((int) reader.next());
            second = new AtomicProposition<>((int) reader.next());

            Clause<? extends Literal<Integer>> clause = new Clause<>(Arrays.asList(first,second));
            //listOfClauses.add(clause);
            addClause(clause);
            reader.next();
        } while (reader.hasNext() && (--clauseNumber > 0));
    }

}
