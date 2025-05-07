package com.example.bitree.bst;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
    }

    /**
     * 插入新的值
     * @param value
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    public TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left =  insertRec(root.left, value);
        } else if (value > root.val) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    /**
     * 查找值
     * @param value
     * @return
     */
    public boolean search(int value) {
        return searchRec(root, value);
    }

    public boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.val) {
            return true;
        }

        return value < root.val ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    public boolean delete(int value) {
        if (root == null) {
            return false;
        } else {
            root = deleteRec(root, value);
            return true;
        }
    }

    public TreeNode deleteRec(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        //找结点
        if (value < root.val) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.val) {
            root.right = deleteRec(root.right, value);
        } else {
            //情况一：删除的是叶子结点，即没有子节点
            if (root.left == null && root.right == null) {
                return null;
            }

            //情况二：只有一个子节点
            if (root.left == null) { //只有右子树，让其右子树代替它
                return root.right;
            } else if (root.right == null) { //只有左子树，让其左子树代替它
                return root.left;
            }

            //情况三：既有左子树，又有右子树
            TreeNode minTreeNode = findMaxTreeNode(root.left);
            root.val = minTreeNode.val;
            //将要删除的结点的整个左子树扔出去判断了，然后找到要删除的，删除完了返回新的左子树再接回来
            root.left = deleteRec(root.left, minTreeNode.val);
        }

        return root;
    }

    public TreeNode findMaxTreeNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    /**
     * 中序遍历
     */
    public void inorder() {
        inorderTraveler(root);
    }

    public void inorderTraveler(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraveler(root.left);
        System.out.print(" " + root.val);
        inorderTraveler(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("给定树的中序遍历");
        tree.inorder();

        System.out.println("\n\n删除节点 20");
        tree.delete(20);
        System.out.println("修改后树的中序遍历");
        tree.inorder();

        System.out.println("\n\n删除节点 30");
        tree.delete(30);
        System.out.println("修改后树的中序遍历");
        tree.inorder();

        System.out.println("\n\n删除节点 50");
        tree.delete(50);
        System.out.println("修改后树的中序遍历");
        tree.inorder();

        System.out.println("\n\n查找节点 40: " + tree.search(40));
        System.out.println("查找节点 100: " + tree.search(100));
    }
}
