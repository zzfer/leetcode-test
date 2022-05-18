package com.zzf.linkedlist;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

  

 示例 1：


 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]
 示例 2：

 输入：head = [1], n = 1
 输出：[]
 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]
  

 提示：

 链表中结点的数目为 sz
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz
  

 进阶：你能尝试使用一趟扫描实现吗？

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

        ListNode head4 = new ListNode(5,null);
        ListNode head3 = new ListNode(4, head4);
        ListNode ahead2 = new ListNode(3,head3);
        ListNode ahead1 = new ListNode(2,ahead2);
        ListNode ahead = new ListNode(1, ahead1);
        System.out.println(removeNthFromEnd(ahead, 2));
    }


    /**
     * 先计算链表长度，然后在循环删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;

        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        ListNode temp = node;
        for(int i = 0; i < (length-n); i++ ){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return node.next;
    }

    /**
     * 双指针删除 两个链表指针保持n的距离。再循环到后一个到链表尾部，那么前一个则在目标处。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndDouble(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode start = node;
        ListNode end = head;
        for(int i = 0; i < n; i++){
            end = end.next;
        }
        while(end != null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;

        return node.next;
    }
}
