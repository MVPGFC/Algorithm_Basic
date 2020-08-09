package stringCollection;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/9 9:46 上午
 */
public class IsDeformationClass {
    public boolean isDeformation(String str1, String str2){

        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        int[] arr = new int[256];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        for (int i = 0; i < str1Arr.length; i++) {
            arr[str1Arr[i]] ++ ;
        }

        for (int i = 0; i < str2Arr.length; i++) {
            if ( --arr[str2Arr[i]] < 0)
                return false;
        }
        return true;
    }
}
