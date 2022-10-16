class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //个位不到9
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }
            //个位是9的情况，进位
            digits[i] = 0;
            //如果进位到最后一位，则用扩容数组返回结果
            if (i == 0){
                int[] tenExponent = new int[digits.length + 1];
                tenExponent[0] = 1;
                for (int j = 1; j < tenExponent.length; j++) {
                    tenExponent[j] = 0;
                }
                return tenExponent;
            }
        }
        return digits;
    }
}
