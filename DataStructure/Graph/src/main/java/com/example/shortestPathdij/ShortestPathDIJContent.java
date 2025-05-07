package com.example.shortestPathdij;

import com.example.amgraph.AMGraphContent;
import com.example.amgraph.pojo.AMGraph;

public class ShortestPathDIJContent extends AMGraphContent {
    int[] d = new int[vexs.length];
    int[] path = new int[vexs.length];
    boolean[] s = new boolean[vexs.length];

    /**
     * 迪杰斯特拉最短路径
     * @param graph
     * @param v
     */
    public void shortestPathDIJ(AMGraph graph, int v) {
        int n = graph.getVexNum();
        int min;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            s[i] = false;
            d[i] = graph.getArcs()[v][i];
            if (d[i] < Integer.MAX_VALUE) {
                path[i] = v;
            } else {
                path[i] = -1;
            }
        }

        s[v] = true;
        d[v] = 0;

        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int w = 0; w < n; w++) {
                if (!s[w] && d[w] < min) {
                    temp = w;
                    min = d[w];
                }
            }

            s[temp] = true;

            for (int w = 0; w < n; w++) {
                if (!s[w] && graph.getArcs()[temp][w] != Integer.MAX_VALUE && (d[temp] + graph.getArcs()[temp][w] < d[w])) {
                    d[w] = d[temp] + graph.getArcs()[temp][w];
                    path[w] = temp;
                }
            }
        }
    }

    public void getShortestPath(int ep) {
        if (ep != 0) {
            getShortestPath(path[ep]);
        }
        System.out.print(ep + "->");
    }

    public static void main(String[] args) {
        AMGraphContent amGraphContent = new AMGraphContent();
        AMGraph udn = amGraphContent.createUDN(6, 8);
        int[][] arcs = udn.getArcs();
        for (int[] arc : arcs) {
            for (int i : arc) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        ShortestPathDIJContent shortestPathDIJContent = new ShortestPathDIJContent();
        shortestPathDIJContent.shortestPathDIJ(udn, 0);
        shortestPathDIJContent.getShortestPath(5);
    }
}
