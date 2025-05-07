package com.example;

import java.util.Scanner;

public class OrderTraverse {

    /**
     * 先序遍历
     */
    public void preOrderTraverse(BiTree tree) {
        if (tree != null) {
            //访问跟结点
            System.out.print(tree.getData());
            //访问左子树
            preOrderTraverse(tree.getlChild());
            //访问右子树
            preOrderTraverse(tree.getrChild());
        }
    }

    /**
     * 中序遍历
     * @param tree
     */
    public void inOrderTraverse(BiTree tree) {
        if (tree != null) {
            //访问左子树
            inOrderTraverse(tree.getlChild());
            //访问跟结点
            System.out.print(tree.getData());
            //访问右子树
            inOrderTraverse(tree.getrChild());
        }
    }

    /**
     * 后序遍历
     * @param tree
     */
    public void postOrderTraverse(BiTree tree) {
        if (tree != null) {
            //访问左子树
            postOrderTraverse(tree.getlChild());
            //访问右子树
            postOrderTraverse(tree.getrChild());
            //访问跟结点
            System.out.print(tree.getData());
        }
    }

    private String[] ch = {
            "A", "B", "C", "#", "#",
            "D", "E", "#",
            "G", "#", "#",
            "F", "#", "#", "#"};

    /**
     * 先序次序创建二叉树
     * @param index
     * @return
     */
    public BiTree createBiTree(int index) {
        if (ch.length <= index || ch[index].equals("#")) {
            return null;
        } else {
            BiTree tree = new BiTree();
            tree.setData(ch[index]);
            tree.setlChild(createBiTree(2 * index + 1));
            tree.setrChild(createBiTree(2 * index + 2));

            return tree;
        }
    }

    public static void main(String[] args) {
        OrderTraverse orderTraverse = new OrderTraverse();

        BiTree biTree = orderTraverse.createBiTree(0);

        System.out.println("先序遍历：");
        orderTraverse.preOrderTraverse(biTree);
        System.out.println("\n中序遍历：");
        orderTraverse.inOrderTraverse(biTree);
        System.out.println("\n后序遍历：");
        orderTraverse.postOrderTraverse(biTree);
    }
}
