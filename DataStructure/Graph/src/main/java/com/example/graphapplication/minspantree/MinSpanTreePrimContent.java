package com.example.graphapplication.minspantree;

import com.example.amgraph.AMGraphContent;
import com.example.amgraph.pojo.AMGraph;
import com.example.graphapplication.minspantree.pojo.CloseDge;

import java.util.ArrayList;
import java.util.List;

public class MinSpanTreePrimContent extends AMGraphContent {
    List<CloseDge> closeDges = new ArrayList<>();

    /**
     * 普利姆最小代价生成树，从u顶点出发
     *
     * @param graph
     * @param u
     */
    public void minSpanTreePrim(AMGraph graph, char u) {
        int k = locateVex(graph, u);
        char u0, v0;

        for (int j = 0; j < graph.getVexNum(); j++) {
            CloseDge closeDge = new CloseDge();
            if (j != k) {
                closeDge.setAdjvex(u);
                closeDge.setLowcost(graph.getArcs()[k][j]);

                closeDges.add(closeDge);
            } else {
                closeDge.setAdjvex(u);
                closeDge.setLowcost(Integer.MAX_VALUE);

                closeDges.add(closeDge);
            }
        }

        closeDges.get(k).setLowcost(0);
        for (int i = 0; i < graph.getVexNum(); i++) {

            k = min(closeDges);

            u0 = closeDges.get(k).getAdjvex();
            v0 = graph.getVexs()[k];
            System.out.println(u0 + "+" + v0);

            closeDges.get(k).setLowcost(0);

            for (int j = 0; j < graph.getVexNum(); j++) {
                if (graph.getArcs()[k][j] < closeDges.get(j).getLowcost()) { //设置连接则为0
                        closeDges.get(j).setAdjvex(graph.getVexs()[k]);
                        closeDges.get(j).setLowcost(graph.getArcs()[k][j]);
                }
            }
        }
    }

    /**
     * 根据邻接矩阵找到当前顶点的最小权值的顶点
     * @param closeDges
     * @return
     */
    public int min (List < CloseDge > closeDges) {
        int min = Integer.MAX_VALUE;
        int id = 0;

        for (int i = 0; i < closeDges.size(); i++) {
            if (closeDges.get(i).getLowcost() < min
                    && closeDges.get(i).getLowcost() != 0) {
                min = closeDges.get(i).getLowcost();
                id = i;
            }
        }

        return id;
    }

    public static void main (String[]args){
        AMGraphContent amGraphContent = new AMGraphContent();
        AMGraph udn = amGraphContent.createUDN(6, 10);
        int[][] arcs = udn.getArcs();
        for (int[] arc : arcs) {
            for (int i : arc) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        new MinSpanTreePrimContent().minSpanTreePrim(udn, '1');
    }
}
