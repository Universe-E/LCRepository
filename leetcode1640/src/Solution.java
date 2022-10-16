class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length,m = pieces.length;
        int i = 0;
        while (i < n) {
            boolean isValid = false;
            for (int[] piece : pieces) {
                if (i < n && piece[0] == arr[i]) {
                    isValid = true;
                    for (int value : piece) {
                        if (value == arr[i]) i++;
                        else return false;
                    }
                }
            }
            //如果遍历一遍pieces都没找到，直接返回false
            if (!isValid) return false;
        }
        return true;
    }
}