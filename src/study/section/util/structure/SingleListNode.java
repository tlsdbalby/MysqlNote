package study.section.util.structure;

public class SingleListNode {
    public int val;
    public SingleListNode next;

    public SingleListNode(int val, SingleListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }
}
