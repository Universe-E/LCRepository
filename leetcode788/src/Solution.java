import java.util.ArrayList;

class Solution {
    //每一位数都在[2,5,6,9,0,1,8]之内，且至少有一个在[2,5,6,9]之内
    public int rotatedDigits(int n) {
        int[] nums = new int[] {2,5,6,9,0,1,8};
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            char[] arr = Integer.toString(i).toCharArray();
            boolean valid = false;
            for (char c : arr) {
                int digit = c - '0';
                if (!numList.contains(digit)) {
                    valid = false;
                    break;
                }
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) valid = true;
            }
            if (valid) res++;
        }
        return res;
    }
}