package study.section.four;

import study.section.util.structure.CreateSingleList;
import study.section.util.structure.SingleListNode;

/*
* 206. 反转链表
*   给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
* */
public class LC206 {
    static SingleListNode newHead;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        SingleListNode head = CreateSingleList.CreateSingleListByArray(arr);
//        method1(null, head);
        newHead = method2(head);
        while (newHead != null){
            System.out.println(newHead.val) ;
            newHead = newHead.next;
        }
    }
    /*
    * 递归法，参数是当前节点及当前节点前继节点
    * */
    public static void method1(SingleListNode pre, SingleListNode node){
        if (node == null){
            newHead = pre;
        }
        else{
            method1(node, node.next);
            node.next = pre;
        }
    }
    /*
    * 循环法，双指针，当前节点与前继节点
    * */
    public static SingleListNode method2(SingleListNode node){
        SingleListNode pre = null;
        SingleListNode now = node;
        while (true){
            node = node.next;
            now.next = pre;
            if (node == null)
                break;
            pre = now;
            now = node;
        }
        return now;
    }
}
