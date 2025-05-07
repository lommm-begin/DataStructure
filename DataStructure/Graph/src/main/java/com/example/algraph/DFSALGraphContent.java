package com.example.algraph;

import com.example.algraph.pojo.ALGraph;
import com.example.algraph.pojo.AdjList;
import com.example.algraph.pojo.ArcNode;

import java.util.List;

public class DFSALGraphContent extends ALGraphContent {
    private boolean[] visited;

    /**
     * 构造方法初始化visited数组
     */
    public DFSALGraphContent(ALGraph graph) {
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
    public void DFSTraverse(ALGraph graph) {
        for (int i = 0; i < graph.getVexNum(); i++) {
            if (!visited[i]) {
                DFS(graph, i);
            }
        }
    }

    /**
     * 深度优先遍历
     */
    public void DFS(ALGraph graph, int v) {
        visited[v] = true;
        System.out.println(vexs[v]);

        for (int w = firstAdjVex(graph, v); w >= 0; w = nextAdjVex(graph, w)) {
            if (!visited[w]) {
                DFS(graph, w);
            }
        }
    }

    /**
     * 找到第一个所在顶点的下标
     * @param graph
     * @param v
     * @return
     */
    public int firstAdjVex(ALGraph graph, int v) {
        char stop = vexs[graph.getVexNum() - 1];
        for (int i = 0; vexs[i] != stop; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 找到w的下一个未被遍历的邻接点
     * @param graph
     * @param w
     * @return
     */
    public int nextAdjVex(ALGraph graph, int w) {
        List<ArcNode> firstarc = graph.getAdjListList().get(w).getFirstarc();

        for (int i = 0; i < firstarc.size(); i++) {
            if (firstarc.get(i).getNextArc() != null) {
                int adjvex = firstarc.get(i).getAdjvex();

                if (!visited[adjvex]) {
                    return adjvex;
                }
            }
        }

        return -1;
    }

    /**
     * 邻接表的深度优先遍历
     * @param graph
     * @param v
     */
    public void DFS_AL(ALGraph graph, int v) {
        visited[v] = true;
        ArcNode arcNode = graph.getAdjListList().get(v).getFirstarc().get(v);

        while (arcNode != null) {
            if (!visited[arcNode.getAdjvex()]) {
                DFS_AL(graph, arcNode.getAdjvex());
            }
            arcNode = arcNode.getNextArc();
        }
    }

    public static void main(String[] args) {
        ALGraphContent graphContent = new ALGraphContent();

        ALGraph udn = graphContent.createUDN(5, 6);

        for (AdjList adjList:udn.getAdjListList()) {
            for (ArcNode arcNode: adjList.getFirstarc()) {
                System.out.print( "->" + arcNode.getAdjvex());
            }
            System.out.println();
        }

        new DFSALGraphContent(udn).DFSTraverse(udn);
    }
}
