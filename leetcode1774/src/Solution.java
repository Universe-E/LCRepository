class Solution {
    int t;
    int res = 20003;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        t = target;
        for (int baseCost : baseCosts) {
            dfs(baseCost, 0, toppingCosts);
        }
        return res;
    }

    private void dfs(int curPrice, int idx, int[] toppingCosts) {
        int cur = Math.abs(res-t);
        int before = Math.abs(curPrice-t);
        //find the nearest res and renew the value
        if (cur>before || (cur==before && curPrice<res)) res = curPrice;
        //finish the backtrack
        if (curPrice >= t || idx >= toppingCosts.length) return;

        //3 circumstances: add 0,1,2 toppings respectively
        for (int i = 0; i < 3; i++) {
            dfs(curPrice + i * toppingCosts[idx],idx + 1,toppingCosts);
        }
    }

}