package com.example.sort;

import java.util.Arrays;

/**
 * 快速排序，分治法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5};

        System.out.println(Arrays.toString(arr));

        System.out.println("\n排序后: ");

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int height) {
        if (low < height) {
            // 找到分区点
            int partitionIndex = partition(arr, low, height);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, height);
        }
    }

    private static int partition(int[] arr, int low, int height) {
        int pivot = arr[height];

        int i = low - 1;

        // ij互换的意义是把小于基准元素的放到前面，
        // 因为已经确认前面的是比基准的要大，
        // 所以这时候要交换的j的位置必然也是小于前面的数字
        for (int j = low; j < height; j++) {
            if (arr[j] < pivot) {
                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, height);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
