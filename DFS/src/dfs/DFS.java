/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.Stack;

/**
 *
 * @author nemesis
 */
class Vertex {

    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> s;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        s = new Stack<Integer>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        s.push(0);

        while (!s.isEmpty()) {
            int v = getAdjUnvisitedVertex(s.peek()); //last push
//            System.out.println("\npeek: "+s.peek());

            if (v == -1) {
//                System.out.println("\npopk: "+s.peek());
                s.pop(); //last value. pop peek same value
                
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                s.push(v);
            }
        }
    }
}

public class DFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('P');
        theGraph.addVertex('W');
        theGraph.addVertex('L');
        theGraph.addVertex('O');
        theGraph.addVertex('R');
        theGraph.addVertex('U');
        theGraph.addVertex('M');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(0, 2);
        theGraph.addEdge(1, 3);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(2, 5);
        theGraph.addEdge(2, 6);
        theGraph.addEdge(3, 7);
        theGraph.addEdge(4, 7);
        theGraph.addEdge(5, 7);
        theGraph.addEdge(6, 7);

        System.out.println("Depth First Search");
        theGraph.dfs();
        System.out.println();
    }

}
