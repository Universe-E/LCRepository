import java.util.Arrays;

class Solution {
    public int minimizeXor(int num1, int num2) {
        char[] arr1 = Integer.toBinaryString(num1).toCharArray();
        String s2 = Integer.toBinaryString(num2);
        int n2 = 0;
        //得到num2的置位数
        for (int i = 0; i < s2.length(); i++) if (s2.charAt(i) == '1') n2++;
        char[] arr2 = new char[Math.max(arr1.length,n2)];
        Arrays.fill(arr2, '0');
        //找到从前往后需要替换的1的个数
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == '1') {
                arr2[i + arr2.length - arr1.length] = '1';
                n2--;
            }
            if (n2 == 0) break;
        }
        //剩余n2 - n1个1（n1是num1的置位数），从后往前填补到arr2不是0的位置上
        for (int i = arr2.length - 1; i >= 0; i--) {
            if (n2 == 0) break;
            if (arr2[i] == '0') {
                arr2[i] = '1';
                n2--;
            }
        }
        //得到相应的序列
        int res = 0,exp = 0;
        for (int i = arr2.length - 1; i >= 0; i--,exp++) {
            res += (arr2[i] - '0') * Math.pow(2,exp);
        }
        return res;
    }
}