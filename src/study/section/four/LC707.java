package study.section.four;

import study.section.util.structure.SingleListNode;

/*
* P57 4.3 设计链表
*   设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
*   如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
*   在链表类中实现这些功能：
*       get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
*       addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
*       addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
*       addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
*       deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
* */
public class LC707 {
    public static void main(String[] args) {

    }

    public static class MyLinkedList{
        // 套头节点
        private SingleListNode preHead;
        public MyLinkedList() {
            preHead = new SingleListNode(0, null);
        }

        /*
        * 从套头节点开始遍历至index，注意循环中，由于是从套头节点开始的所有i的上界为index+1
        * */
        public int get(int index){
            SingleListNode node = preHead;
            for (int i = 0; i < index + 1; i++) {
                node = node.next;
                if(node == null)
                    return -1;
            }
            return node.val;
        }

        public void addAtHead(int val){
            SingleListNode node = new SingleListNode(val, preHead.next);
            preHead.next = node;
        }

        public void addAtTail(int val){
            SingleListNode newNode = new SingleListNode(val, null);
            SingleListNode node = preHead;
            while (node.next != null)
                node = node.next;
            node.next = newNode;
        }
        /*
        * 对于index<=0的直接按照头插入执行
        * 对于index>0的，需要将指针移动到index的前一个位置，所以此处i的上界是index（与get函数对比着看）
        * */
        public void addAtIndex(int index, int val){
            if(index <= 0){
                addAtHead(val);
                return;
            }
            SingleListNode node = preHead;
            for (int i = 0; i < index; i++) {
                node = node.next;
                if(node == null)
                    return;
            }
            SingleListNode newNode = new SingleListNode(val, node.next);
            node.next = newNode;
        }
        /*
        * 与addAtIndex很相似，需要注意的是，有一种特殊情况：待删除元素超出链表尾元素的第n个（n>=2）可以通过for内判断跳出，
        * 而恰好是超出链表尾元素的第一个时无法跳出，因此在最后加入一个判断避免报错
        * */
        public void deleteAtIndex(int index){
            SingleListNode node = preHead;
            if(index >= 0){
                for (int i = 0; i < index; i++) {
                    node = node.next;
                    if(node == null)
                        return;
                }
                if (node.next != null)
                    node.next = node.next.next;
            }
        }
    }
}
