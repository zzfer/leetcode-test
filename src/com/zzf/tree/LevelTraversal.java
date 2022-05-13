package com.zzf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

  

 示例 1：


 输入：root = [3,9,20,null,null,15,7]
 输出：[[3],[9,20],[15,7]]
 示例 2：

 输入：root = [1]
 输出：[[1]]
 示例 3：

 输入：root = []
 输出：[]
  

 提示：

 树中节点数目在范围 [0, 2000] 内
 -1000 <= Node.val <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LevelTraversal {

    public List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        LevelTraversal preorderTraversal = new LevelTraversal();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode4, treeNode2);
        System.out.println(preorderTraversal.levelOrder(treeNode1));
    }



    public List<List<Integer>> recursion(TreeNode root, Integer num) {
        if(list.size() == num){
            List<Integer> newList = new ArrayList<>();
            list.add(newList);
        }

        list.get(num).add(root.val);
        if(root.left != null){
            recursion(root.left, num+1);
        }
        if(root.right != null){
            recursion(root.right, num+1);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return list;
        }
        return  recursion(root, 0);
    }

}
