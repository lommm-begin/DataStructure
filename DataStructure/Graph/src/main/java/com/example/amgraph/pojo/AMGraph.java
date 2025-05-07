package com.example.amgraph.pojo;

import com.example.Graph;

import java.util.Arrays;

public class AMGraph extends Graph {
    //顶点表
    private char[] vexs = new char[6];
    //邻接矩阵
    private int[][] arcs = new int[6][6];

    public AMGraph() {
    }

    public char[] getVexs() {
        return vexs;
    }

    public void setVexs(char[] vexs) {
        this.vexs = vexs;
    }

    public int[][] getArcs() {
        return arcs;
    }

    public void setArcs(int[][] arcs) {
        this.arcs = arcs;
    }

    @Override
    public String toString() {
        return "AMGraph{" +
                "vexs=" + Arrays.toString(vexs) +
                ", arcs=" + Arrays.toString(arcs) +
                ", vexNum=" + super.getVexNum() +
                ", arcNum=" + super.getArcNum() +
                '}';
    }
}
