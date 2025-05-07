package com.example;

/**
 * 树结点
 */
public class BiTree {
    private String data;
    private BiTree lChild;
    private BiTree rChild;

    public BiTree() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BiTree getlChild() {
        return lChild;
    }

    public void setlChild(BiTree lChild) {
        this.lChild = lChild;
    }

    public BiTree getrChild() {
        return rChild;
    }

    public void setrChild(BiTree rChild) {
        this.rChild = rChild;
    }

    @Override
    public String toString() {
        return "BiTree{" +
                "data='" + data + '\'' +
                ", lChild=" + lChild +
                ", rChild=" + rChild +
                '}';
    }
}
