package study.section.five;

import java.util.HashMap;
import java.util.Map;

/*
* P80 454. 四数相加 II
*   给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
*       0 <= i, j, k, l < n
*       nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
*       1 <= n <= 200
* */
public class LC454 {
    public static void main(String[] args) {

    }

    /*
    * 暴力法是四层for，O(n^4)就直接不考虑了
    * 因为nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 所以 (nums1[i] + nums2[j]) = -(nums3[k] + nums4[l]) 即 a = -b
    *   a和b的计算是O(n^2)，将a和b的结果放到map<值, 频率>中，然后再对比一遍
    * 约等于将四个值->两个值，和LC1异曲同工
    * */
    public static int method1(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int count = 0;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int num = i + j;
                if (!hashMap1.containsKey(num))
                    hashMap1.put(num, 1);
                else hashMap1.put(num, hashMap1.get(num)+1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int num = i + j;
                if (!hashMap2.containsKey(num))
                    hashMap2.put(num, 1);
                else hashMap2.put(num, hashMap2.get(num)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            if (hashMap2.containsKey(-1 * entry.getKey()))
                //一个a = -b，在组合数量上为两者的频率相乘，所以累加的数量是乘积
                count += entry.getValue() * hashMap2.get(entry.getKey());
        }

        return count;
    }

    /*
    * 在method1的基础上改进一下，只需要一个存放a值的Map即可，b的值边组合边查询a的Map，寻找合法项。
    * */
    public static int method2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int num = i + j;
                if (!hashMap1.containsKey(num))
                    hashMap1.put(num, 1);
                else hashMap1.put(num, hashMap1.get(num) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int num = -1 * (i + j);
                if (hashMap1.containsKey(num))
                    count += hashMap1.get(num);
            }
        }
        return count;
    }
}
