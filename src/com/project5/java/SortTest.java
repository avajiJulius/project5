package com.project5.java;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {5,2,4,6,1,3,2,6};
//        int[] arr = {4 ,2, 1, 3};
        sort(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int p, int r) {
        if(p < r) {
            int q = (p+r)/2;
            sort(arr, p, q);
            sort(arr, q+1, r);
            merge(arr,p, q, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int[] a = new int[q-(p-1)];
        int[] b = new int[r-q];
        int[] result = new int[a.length + b.length];
        System.arraycopy(arr, p-1,a,0, a.length);
        System.arraycopy(arr, q, b,0, b.length);


        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length ) {
            if(aIndex <= a.length - 1 && bIndex <= b.length - 1) {
                if(a[aIndex] < b[bIndex]) {
                    result[aIndex + bIndex] = a[aIndex++];
                }
                else {
                    result[aIndex + bIndex] = b[bIndex++];
                }
            } else {
                if (aIndex > a.length - 1 ) {
                    result[aIndex + bIndex] = b[bIndex++];
                } else {
                    result[aIndex + bIndex] = a[aIndex++];
                }
            }
        }
        System.arraycopy(result, 0, arr, p-1, result.length);
        System.out.println(Arrays.toString(result));
    }

}
