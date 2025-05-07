package com.example.linklist;

import java.util.ArrayList;

public class LinkListContent {
    /**
     * 链表取值
     * @param linkList
     * @param location
     * @return
     */
    public Boolean getElem(LinkList linkList, int location) {
        int i = 0;

        while (linkList != null && i < location) {
            linkList = linkList.getNext();
            i++;
        }
        if (linkList == null || i > location) {
            return false;
        }

        return true;
    }

    /**
     * 按值查找
     * @param linkList
     * @param data
     * @return
     */
    public LinkList localElem(LinkList linkList, Object data) {
        while (linkList != null && linkList.getData().equals(data)) {
            linkList = linkList.getNext();
        }
        return linkList;
    }

    /**
     * 插入值
     * @param linkList
     * @param location
     * @param data
     * @return
     */
    public LinkList listInsert(LinkList linkList, int location, Object data) {
        int i = 0;

        LinkList current = linkList;
        while (linkList != null && i < location - 1) {
            current = current.getNext();
            i++;
        }
        if (linkList == null || i > location - 1) {
            return null;
        }

        LinkList newLinkList = new LinkList();
        newLinkList.setData(data);
        newLinkList.setNext(current.getNext());
        current.setNext(newLinkList);

        return linkList;
    }

    /**
     * 删除值
     * @param linkList
     * @param location
     * @return
     */
    public LinkList listRemove(LinkList linkList, int location) {
        int i = 0;

        LinkList current = linkList;
        while (linkList != null && i < location - 1) {
            current = current.getNext();
            i++;
        }
        if (linkList == null || i > location - 1) {
            return null;
        }
        current.setNext(linkList.getNext().getNext());

        return linkList;
    }

    /**
     * 前叉法创建链表
     * @param n
     * @return
     */
    public LinkList createLinkList(int n) {
        LinkList headLink = new LinkList();
        headLink.setData("HEAD");

        for (int i = 0; i < n; i++) {
            LinkList current = new LinkList();
            current.setData(i);
            current.setNext(headLink.getNext());
            headLink.setNext(current);
        }

        return headLink;
    }

    /**
     * 输出链表内容
     * @param linkList
     */
    public void printLinkList(LinkList linkList) {
        while (linkList != null) {
            System.out.print(linkList.getData() + ", ");
            linkList = linkList.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkListContent linkListContent = new LinkListContent();

        LinkList linkList = linkListContent.createLinkList(10);

        linkListContent.printLinkList(linkList);

        System.out.println(linkListContent.getElem(linkList, 5));

        linkListContent.listInsert(linkList,1, "100");

        linkListContent.printLinkList(linkList);
    }
}
