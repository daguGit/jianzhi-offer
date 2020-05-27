package com.github.dagugit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class _29_GetLeastNumbers {
    /**
     * 思路1：
     * 暴力的解法，将数组排序，获取前K个，时间复杂度 O(nlogn)
     * 1、特殊情况
     * -A、input 为空，input.length==0 return null
     * -B、k<=0||k>input.length return null
     * 2、将input排序，获得前k个
     * <p>
     * 思路2：时间复杂度 O(n)
     * 基于快速排序的方法，当 partition的值==k-1时，数组左侧即为所求
     * 1、特殊情况
     * -A、input 为空，input.length==0 return null
     * -B、k<=0||k>input.length return null
     * 2、使用快速排序
     * -A、获得partition
     * -B、if(partition<=k-1) return
     * -C、if(partition>k-1) end = k-1
     * -D、if(patition<k-1) start = k-1
     * <p>
     * 思路3；
     * 冒泡的方法
     * 基于冒泡排序，冒泡 K 次即可，时间复杂度 O(n2)
     * <p>
     * 思路4：
     * 基于小顶堆的思路，重复构建堆 K 次。 时间复杂度O(nlogn)
     * 1、构建一个小顶堆
     * -A:找到第一个非叶节点，根节点小于左右节点的话，交换，子节点重复此过程
     * -B：找到第二的非叶节点，重复A，直到根节点结束
     * 2、将根节点与最后一个节点交换，此为第一小元素
     * 3、重复构建根节点的小顶堆，K次，找到前K小元素
     * <p>
     * 思路5:
     * 基于大顶推的思路---------------借鉴网上的思路，很妙
     * 1、特殊情况
     * -A、input 为空，input.length==0 return null
     * -B、k<=0||k>input.length return null
     * 2、构建一个 K 节点的大顶推
     * 3、如果新加入的元素大于堆顶元素，堆出，并加入新元素，直到元素遍历完，保留在堆中的元素，即为所求。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length == 0) {
            return integers;
        }
        if (k <= 0 || k > input.length) {
            return integers;
        }
        Arrays.sort(input);
        for (int i = 0; i < k && i < input.length; i++) {
            integers.add(input[i]);
        }
        return integers;
    }

    public static void main(String[] args) {
        _29_GetLeastNumbers getLeastNumbers = new _29_GetLeastNumbers();
//        int[] arrays = {4,2,1,2,2,2,2,8};
        int[] arrays = {4, 5, 1, 6, 2, 7, 3, 8};
        long startTime = System.nanoTime();
        ArrayList<Integer> integers = getLeastNumbers.GetLeastNumbers(arrays, 4);
        //        ArrayList<Integer> integers = getLeastNumbers.GetLeastNumbers_QuickSort(arrays, 4);
//        ArrayList<Integer> integers = getLeastNumbers.GetLeastNumbers_HeapSort(arrays, 4);
//        ArrayList<Integer> integers = getLeastNumbers.GetLeastNumbers_HeapMaxSort(arrays, 4);
        integers.stream().forEach(a -> {
            System.out.println(a);
        });
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }


    public ArrayList<Integer> GetLeastNumbers_QuickSort(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length == 0) {
            return integers;
        }
        if (k <= 0 || k > input.length) {
            return integers;
        }

        this.quickSort(input, 0, input.length - 1, k);
        for (int i = 0; i < k && i < input.length; i++) {
            integers.add(input[i]);
        }
        return integers;
    }

    private void quickSort(int[] arr, int begin, int end, int K) {
        if (begin < end) {
            int partition = this.partition(arr, begin, end);
            if (partition == K - 1) {
                return;
            } else if (partition > K - 1) {
                this.quickSort(arr, begin, partition - 1, K);
            } else {
                this.quickSort(arr, partition + 1, end, K);
            }
        }
    }

    private int partition(int[] arrays, int start, int end) {
        if (start > end) {
            return start;
        }
        int p = start;
        int q = end;
        int temp = arrays[start];
        while (p < q) {
            while (arrays[q] >= temp && q > start && p < q) {
                q--;
            }
            arrays[p] = arrays[q];
            while (arrays[p] <= temp && p < end && p < q) {
                p++;
            }
            arrays[q] = arrays[p];
        }
        arrays[p] = temp;
        return p;
    }

    /**
     * 本思路借用堆排序的思路
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_HeapSort(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length == 0) {
            return integers;
        }
        if (k < 0) {
            return integers;
        }
        if (k > input.length) {
            k = input.length;
        }
        integers = heapSort(input, k);
        return integers;
    }

    /**
     * 获取arrays的前K小
     *
     * @param arrays
     * @param K
     * @return
     */
    private ArrayList<Integer> heapSort(int[] arrays, int K) {
        if (K > arrays.length) {
            K = arrays.length;
        }
        for (int i = (arrays.length) / 2 - 1; i >= 0; i--) {
            heapSort(arrays, i, arrays.length);
        }
        int length = arrays.length;
        for (int i = 0; i < K && length >= 1; i++) {
            int index0 = arrays[0];
            arrays[0] = arrays[length - 1];
            arrays[length - 1] = index0;
            length--;
            heapSort(arrays, 0, length);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < K && (arrays.length - 1 - i) >= 0; i++) {
            integers.add(arrays[arrays.length - 1 - i]);
        }
        return integers;

    }

    private void heapSort(int[] arrays, int patent, int length) {
        while (patent < length) {
            int child = patent * 2 + 1;
            if (child >= length) {
                break;
            }
            if ((patent * 2 + 1) < length && (patent * 2 + 2) < length && arrays[patent * 2 + 2] < arrays[patent * 2 + 1]) {
                child++;
            }
            if (arrays[patent] > arrays[child]) {
                int temp = arrays[patent];
                arrays[patent] = arrays[child];
                arrays[child] = temp;
            }
            patent = child;
        }
    }


    public ArrayList<Integer> GetLeastNumbers_HeapMaxSort(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length == 0) {
            return integers;
        }
        if (k <= 0 || k > input.length) {
            return integers;
        }
        // 构造优先队列，排序方法是自然数顺序的逆序，所以是个最大堆，这样这个堆的堆顶就是所有数中的最大数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.add(input[i]);
            } else {
                // 若堆内最大的数字大于数组中的数字，则将数字出堆，并放入这个小的数
                if (input[i] < maxHeap.peek()) {
                    maxHeap.remove();
                    maxHeap.add(input[i]);
                }
            }
        }
        // 结束上面循环后，堆内就是最小的k个数
        while (!maxHeap.isEmpty()) {
            integers.add(maxHeap.remove());
        }
        return integers;
    }

}
