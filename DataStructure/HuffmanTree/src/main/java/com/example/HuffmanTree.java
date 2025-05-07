package com.example;

public class HuffmanTree {

    //权值
    private int weight;

    //结点下标
    private int parent;
    private int lChild;
    private int rChild;

    public HuffmanTree() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getlChild() {
        return lChild;
    }

    public void setlChild(int lChild) {
        this.lChild = lChild;
    }

    public int getrChild() {
        return rChild;
    }

    public void setrChild(int rChild) {
        this.rChild = rChild;
    }
}
