/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gta;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author nemesis
 */
class Graphs {

    private LinkedList<Integer> adj[];

    public Graphs(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public int bfs(int source, int destination) {

        boolean vis[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        parent[source] = -1;
        vis[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) {
                break;
            }

            for (int neighbor : adj[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = cur;
                }
            }
        }

        int cur = destination;
        int distance = 0;

        while (parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            distance++;
        }

        return distance;
    }

    public boolean dfsStack(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur == destination) {
                return true;
            }

            for (int neighbor : adj[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }
}

public class GTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of vertices and edges");
//
//        int v = sc.nextInt();
//        int e = sc.nextInt();
//
//        Graphs graph = new Graphs(v);
//        System.out.println("Enter " + e + " edges");
//        for (int i = 0; i < e; i++) {
//            int source = sc.nextInt();
//            int destination = sc.nextInt();
//
//            graph.addEdge(source, destination);
//        }
//        System.out.println("Enter source and destination");
//
//        int source = sc.nextInt();
//        int destination = sc.nextInt();

        Graphs graph = new Graphs(12);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);


        
        int source = 0;
        int destination = 5;

        int distance = graph.bfs(source, destination);
        System.out.println("min distance in bfs is " + distance);

        System.out.println("possible " + graph.dfsStack(source, destination));

        sc.close();
    }

}
