package com.example.graphapplication.minspantreekruskal;

import com.example.amgraph.AMGraphContent;
import com.example.amgraph.pojo.AMGraph;
import com.example.graphapplication.minspantreekruskal.pojo.Edge;

public class MinSpanTreeKruksalContent extends AMGraphContent {
    private final Edge[] edges = new Edge[w.length];
    private final int[] vexset = new int[vexs.length];

    public MinSpanTreeKruksalContent() {
        for (int i = 0; i < edges.length; i++) {
            Edge edge = new Edge();
            edge.setHead(v1[i]);
            edge.setTail(v2[i]);
            edge.setLowcost(w[i]);

            edges[i] = edge;
        }
    }

    public void minSpanTreeKruksal(AMGraph graph) {
        Edge[] edges1 = sort(edges);

        for (Edge edge : edges1) {
            System.out.println(edge.getHead() + " " + edge.getTail() + " " + edge.getLowcost());
        }

        for (int i = 0; i < graph.getVexNum(); i++) {
            vexset[i] = i;
        }

        for (int i = 0; i < graph.getArcNum() - 1; i++) {
            int v1 = locateVex(graph, edges1[i].getHead());
            int v2 = locateVex(graph, edges1[i].getTail());
            int vs1 = vexset[v1];
            int vs2 = vexset[v2];

            if (vs1 != vs2) {
                System.out.println("head: " + edges1[i].getHead() + " tail: " + edges1[i].getTail());

                for (int j = 0; j < graph.getVexNum(); j++) {
                    if (vexset[j] == vs2) {
                        vexset[j] = vs1;
                    }
                }
            }
        }

    }

    /**
     * 排序
     * @param e
     * @return
     */
    public Edge[] sort(Edge[] e) {
        for (int i = 1; i < e.length; i++) {
            Edge temp = e[i]; // 保存当前元素
            int j = i - 1;

            // 将比 temp 大的元素向后移动
            while (j >= 0 && e[j].getLowcost() > temp.getLowcost()) {
                e[j + 1] = e[j];
                j--;
            }

            // 插入 temp
            e[j + 1] = temp;
        }

        return e;
    }

    public static void main(String[] args) {
        AMGraphContent amGraphContent = new AMGraphContent();
        AMGraph udn = amGraphContent.createUDN(6, 10);
        int[][] arcs = udn.getArcs();
        for (int[] arc : arcs) {
            for (int i : arc) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        new MinSpanTreeKruksalContent().minSpanTreeKruksal(udn);
    }
}
