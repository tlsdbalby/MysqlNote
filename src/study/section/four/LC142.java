package study.section.four;

import study.section.util.structure.CreateSingleList;
import study.section.util.structure.SingleListNode;

/*
* P65 142. 环形链表 II
*   给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
*   如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
*   为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
*   如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
*   不允许修改 链表。
* */
public class LC142 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int index = 2;
        SingleListNode head = CreateSingleList.CreateSingleListByArrayWithCycle(arr, index);
        SingleListNode node = head;
        for (int i = 0; i < 12; i++) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("===================================");
        SingleListNode enter = method1(head);
        System.out.println(enter.val);
    }
    /*
    * 使用异步指针：两个指针的步长不同，p1为1，p2为2，当存在p2==p1时说明存在环，当p1 or p2==null时证明无环
    *   计算环长度：在第一次p1==p2时，记录这个节点并开始计数，当p1第二次到达这个节点时，计数大小即为环大小
    *   找到环入口：见dmsxl P66思路，通过数学推导可知：从头节点出发 与从第一次相遇除出发的指针，在以步长为1的前进过程中，相遇点为环入口
    * */
    public static SingleListNode method1(SingleListNode head){
        if (head == null)
            return null;
        SingleListNode p1 = head;
        SingleListNode p2 = head;
        SingleListNode encounter = null;
        int count = 0;
        int isCycle = 0;
        while (true){
            p1 = p1.next;
            if (p2.next != null)
                p2 = p2.next.next;
            else
                return null;
            if (p1 == null)
                return null;
            if (p2 == null)
                return null;
            if (isCycle == 1 && p1 == encounter){
                System.out.println("Cycle length = " + count);
                break;
            }
            if (p1 == p2 && isCycle == 0){
                System.out.println("There is a cycle");
                encounter = p1;
                isCycle = 1;
            }
            if (isCycle == 1)
                count++;

        }
        SingleListNode p3 = head;
        SingleListNode p4 = encounter;
        while (p3 != p4){
            p3 = p3.next;
            p4 = p4.next;
        }
        return p3;
    }
}
