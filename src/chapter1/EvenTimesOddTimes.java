package chapter1;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/4/23 10:38 下午
 */
public class EvenTimesOddTimes {
    public static void solution(int[] arr){
        int res = arr[0];
        for(int i =1; i < arr.length; i++){
            res ^= arr[i];
        }
        int res_flag = res & (~res+1);
        int x1 = res;
        for(int i = 0; i<arr.length;i++){
            if((arr[i] & res_flag) == 0){
                x1 = x1^arr[i];
            }
        }
        int x2 = res^x1;
        System.out.println(x1 + " " + x2);
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,4,4};
        solution(a);
    }
}
