package com.example.graphapplication.minspantree.pojo;

public class CloseDge {
    //最小边在U中的顶点
    private char adjvex;
    //最小边上的权值
    private int lowcost;

    @Override
    public String toString() {
        return "CloseDge{" +
                "adjvex=" + adjvex +
                ", lowcost=" + lowcost +
                '}';
    }

    public char getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(char adjvex) {
        this.adjvex = adjvex;
    }

    public int getLowcost() {
        return lowcost;
    }

    public void setLowcost(int lowcost) {
        this.lowcost = lowcost;
    }

    public CloseDge() {
    }
}
