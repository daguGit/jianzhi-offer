package com.github.dagugit.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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
     * 1、声明list直接插入，并排序即可
     * 2、中位数排列后获取
     * <p>
     * 思路2：
     * 上一个思路利用排序，时间复杂度平均 O(nlogn),使用插入排序可将时间复杂度降到 O(n)
     * 1、声明list，按照插入排序的思路，将新插入的数字放到list中
     * 2、中位数直接 n/2 || (n/2+(n+1)/2)/2 获取
     * <p>
     * 思路3：
     * 像这种获取数组中单个极值问题时，习惯用堆来实现，但怎样使用堆来实现获取中为数？
     * --可以左边使用大顶推，右边使用小顶堆来实现，并且保证左右两侧数目平衡
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

    /**
     * 最大堆和最小堆方法
     * --这种思路想不到，借鉴网上的思路
     * 思路：最大堆和最小堆
     * <p>
     * 当数据保存到容器中时，可以分为两部分，左边一部分的数据要比右边一部分的数据小。
     * 假设，P1是左边最大的数，P2是右边最小的数，即使左右两部分数据不是有序的，我们也有一个结论就是：左边最大的数小于右边最小的数。
     * 因此，我们可以有如下的思路：用一个最大堆实现左边的数据存储，用一个最小堆实现右边的数据存储，
     * 向堆中插入一个数据的时间是O(logn)，而中位数就是堆顶的数据，只需要O(1)的时间就可得到。
     * 而在具体实现上，首先要保证数据平均分配到两个堆中，两个堆中的数据数目之差不超过1，为了实现平均分配，
     * 可以在数据的总数目是偶数时，将数据插入最小堆，否则插入最大堆。
     * 此外，还要保证所有最大堆中的数据要小于最小堆中的数据。所以，新传入的数据要和最大堆中最大值或者最小堆中的最小值比较。
     * 当总数目是偶数时，我们会插入最小堆，但是在这之前，我们需要判断这个数据和最大堆中的最大值哪个更大，如果最大值中的最大值比较大，
     * 那么将这个数据插入最大堆，并把最大堆中的最大值弹出插入最小堆。由于最终插入到最小堆的是原最大堆中最大的，
     * 所以保证了最小堆中所有的数据都大于最大堆中的数据。
     *
     * @param args
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;

    public void Insert2(Integer num) {
        count++;
        //偶数，插入最小堆
        if (count % 2 == 0) {
            //如果num小于最大堆，那么先插入最大堆
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            //奇数，插入最大堆
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public Double GetMedian2() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() / 1.0;
        } else {
            return minHeap.peek() / 1.0;
        }
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
