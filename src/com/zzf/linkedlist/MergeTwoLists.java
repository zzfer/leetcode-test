package com.zzf.linkedlist;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

  

 示例 1：


 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]
  

 提示：

 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode head2 = new ListNode(4);
        ListNode head1 = new ListNode(2,head2);
        ListNode head = new ListNode(1, head1);


        ListNode ahead2 = new ListNode(4);
        ListNode ahead1 = new ListNode(3,ahead2);
        ListNode ahead = new ListNode(1, ahead1);

        System.out.println(mergeTwoLists(head, ahead));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode noden = new ListNode(-1);
        ListNode node = noden;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                node.next = list2;
                list2 = list2.next;
            }else{
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        if(list1 == null){
            node.next = list2;
        }
        if(list2 == null){
            node.next = list1;
        }
        return noden.next;
    }
}
