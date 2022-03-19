package study.section.util.structure;

public class CreateSingleList {
    public static SingleListNode CreateSingleListByArray(int[] arr){
        int n = arr.length;
        if (n < 1)
            return null;
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
