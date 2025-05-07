package com.example.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertionSort {

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
//            System.out.println(Arrays.toString(arr) + " i = " + i + " j = " + j);
            // 找到插入的位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 将元素插入到正确的位置
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        System.out.println(Arrays.toString(arr));

        System.out.println("排序后:");

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
