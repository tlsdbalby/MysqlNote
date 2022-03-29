package study.section.four;

import study.section.util.structure.CreateSingleList;
import study.section.util.structure.SingleListNode;

/*
* 19. 删除链表的倒数第 N 个结点
*   给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
* */
public class LC19 {
    public static void main(String[] args) {
        int[] arr = {1};
        SingleListNode head = CreateSingleList.CreateSingleListByArray(arr);
        SingleListNode re = method2(head, 1);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }
    /*
    * 快慢指针，因为是倒数第n个节点，所以慢指针与快指针应该相差n个节点，当快指针到末尾时，慢指针正好在倒数第n个节点的前一个节点
    *   为了把两个指针放在一个循环内，需要设置个标志位来控制二者，更简单的方法是分两个循环，见method2，但这个方法是默认n不会超出链表长度
    * */
    public static SingleListNode method1(SingleListNode head, int n){
        SingleListNode fastIndex = head;
        SingleListNode lastIndex = head;
        int count = 1;
        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            if (count > n) {
                lastIndex = lastIndex.next;
            }
            count++;
        }
        System.out.println(count);
        if (count > n)
            lastIndex.next = lastIndex.next.next;
        else if (count == n)
            head = head.next;
        return head;
    }

    public static SingleListNode method2(SingleListNode head, int n){
        SingleListNode pre = new SingleListNode(-1, head);
        SingleListNode fastIndex = head;
        SingleListNode lastIndex = pre;
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex != null){
            fastIndex = fastIndex.next;
            lastIndex = lastIndex.next;
        }
        lastIndex.next = lastIndex.next.next;
        return pre.next;
    }
}
