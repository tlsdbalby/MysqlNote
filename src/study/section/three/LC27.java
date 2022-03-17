package study.section.three;
/*
* p39 3.3移除元素
* */
public class LC27 {
    public static void main(String[] args) {

    }
    /*
    * 暴力法
    *   两层for循环，每当遇到val值时，就将后续所有元素向前移动（注意这次外层循环下标不变）
    *   O(n^2) O(1)
    * */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; ) {
            if (nums[i] == val){
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
            } else i++;
        }
        return size;
    }
    /*
    * 快慢指针
    *   比较巧妙的思路：按照要求去除val值后，原数组必然变成[非val, 非val, 非val...]，
    *   约等于在原数组的基础上，重新依次赋值，需要一个搜寻下标和赋值下标，搜寻下标判断指向元素是否为val，赋值下标将非val赋到当前所指位置（一开始两者重合，直到遇到第一个val，快慢分离）
    *   最后赋值指针所代表的长度就是数组实际长度
    * */
    public int removeElement2(int[] nums, int val) {
        int fastIndex = 0;//搜索指针
        int lastIndex = 0;//赋值指针
        for (; fastIndex < nums.length; fastIndex++){
            if(nums[fastIndex] != val) {
                nums[lastIndex++] = nums[fastIndex];
            }
        }
        return lastIndex;
    }
}
