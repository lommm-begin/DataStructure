package com.example.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {


    private static void bullleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        System.out.println(Arrays.toString(arr));

        System.out.println("排序后:");

        bullleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
