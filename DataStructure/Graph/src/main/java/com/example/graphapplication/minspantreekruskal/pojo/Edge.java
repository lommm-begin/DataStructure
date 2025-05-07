package com.example.graphapplication.minspantreekruskal.pojo;

public class Edge {
    //边的始点
    private char head;
    //边的终点
    private char tail;
    //权值
    private int lowcost;

    public Edge() {
    }

    @Override
    public String toString() {
        return "Edge{" +
                "head=" + head +
                ", tail=" + tail +
                ", lowcost=" + lowcost +
                '}';
    }

    public char getHead() {
        return head;
    }

    public void setHead(char head) {
        this.head = head;
    }

    public char getTail() {
        return tail;
    }

    public void setTail(char tail) {
        this.tail = tail;
    }

    public int getLowcost() {
        return lowcost;
    }

    public void setLowcost(int lowcost) {
        this.lowcost = lowcost;
    }
}
