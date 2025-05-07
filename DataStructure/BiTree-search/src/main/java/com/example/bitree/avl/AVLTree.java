package com.example.bitree.avl;

/**
 * 二叉平衡树
 */
public class AVLTree {
    private TreeNode root;

    /**
     * 获取树的高度
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        return root == null ? 0 : root.height;
    }

    /**
     * 获取平衡因子
     * @param root
     * @return
     */
    public int getBalance(TreeNode root) {
        return root == null ? 0 : height(root.left) - height(root.right);
    }

    /**
     * 更新树的高度
     * @param root
     * @return
     */
    public int updateHeight(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 右旋
     * @param root
     * @return
     */
    public TreeNode RightRotate(TreeNode root) { //谁要转，参数就是谁
        TreeNode left = root.left;
        TreeNode LRight = left.right;

        left.right = root;
        root.left = LRight;

        updateHeight(root);
        updateHeight(left);

        return left;
    }

    /**
     * 左旋
     * @param root
     * @return
     */
    public TreeNode LeftRotate(TreeNode root) {
        TreeNode right = root.right;
        TreeNode RLeft = right.left;

        right.left = root;
        root.right = RLeft;

        updateHeight(root);
        updateHeight(right);

        return right;
    }

    /**
     * 插入新的结点
     * @param val
     */
    public void insert(int val) {
        root = insertRec(root, val);
    }

    //递归处理，当多个结点失衡，即平衡因子不在-1到1，递归的返回的时候会自动到
    //离插入结点最近的失衡结点，只需要解决一个，其他都会解决
    public TreeNode insertRec(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        } else {
            return node;
        }

        //插入完成，更新结点的高度
        updateHeight(node);

        int balance = getBalance(node);

        //LL型，右旋
        //平衡因子2，左孩子的平衡因子1，这里指插入的位置为左子树
        if (balance > 1 && val < node.left.val) {
            return RightRotate(node);
        }

        //RR型，左旋
        //平衡因子-2，右孩子平衡因子-1
        if (balance < -1 && val > node.right.val) {
            return LeftRotate(node);
        }

        //LR型，左旋左孩子，再右旋
        //平衡因子2，左孩子的平衡因子-1，这里第二个判断条件是因为插入的结点是在左孩子的右子树上
        //即比左孩子要大
        if (balance > 1 && val > node.left.val) {
            root.left = LeftRotate(node.left);
            return RightRotate(root);
        }

        //RL型，右旋右孩子，再左旋
        //平衡因子-2，右孩子平衡因子1
        if (balance < -1 && val < node.right.val) {
            root.right = RightRotate(node.right);
            return LeftRotate(root);
        }

        return node;
    }

    public void delete(int val) {
        root = deleteRec(root, val);
    }

    public TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        //找结点
        if (value < node.val) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.val) {
            node.right = deleteRec(node.right, value);
        } else {
            //情况一：删除的是叶子结点，即没有子节点
            if (node.left == null && node.right == null) {
                return null;
            }

            //情况二：只有一个子节点
            if (node.left == null) { //只有右子树，让其右子树代替它
                return node.right;
            } else if (node.right == null) { //只有左子树，让其左子树代替它
                return node.left;
            }

            //情况三：既有左子树，又有右子树
            TreeNode minTreeNode = findMaxTreeNode(node.left);
            node.val = minTreeNode.val;
            //将要删除的结点的整个左子树扔出去判断了，然后找到要删除的，删除完了返回新的左子树再接回来
            node.left = deleteRec(node.left, minTreeNode.val);
        }
        //删除插入完成，更新结点的高度
        updateHeight(node);

        int balance = getBalance(node);

        //LL型，右旋
        //平衡因子2，左孩子的平衡因子1，这里指插入的位置为左子树
        if (balance > 1 && value < node.left.val) {
            return RightRotate(node);
        }

        //RR型，左旋
        //平衡因子-2，右孩子平衡因子-1
        if (balance < -1 && value > node.right.val) {
            return LeftRotate(node);
        }

        //LR型，左旋左孩子，再右旋
        //平衡因子2，左孩子的平衡因子-1，这里第二个判断条件是因为插入的结点是在左孩子的右子树上
        //即比左孩子要大
        if (balance > 1 && value > node.left.val) {
            root.left = LeftRotate(node.left);
            return RightRotate(root);
        }

        //RL型，右旋右孩子，再左旋
        //平衡因子-2，右孩子平衡因子1
        if (balance < -1 && value < node.right.val) {
            root.right = RightRotate(node.right);
            return LeftRotate(root);
        }

        return node;
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


    // 测试代码
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("中序遍历结果:");
        tree.inorder(); // 输出: 10 20 25 30 40 50

        tree.delete(30);
        System.out.println("\n删除节点 30 后的中序遍历结果:");
        tree.inorder(); // 输出: 10 20 25 40 50
    }
}
