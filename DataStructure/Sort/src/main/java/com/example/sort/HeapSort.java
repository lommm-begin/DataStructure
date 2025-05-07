package com.example.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 构建堆：O(n)
 * 每次调整堆：O(log n)
 * 总时间复杂度：O(n log n)
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length - 1;

        // 构建堆
        for (int i =  n / 2; i >= 1; i--) {
            heapSort(arr, n, i);
        }

        // 开始排序
        for (int i = n; i > 1; i--) {
            arr[1] ^= arr[i];
            arr[i] ^= arr[1];
            arr[1] ^= arr[i];

            heapSort(arr, i, 1);
        }
    }

    // 调整为堆
    private static void heapSort(int[] arr, int n, int i) {
        int last = i; // 保存当前节点的下标
        int right = 2 * i + 1; // 右孩子下标
        int left = 2 * i; // 左孩子下标

        if (right < n && arr[right] > arr[last]) {
            last = right;
        }
        if (left < n && arr[left] > arr[last]) {
            last = left;
        }

        // 判断是否进行交换过，如果交换过，修改arr，并递归向下检查
        if (last != i) {
              arr[i] ^= arr[last];
              arr[last] ^= arr[i];
              arr[i] ^= arr[last];

              heapSort(arr, n, last);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 5, 7, 1, 3, 6, 2};

        System.out.println(Arrays.toString(arr));

        System.out.println("排序后:");

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
