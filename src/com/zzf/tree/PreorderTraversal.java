package com.zzf.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 94. 二叉树的中序遍历
 * 145. 二叉树的后序遍历
 *
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        System.out.println(preorderTraversal.preorderTraversal(treeNode1));
        System.out.println(preorderTraversal.inorderTraversal(treeNode1));
        System.out.println(preorderTraversal.postorderTraversal(treeNode1));
    }

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    /**
     * 递归前序
     * @param root
     * @param list
     */
    public void recursion(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            recursion(root.left, list);
            recursion(root.right, list);
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderRecursion(root, list);
        return list;
    }
    /**
     * 递归中序
     * @param root
     * @param list
     */
    public void inorderRecursion(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderRecursion(root.left, list);
            list.add(root.val);
            inorderRecursion(root.right, list);
        }
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderRecursion(root, list);
        return list;
    }

    public void postorderRecursion(TreeNode root, List<Integer> list) {
        if(root != null){
            postorderRecursion(root.left, list);
            postorderRecursion(root.right, list);
            list.add(root.val);
        }
    }
}
