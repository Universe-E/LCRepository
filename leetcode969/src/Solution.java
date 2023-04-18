import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length,max = arr.length;
        List<Integer> res = new ArrayList<>();
        while (max != 1) {
            int i = 0;
            while (arr[i] != max) i++;
            int[] temp = Arrays.copyOf(arr,i+1);
            for (int j = 0; j < temp.length; j++) {
                arr[j] = temp[temp.length-j-1];
            }
            res.add(i+1);
            int[] temp2 = Arrays.copyOf(arr,max);
            for (int j = 0; j < temp2.length; j++) {
                arr[j] = temp2[temp2.length-j-1];
            }
            res.add(max);
            max--;
        }
        return res;
    }
}