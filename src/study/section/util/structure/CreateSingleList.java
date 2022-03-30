package study.section.util.structure;

public class CreateSingleList {
    /*
    * method: 根据参数生成一个无环单链表
    * param: int[] arr
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

    /*
    * method: 根据数据与下标生成一个有环单链表，环入口为指定下标，环尾为链表尾
    * param: int[] arr, int index
    * */
    public static SingleListNode CreateSingleListByArrayWithCycle(int[] arr, int index){
        int n = arr.length;
        if (n < 1 || index < 0 || index > n - 1)
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
        listNodes[n - 1].next = listNodes[index];
        return head;
    }
}
