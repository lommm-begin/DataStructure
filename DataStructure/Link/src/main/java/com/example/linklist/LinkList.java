package com.example.linklist;

public class LinkList {
    private Object data;
    private LinkList next;

    public LinkList() {
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkList getNext() {
        return next;
    }

    public void setNext(LinkList next) {
        this.next = next;
    }
}
