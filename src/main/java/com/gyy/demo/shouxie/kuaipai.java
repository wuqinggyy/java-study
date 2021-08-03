package com.gyy.demo.shouxie;

public class kuaipai {


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quick(int[] arr, int left, int right) {

        if (arr == null || arr.length < 1) {
            return;
        }

        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int key = arr[left];
        while (l != r) {

            while (arr[r] >= key && l < r) {
                r--;
            }
            while (arr[l] <= key && l < r) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, l, left);

        quick(arr, left, l - 1);
        quick(arr, l + 1, right);

    }

    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
