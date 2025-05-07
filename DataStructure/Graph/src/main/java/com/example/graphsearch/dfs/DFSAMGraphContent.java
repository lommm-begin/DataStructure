package com.example.graphsearch.dfs;

import com.example.amgraph.AMGraphContent;
import com.example.amgraph.pojo.AMGraph;

public class DFSAMGraphContent extends AMGraphContent{
    private final boolean[] visited;

    /**
     * 构造方法初始化visited数组
     */
    public DFSAMGraphContent(AMGraph graph) {
        int vexNum = graph.getVexNum();
        visited = new boolean[vexNum];

        for (int i = 0; i < vexNum; i++) {
            visited[i] = false;
        }
    }

    /**
     * 开始深度遍历，可以包括非连通图
     * @param graph
     */
    public void DFSTraverse(AMGraph graph) {
        for (int i = 0; i < graph.getVexNum(); i++) {
            if (!visited[i]) {
                DFS(graph, i);
            }
        }
    }

    /**
     * 深度优先遍历
     */
    public void DFS(AMGraph graph, int v) {
        visited[v] = true;
        System.out.println(vexs[v]);

        for (int w = nextAdjVex(graph, v); w >= 0; w = nextAdjVex(graph, w)) {
            if (!visited[w]) {
                DFS(graph, w);
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

    /**
     * 邻接矩阵的深度优先遍历
     * @param graph
     * @param v
     */
    public void DFS_AM(AMGraph graph, int v) {
        visited[v] = true;

        for (int i = 0; i < graph.getVexNum(); i++) {
            if (graph.getArcs()[v][i] != 0
            && !visited[v]) {
                DFS(graph, v);
            }
        }
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
        new DFSAMGraphContent(udn).DFSTraverse(udn);
    }
}
