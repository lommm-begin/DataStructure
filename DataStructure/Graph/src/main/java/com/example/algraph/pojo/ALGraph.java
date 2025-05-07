package com.example.algraph.pojo;

import com.example.Graph;

import java.util.ArrayList;
import java.util.List;

public class ALGraph extends Graph {
    private List<AdjList> adjListList = new ArrayList<>();

    @Override
    public String toString() {
        return "ALGraph{" +
                "adjListList=" + adjListList +
                ", vexNum=" + super.getVexNum() +
                ", arcNum=" + super.getArcNum() +
                '}';
    }

    public List<AdjList> getAdjListList() {
        return adjListList;
    }

    public void setAdjListList(List<AdjList> adjListList) {
        this.adjListList = adjListList;
    }

    public ALGraph() {
    }
}
