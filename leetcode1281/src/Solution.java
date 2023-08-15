class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1,sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            mul *= c-'0';
            sum += c-'0';
        }
        return mul-sum;
    }
}