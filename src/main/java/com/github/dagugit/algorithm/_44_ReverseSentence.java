package com.github.dagugit.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class _44_ReverseSentence {
    /**
     * 思路：
     * 1、特殊情况
     * str==null||str.length==0 return null
     * 2、使用空格 分割str，并reverse 返回
     * todo 其他思路
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str;
        }
        if (str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        List<String> strings = Arrays.asList(s);
        Collections.reverse(strings);
        StringBuffer sb = new StringBuffer();
        strings.stream().forEach(a -> {
            sb.append(a + " ");
        });
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        _44_ReverseSentence reverseSentence = new _44_ReverseSentence();
//        String s = reverseSentence.ReverseSentence("student. a am I");
        String s = reverseSentence.ReverseSentence(" ");
        System.out.println(s);
    }
}

