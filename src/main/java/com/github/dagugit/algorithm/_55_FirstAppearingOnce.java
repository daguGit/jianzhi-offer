package com.github.dagugit.algorithm;

import java.util.HashMap;

/**
 * 字符流中第一个不重复的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

/**
 * 思路：
 * 目标实现插入一次，返回一个第一次出现一次的字符
 * 声明一个 StringBuffer 用于盛放插入的字符，
 * 声明一个map记录字符数
 */
public class _55_FirstAppearingOnce {
    //boolean[] array = new boolean[26];
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        map.put(ch, map.get(ch) == null ? 1 : map.get(ch) + 1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (sb.length() == 0) {
            return '#';
        }
        for (int i = 0; i < sb.length(); i++) {
            if (map.get(sb.charAt(i)) == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        _55_FirstAppearingOnce fa = new _55_FirstAppearingOnce();
        System.out.println(fa.FirstAppearingOnce());

        fa.Insert('g');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('o');
        System.out.println(fa.FirstAppearingOnce());

        fa.Insert('o');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('g');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('l');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('e');
        System.out.println(fa.FirstAppearingOnce());


    }


//    ************ 以下是参考他人思路********
//    利用一个int型数组表示256个字符，这个数组初值置为-1.
//    没读出一个字符，将该字符的位置存入字符对应数组下标中。
//    若值为-1标识第一次读入，不为-1且》0表示不是第一次读入，将值改为-2.
//    之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
//    public class Solution {
//        //Insert one char from stringstream
//        private int[] occurence = new int[256];
//        private int index;
//
//        public Solution(){
//            for(int i=0;i<256;i++){
//                occurence[i] = -1;
//            }
//            index = 0;
//        }
//        void Insert(char ch)
//        {
//            if(occurence[ch] == -1)
//                occurence[ch] = index;
//            else if(occurence[ch] >= 0)
//                occurence[ch] = -2;
//
//            index++;
//        }
//        //return the first appearence once char in current stringstream
//        char FirstAppearingOnce()
//        {
//            char ch = '\0';
//            int minIndex = Integer.MAX_VALUE;
//            for(int i=0;i<256;i++){
//                if(occurence[i] >=0 && occurence[i]<minIndex){
//                    ch = (char)i;
//                    minIndex = occurence[i];
//                }
//            }
//            if(ch == '\0')
//                return '#';
//            return ch;
//        }
//    }
}
