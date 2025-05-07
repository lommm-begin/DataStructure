package com.example.amgraph;

import com.example.amgraph.pojo.AMGraph;

public class AMGraphContent {
//    //顶点值
//    public char[] vexs = new char[]{'1', '2', '3', '4', '5', '6'};
//    //边和距离
//    public char[] v1 = new char[]{'1', '1', '1', '2', '2', '3', '3', '3', '4', '5'};
//    public char[] v2 = new char[]{'2', '3', '4', '3', '5', '4', '5', '6', '6', '6'};
//    public int[] w = new int[]{6, 1, 5, 5, 3, 5, 6, 4, 2, 6};

    //迪杰斯特拉有向图
    //顶点值
    public char[] vexs = new char[]{'0', '1', '2', '3', '4', '5'};
    //边和距离
    public char[] v1 = new char[]{'0', '0', '0', '1', '2', '3', '4', '4'};
    public char[] v2 = new char[]{'2', '4', '5', '2', '3', '5', '3', '5'};
    public int[] w = new int[]{10, 30, 100, 5, 50, 10, 20, 60};

    /**
     * 创建无向图的邻接矩阵
     * @param vexNum
     * @param arcNum
     * @return
     */
    public AMGraph createUDN(int vexNum, int arcNum) {
        AMGraph amGraph = new AMGraph();

        amGraph.setVexNum(vexNum);
        amGraph.setArcNum(arcNum);

        //输入值
        for (int i = 0; i < vexNum; i++) {
            amGraph.getVexs()[i] = vexs[i];
        }

        //初始化邻接矩阵
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                amGraph.getArcs()[i][j] = Integer.MAX_VALUE;
//                amGraph.getArcs()[i][j] = 0;
            }
        }

        int i, j;

        //构造邻接矩阵
        for (int k = 0; k <= amGraph.getArcNum() - 1; k++) {
            i = locateVex(amGraph, v1[k]);
            j = locateVex(amGraph, v2[k]);

            amGraph.getArcs()[i][j] = w[k];
            //amGraph.getArcs()[j][i] = amGraph.getArcs()[i][j];
        }

        return amGraph;
    }

    /**
     * 找到对应元素的下标
     * @param amGraph
     * @param vexNum
     * @return
     */
    public int locateVex(AMGraph amGraph, char vexNum) {
        for (int i = 0; i < amGraph.getVexNum(); i++) {
            if (amGraph.getVexs()[i] == vexNum) {
                return i;
            }
        }
        return -1;
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
    }
}
