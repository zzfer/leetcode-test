package com.zzf.tree;

/**
 * 965. 单值二叉树

 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。

  

 示例 1：



 输入：[1,1,1,1,1,null,1]
 输出：true
 示例 2：



 输入：[2,2,2,5,2]
 输出：false
  

 提示：

 给定树的节点数范围是 [1, 100]。
 每个节点的值都是整数，范围为 [0, 99] 。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/univalued-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsUnivalTree {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode4, treeNode2);
        System.out.println(isUnivalTree(treeNode1));
    }

    public static boolean isUnivalTree(TreeNode root) {
        return tree(root);
    }

    public static boolean tree(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = true;
        boolean right = true;
        if(root.left != null){
            if(root.val != root.left.val){
                return false;
            }else{
                left = tree(root.left);
            }
        }
        if(root.right != null){
            if(root.val != root.right.val){
                return false;
            }else{
                right = tree(root.right);
            }
        }
        return left && right;
    }
}
