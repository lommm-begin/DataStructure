package com.example.algraph.pojo;

import java.util.LinkedList;
import java.util.List;

public class AdjList {
    private char data;
    private List<ArcNode> firstarc = new LinkedList<>();

    public AdjList() {
    }

    @Override
    public String toString() {
        return "AdjList{" +
                "data=" + data +
                ", nodes=" + firstarc +
                '}';
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public List<ArcNode> getFirstarc() {
        return firstarc;
    }

    public void setFirstarc(List<ArcNode> firstarc) {
        this.firstarc = firstarc;
    }
}
