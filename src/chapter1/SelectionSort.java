package chapter1;
import static Utils.Utils.*;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/4/23 11:08 下午
 */
public class SelectionSort {
    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int flag_min = i;
            for (int j = i + 1; j < arr.length; j++) {
                flag_min = arr[j] < arr[flag_min] ? j : flag_min;
            }
            swap(arr, i, flag_min);
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            solution(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
