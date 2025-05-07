package com.example.algraph.pojo;

public class ArcNode {
    //该边指向的顶点的位置
    private int adjvex;
    private ArcNode nextArc;
    private Object info;

    public ArcNode() {
    }

    @Override
    public String toString() {
        return "ArcNode{" +
                "adjvex=" + adjvex +
                ", nextArc=" + nextArc +
                ", info=" + info +
                '}';
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public ArcNode getNextArc() {
        return nextArc;
    }

    public void setNextArc(ArcNode nextArc) {
        this.nextArc = nextArc;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
