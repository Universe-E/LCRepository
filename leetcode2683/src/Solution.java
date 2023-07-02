class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int all = 0;
        for (int num : derived) {
            all ^= num;
        }
        return all == 0;
    }
}