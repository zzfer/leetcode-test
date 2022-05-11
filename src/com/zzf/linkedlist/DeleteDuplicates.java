package com.zzf.linkedlist;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。

  

 示例 1：


 输入：head = [1,1,2]
 输出：[1,2]
 示例 2：


 输入：head = [1,1,2,3,3]
 输出：[1,2,3]
  

 提示：

 链表中节点数目在范围 [0, 300] 内
 -100 <= Node.val <= 100
 题目数据保证链表已经按升序 排列

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head6 = new ListNode(6);
        ListNode head5 = new ListNode(6, head6);
        ListNode head4 = new ListNode(5,head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode ahead2 = new ListNode(3,head3);
        ListNode ahead1 = new ListNode(1,ahead2);
        ListNode ahead = new ListNode(1, ahead1);
        System.out.println(deleteDuplicates(ahead));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode result = new ListNode(-1, node);
        while(head != null){
            if(node.val != head.val){
                node.next = head;
                node = head;
            }
            head = head.next;
        }
        if(node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = null;
            }
        }
        return result.next;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        while(node.next != null){
            if(node.val != node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
            head = head.next;
        }

        return head;
    }
}
