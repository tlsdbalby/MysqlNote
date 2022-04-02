package study.section.five;

import java.util.HashMap;

/*
* P78 1. 两数之和
*   给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
*   你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
* */
public class LC1 {
    public static void main(String[] args) {

    }

    /*
    * 暴力法，两个循环逐对筛选
    * */
    public static int[] method1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    * hash法，一边将数组内的数据填充到map<元素值, 元素下标>中，一边查询当前元素与map中是否存在能够组成target的组合
    *   一边放一边查，是缩减时间复杂度的关键
    * */
    public static int[] method2(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (hashMap.containsKey(need))
                return new int[]{i, hashMap.get(need)};
            else hashMap.put(nums[i], i);
        }
        return null;
    }
}
