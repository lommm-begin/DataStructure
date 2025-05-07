package com.example.algraph;

import com.example.algraph.pojo.ALGraph;
import com.example.algraph.pojo.AdjList;
import com.example.algraph.pojo.ArcNode;

public class ALGraphContent {
    //顶点值
    public char[] vexs = new char[]{'1', '2', '3', '4', '5'};
    //边和距离
    char[] v1 = new char[]{'1', '1', '2', '3', '2', '3'};
    char[] v2 = new char[]{'4', '2', '3', '4', '5', '5'};

    /**
     * 邻接表创建无向图
     * @param vexNum
     * @param arcNum
     * @return
     */
    public ALGraph createUDN(int vexNum, int arcNum) {
        ALGraph graph = new ALGraph();

        graph.setVexNum(vexNum);
        graph.setArcNum(arcNum);



        for (int i = 0; i < vexNum; i++) {
            graph.getAdjListList().add(new AdjList());
            graph.getAdjListList().get(i).setData(vexs[i]);
        }

        int i, j;

        for (int k = 0; k < arcNum; k++) {
            i = locateVex(graph, v1[k]);
            j = locateVex(graph, v2[k]);

            ArcNode arcNode1 = new ArcNode();
            arcNode1.setAdjvex(j);
            graph.getAdjListList().get(i).getFirstarc().addFirst(arcNode1);

            ArcNode arcNode2 = new ArcNode();
            arcNode2.setAdjvex(i);
            graph.getAdjListList().get(j).getFirstarc().addFirst(arcNode2);
        }

        return graph;
    }

    /**
     * 找到对应元素的下标
     * @param Graph
     * @param vexNum
     * @return
     */
    public int locateVex(ALGraph Graph, char vexNum) {
        for (int i = 0; i < Graph.getVexNum(); i++) {
            if (Graph.getAdjListList().get(i).getData() == vexNum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ALGraphContent graphContent = new ALGraphContent();

        ALGraph udn = graphContent.createUDN(5, 6);

        for (AdjList adjList:udn.getAdjListList()) {
            for (ArcNode arcNode: adjList.getFirstarc()) {
                System.out.print(arcNode.getAdjvex() + "->");
            }
            System.out.println();
        }
    }
}
