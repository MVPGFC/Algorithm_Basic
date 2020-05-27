package chapter2;

import java.util.Arrays;

import static Utils.Utils.*;
import static Utils.Utils.isEqual;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/5/26 11:22 上午
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr.length < 2 || arr == null)
            return;
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if(L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = process(arr, L, R);
            quickSort(arr, 0, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] process(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while(L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]){
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testTime = 2;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

