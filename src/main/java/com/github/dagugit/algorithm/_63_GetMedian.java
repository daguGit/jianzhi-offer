package com.github.dagugit.algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class _63_GetMedian {
    public ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * 思路1：
     * 1、声明list直接插入即可
     * 2、中位数排列后获取
     * 思路2：
     * 1、小顶堆
     * TODO 添加小顶堆的解法
     *
     * @param num
     */
    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() % 2 == 1) {
            return new Double(list.get(list.size() / 2));
        }
        if (list.size() % 2 == 0) {
            return new Double(list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        }
        return null;
    }

    public static void main(String[] args) {
        _63_GetMedian getMedian = new _63_GetMedian();
        getMedian.Insert(1);
        getMedian.Insert(5);
        getMedian.Insert(3);
        getMedian.Insert(2);
        getMedian.Insert(2);
        getMedian.Insert(7);
        getMedian.list.stream().forEach(a -> {
            System.out.println(a);
        });
        System.out.println(getMedian.GetMedian().doubleValue());
    }
}
