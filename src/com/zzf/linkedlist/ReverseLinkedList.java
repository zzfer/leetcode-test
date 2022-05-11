package com.zzf.linkedlist;

/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
  

 示例 1：


 输入：head = [1,2,3,4,5]
 输出：[5,4,3,2,1]
 示例 2：


 输入：head = [1,2]
 输出：[2,1]
 示例 3：

 输入：head = []
 输出：[]
  

 提示：

 链表中节点的数目范围是 [0, 5000]
 -5000 <= Node.val <= 5000
  

 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/reverse-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head6 = new ListNode(7);
        ListNode head5 = new ListNode(6, head6);
        ListNode head4 = new ListNode(5,head5);
        ListNode head3 = new ListNode(4, head4);
        ListNode ahead2 = new ListNode(3,head3);
        ListNode ahead1 = new ListNode(2,ahead2);
        ListNode ahead = new ListNode(1, ahead1);
        System.out.println(reverseList(ahead));
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode reverseHeadList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            newHead = new ListNode(head.val, newHead);
            head = head.next;
        }
        return newHead;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp = head;
        while(temp != null){
            ListNode node = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = node;
        }
        return newHead;
    }
}
