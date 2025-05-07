package com.example.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
            if (left < right) {
                // 防止 right + left 过大导致溢出
                // 比如100和110，即100 + 10 / 2
                int mid = left + (right - left) / 2;

                // 将数组递归分割成只有一个元素的子数组
                // 即当left == right 说明下标位置是一样的，已经形成了每个子数组只有一个元素，这时候开始回溯
                mergeSort(arr, left, mid, temp);
                mergeSort(arr, mid + 1, right, temp);

                // 当调用这个方法的时候，已经被递归地分割成了多个只有一个元素的子数组
                merge(arr, left, mid, right, temp);
            }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        // 比较两个子数组的元素，按序放入temp
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 其中一个子数组的已经放完，直接将剩下的一个子数组里的所有元素依次放入
        // 将剩余元素拷贝进temp
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将排序好的数组覆盖原来的位置
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        System.out.println(Arrays.toString(arr));

        System.out.println("排序后:");

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
