package study.section.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
* P76 349. 两个数组的交集
*   给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
*   0 <= nums1[i], nums2[i] <= 1000
* */
public class LC349 {
    public static void main(String[] args) {

    }

    /*
    * 两个数组的交集，即两个数组都包含的元素，用set完成，一个数组填充set，然后拿set与另一个数组对比，将重合的再用一个set记录下来再转换成数组。
    * */
    public static int[] method1(int[] arr1, int[] arr2){
        if (arr1.length > arr2.length)
            method1(arr2, arr1);
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : arr1) {
            set.add(n);
        }
        for (int n : arr2) {
            if (set.contains(n)){
                set2.add(n);
            }
        }
        int[] re = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            re[i++] = integer;
        }
        return re;
    }
}
