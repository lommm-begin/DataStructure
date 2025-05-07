package com.example.graphsearch.bfs;

import com.example.amgraph.AMGraphContent;
import com.example.amgraph.pojo.AMGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAMGraphContent extends AMGraphContent {
    private boolean[] visited;
    Queue<Integer> q = new LinkedList<>();

    /**
     * 构造方法初始化visited数组
     */
    public BFSAMGraphContent(AMGraph graph) {
        int vexNum = graph.getVexNum();
        visited = new boolean[vexNum];

        for (int i = 0; i < vexNum; i++) {
            visited[i] = false;
        }
    }

    /**
     * 邻接矩阵的广度优先遍历
     * @param graph
     * @param v
     */
    public void BFS(AMGraph graph,int v) {
        visited[v] = true;
        q.add(v);

        System.out.println(vexs[v]);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            for (int w = nextAdjVex(graph, u); w >= 0; w = nextAdjVex(graph, w)) {
                if (!visited[w]) {
                    visited[w] = true;
                    System.out.println(vexs[w]);
                    q.add(w);
                }
            }
        }
    }

    /**
     * 找到邻接点下标
     * @param graph
     * @param v
     * @return
     */
    public int nextAdjVex(AMGraph graph, int v) {
        for (int i = 0; i < graph.getVexNum(); i++) {
            if (graph.getArcs()[v][i] == 1) {
                if (!visited[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        AMGraphContent amGraphContent = new AMGraphContent();
        AMGraph udn = amGraphContent.createUDN(5, 6);
        int[][] arcs = udn.getArcs();
        for (int[] arc : arcs) {
            for (int i : arc) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        new BFSAMGraphContent(udn).BFS(udn,0);
    }
}
