package com.github.dagugit.think;

import java.util.Arrays;

/**
 * 各种查找算法
 */
public class _2020_06_01_Sort {

    /**
     * 快速排序
     * 思路：
     * 递归、分治的思想，先取一个基点，设置收尾两个指针，尾结点小于基点的放到前面、首节点大于基点的放到后面，如此递归；
     * 1、选定一个基点 temp = array[start]
     * 2、定义两个指针 p=start、q=end
     * 3、当p>temp时，p++，q<temp时，q--，交换
     * 4、将temp放到p处
     * 5、递归左右部分
     */
    public void quickSort(int[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);
    }

    public void quickSort(int[] arrays, int start, int end) {
        if (start > end) {
            return;
        }
        int p = start;
        int q = end;
        int temp = arrays[start];
        while (p < q) {
            while (arrays[q] > temp && q > start && p < q) {
                q--;
            }
            arrays[p] = arrays[q];
            while (arrays[p] < temp && p < end && p < q) {
                p++;
            }
            arrays[q] = arrays[p];
        }
        arrays[p] = temp;
        quickSort(arrays, start, p - 1);
        quickSort(arrays, p + 1, end);
    }

    /**
     * 选择排序
     * 思路：
     * 1、每次从生下的数组中选择最小的放到前面
     * 2、共循环n次
     *
     * @param arrays
     */
    public void selectSort(int[] arrays) {
        if (arrays == null || arrays.length == 1) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] < arrays[i]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 思路：
     * 1、如果a[j]>a[j+1]，不断交换，j++；
     * 2、一共循环arrays.length次
     *
     * @param arrays
     */
    public void bubbleSort(int[] arrays) {
        if (arrays == null || arrays.length == 0 || arrays.length == 1) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }


    /**
     * 堆排序算法
     * 堆排序，实际是选择排序的一种，每次从第一个非叶节点开始选择最大的节点，一直选到根节点。
     * 明确 left=parent*2+1，right=parent*2+2 第一个非叶节点等于index= length/2   parent = (left+1)/2=(right+1)/2
     * 思路：
     * 1、对第一个非叶节点构建大顶推
     * -A；index = length/2
     * -B: 寻找 左节点 index*2+1和右节点 index*2+2 的最大值 max，
     * -C：将max与父节点 index的值互换
     * -D: 另parent=child，继续互换
     * 2、重复步骤1，对其他非叶节点构建
     * 3、构建到根节点后，将 swap(array,0,array.length-1) ,array长度-1
     *
     * @param
     * @return
     */

    public static void heapSort(int[] arr) {
        //将待排序序列初始化成堆
        for (int i = arr.length / 2; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length - 1);
        }
        //开始排序
        for (int i = arr.length - 1, temp = 0; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            HeapAdjust(arr, 0, i);
        }
    }

    //对堆进行调整
    public static void HeapAdjust(int[] arr, int parent, int len) {
        //记录父节点的值
        int temp = arr[parent];
        //寻找左孩子节点
        int child = 2 * parent + 1;
        while (child < len) {
            //从左孩子和右孩子节点中选取较大的
            if (child + 1 < len && arr[child + 1] > arr[child]) {
                child++;
            }
            //如果父节点大于两个孩子节点，则不用交换
            if (arr[parent] > arr[child]) {
                break;
            }
            //将父节点与较大的子节点进行交换
            arr[parent] = arr[child];
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = temp;
    }

    //堆排序

    /**
     * 归并排序
     * @param arrays
     */
    public  int[] mergeSort(int[] arrays){
        if (arrays.length < 2) {
            return arrays;
        }
        int mid = arrays.length / 2;
        int[] left = Arrays.copyOfRange(arrays, 0, mid);
        int[] right = Arrays.copyOfRange(arrays, mid, arrays.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public  int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] arr = {55, 3, 21, 58, 9, 101, 43, 19, 27};
        System.out.println("排序前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        heapSort(arr);
        System.out.println("\n排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        long end = System.nanoTime();
        System.out.println("\n排序用时：" + (end - start) + "ns");
    }
}
