import java.util.Arrays;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/4/25 3:12 下午
 */


class Solution {

    public static void moveZeroes(int[] nums) {
        int cor = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, cor++, i);
            }
        }

    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a]= arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}