package study.section.util.structure;

public class CreateSingleList {
    /*
    * param: 链表填充的数据
    * */
    public static SingleListNode CreateSingleListByArray(int[] arr){
        int n = arr.length;
        if (n < 1)
            return null;
        if (n == 1)
            return new SingleListNode(arr[0], null);
        SingleListNode[] listNodes = new SingleListNode[n];
        for (int i = 0; i < n; i++) {
            listNodes[i] = new SingleListNode(arr[i], null);
        }
        SingleListNode head = listNodes[0];
        for (int i = 0; i < n; i++) {
            listNodes[i].next = listNodes[i+1];
            if (i == n - 2)
                break;
        }
        return head;
    }
}
