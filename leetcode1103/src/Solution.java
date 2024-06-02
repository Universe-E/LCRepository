class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0,cur = 1;
        while (candies > 0) {
            int cost = Math.min(candies,cur);
            res[i] += cost;
            candies -= cost;
            cur++;
            i = (i+1) % num_people;
        }
        return res;
    }
}