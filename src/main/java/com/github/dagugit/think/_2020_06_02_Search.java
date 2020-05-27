package com.github.dagugit.think;

/**
 * 各种查找算法
 */
public class _2020_06_02_Search {
    //binarySearch

    /**
     * 二分查找
     *
     * @param array
     * @param n
     */
    public void binarySearch(int[] array, int n) {
        if (array == null || array.length == 0) {
            return;
        }
        int a = binarySearchCore(array, n, 0, array.length - 1);
        System.out.println(a);
    }

    private int binarySearchCore(int[] array, int n, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == n) {
            return mid;
        }
        if (array[mid] > n) {
            return binarySearchCore(array, n, start, mid - 1);
        }
        if (array[mid] < n) {
            return binarySearchCore(array, n, mid + 1, end);
        }
        return 0;
    }

    public static void main(String[] args) {
        _2020_06_02_Search search = new _2020_06_02_Search();
        int[] array = {1, 4, 2, 5, 3, 5};

        search.binarySearch(array, 9);
    }
}
