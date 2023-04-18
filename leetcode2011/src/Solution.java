class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.startsWith("++") || operation.endsWith("++")) res++;
            else res--;
        }
        return res;
    }
}