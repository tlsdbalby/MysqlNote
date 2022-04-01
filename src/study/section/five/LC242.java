package study.section.five;

import java.util.HashMap;
import java.util.Map;

/*
* P74 242. 有效的字母异位词
*   给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
*   注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
*   s 和 t 仅包含小写字母
*
* */
public class LC242 {
    public static void main(String[] args) {

    }

    /*
    * 利用HashMap的特性，使用一个HashMap记录s字符串的字符出现次数，然后使用t字符串做对比，看能不能对的上
    *   变形：因为字符只有26个小写字母，所以可以用长度为26的数组来代替HashMap
    * */
    public static boolean method1(String s, String t){
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hashMap1.containsKey(c))
                hashMap1.put(c, hashMap1.get(c) + 1);
            else hashMap1.put(c, 1);
        }
        for (char c : t.toCharArray()) {
            if (hashMap1.containsKey(c)){
                //若s的c少于t则false
                if (hashMap1.get(c) == 0)
                    return false;
                hashMap1.put(c, hashMap1.get(c) - 1);
            }
            //若s不存在c则false
            else return false;
        }
        for (Map.Entry<Character, Integer> entry : hashMap1.entrySet()) {
            //若有剩余则false
            if(entry.getValue() != 0)
                return false;
        }

        return true;
    }

    /*
    * 变形：因为字符只有26个小写字母，所以可以用长度为26的数组来代替HashMap
    *   需要注意的是：两个字符串中，用短字符串填充数组，长字符串去对比，
    *   这样可以避免：长字符串完全包含短字符串从而导致判断失败的情况，例如ab和a，当用ab去填充数组时，会返回true
    * */
    public static boolean method2(String s, String t){
        String longer = s.length() > t.length() ? s : t;
        String shorter = longer.equals(s) ? t :s;
        int[] arr = new int[26];
        for (char c : shorter.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : longer.toCharArray()) {
            if (arr[c - 'a'] == 0)
                return false;
            else arr[c - 'a']--;
        }
        return true;
    }
}
