package study.section.three;
/*
* p42 3.4长度最小的子数组
*   给定一个含有 n 个正整数的数组和一个正整数 target 。
*   找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
*   并返回其长度。如果不存在符合条件的子数组，返回 0 。
*
* */
public class LC209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(method2(nums, target));
    }

    /*
    * 自想解法
    * 滑动窗口-暴力版：长度从小到大遍历，第一次遇到子数组和>=target时，返回此子数组长度，目测最坏时间复杂度到O(n^2)
    * */
    public static int method1(int[] nums, int target){
        //子数组最长为n，所以从长度为1（d=i+1）开始，进行逐层判断，是否有d长度下，大于等于target的连续子数组
        int head;
        int end;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            //子数组的头指针和尾指针
            head = 0;
            end = head + i;
            sum = 0;
            for (int j = head; j <= end; j++) {
                sum += nums[j];
            }
            if (sum >= target){
                System.out.println("head:"+head+" end:"+end);
                return i+1;
            } else {
                //尾指针必须在nums范围内
                while (end < nums.length - 1){
                    //每次后推一个窗口格，因为是连续子数组，所以无需重复计算公共部分，只要减旧头加新尾即可
                    sum = sum - nums[head++] + nums[++end];
                    if (sum >= target){
                        System.out.println("head:"+head+" end:"+end);
                        return i+1;
                    }
                }
            }

        }
        return  0;
    }

    /*
    * 代码随想录解法
    * 滑动窗口-优质版：找到以下标head为开头，end结尾的最短的>=target的子数组，然后记录长度，再将窗口头向后推移（即将头下标从head变为head+1，end不变），
    *   然后计算当前窗口的和与target的大小关系，当>=target时，更新长度（取新旧二者最小值），并且继续将窗口头向后推移，若<target则将窗口延长（将end变为end+1），
    *   然后继续判断，直到end到达nums尾，且当前的子数组和<traget，得到全局最小长度
    * */
    public static int method2(int[] nums, int target){
        int sum = 0;
        int minDeep = nums.length + 1;
        int head = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target){
                minDeep = Math.min(minDeep, end - head + 1);
                sum -= nums[head++];
            }
        }
        return minDeep > nums.length ? 0 : minDeep;
    }

    /*
    * 代码随想录解法
    * 双循环暴力法：以每个下标为开始，找到当前开始下标的最短的>=target的子数组，并与最短长度进行对比
    * */
    public static int method3(int[] nums, int target){
        int minDeep = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    minDeep = Math.min(minDeep, j - i + 1);
                    break;
                }
            }
        }
        return minDeep > nums.length ? 0 : minDeep;
    }

    /*
    * 总结：
    *  先说方法3，应该是最直接的思路，但是我第一次却没有想到。。。因为这个题目太容易想到使用滑动窗口了，所以一开始就想怎么推窗口去找最短，所以反而忽略了基础思路
    *   整体来看方法3也不差，因为有跳出机制，所以虽然量级是O(n^2)，但平均上不会太离谱
    *  其次是方法2和3有个特点，即需要将窗口头推到数组尾才能确定出最小值，而方法1的特点是找到一个>=target的即可判断是最小值（因为是从最小值1开始递增的）
    *  从这个角度来说，方法1还是有点创新的
    *
    *  整体来说时间复杂度上 3>1>2
    *
    *  滑动窗口的核心在于如何高效的推窗口，在本题中，高效表现在利用新旧两个窗口中连续数组一定有部分重合值，这部分重合值的求和可以省略；
    *   此外本题中滑动窗口的滑动步长都是1，因此这个变量算是固定的，更具难度的题目中，滑动步长也是一个变量
    *
    * */
}
