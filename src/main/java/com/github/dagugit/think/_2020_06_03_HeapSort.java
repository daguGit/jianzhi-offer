package com.github.dagugit.think;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2020_06_03_HeapSort {
    /**
     * 测试使用 api 创建堆
     *
     * @param array
     */
    public void heapSort(int[] array) {
        //构建一个小顶堆
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
        }
        this.pintQueue(minHeap);
        //构建一个大顶推
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            maxHeap.add(array[i]);
        }
        this.pintQueue(maxHeap);
        //构建一个K元素的大顶推
        Queue<Integer> maxKHeap = new PriorityQueue<Integer>(5, Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            maxKHeap.add(array[i]);
        }
        this.pintQueue(maxKHeap);
    }

    private void pintQueue(Queue<Integer> queue) {
        // 结束上面循环后，堆内就是最小的k个数
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _2020_06_03_HeapSort heapSort = new _2020_06_03_HeapSort();
        int[] arrays = {4, 5, 1, 6, 2, 7, 3, 8};
        heapSort.heapSort(arrays);
    }
}
