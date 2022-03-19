package study.section.four;

import study.section.util.structure.CreateSingleList;
import study.section.util.structure.SingleListNode;

/*
* P53 4.2 移除链表元素
*   给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
*
* */
public class LC203 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int target = 6;
        SingleListNode head = CreateSingleList.CreateSingleListByArray(arr);
        SingleListNode node1 = head;
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
        System.out.println("=============");
        node1 = head;
//        method1(head, target);
        method2(head, target);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }
    /*
    * 自想
    *   因为是单链表，所以删除时需要被删除元素前位元素指针，被删除元素指针，所以在查找时使用快慢指针
    * */
    public static SingleListNode method1(SingleListNode head, int target){
        while (head.val == target){
            head = head.next;
            if (head == null)
                return null;
        }
        SingleListNode slowIndex = head;
        SingleListNode fastIndex = head.next;
        while (fastIndex != null){
            if (fastIndex.val == target){
                slowIndex.next = fastIndex.next;
                fastIndex = slowIndex.next;
            } else {
                slowIndex = slowIndex.next;
                fastIndex = fastIndex.next;
            }
        }
        return head;
    }

    /*
    * 套路法
    *   时间久了就是会忘了套路，对于链表，其头节点是很特殊的，当头节点出现目标值或空值时，会出现边界条件，因此可以使用“套头”的方式，给头节点再套个超级头节点
    *   此外对于被删除元素前位元素指针和被删除元素指针可以使用node和node.next形式表示，无需两个指针
    * */
    public static SingleListNode method2(SingleListNode head, int target){
        // 头节点套头法，使得头节点的处理逻辑与后续节点一致
        SingleListNode re = new SingleListNode(0, head);
        SingleListNode node = re;
        while (node.next != null){
            if (node.next.val == target)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return re.next;
    }
}
