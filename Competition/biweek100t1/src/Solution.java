class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        if (money == 8*children) return children;
        if (money > 8*children) return children-1;
        int last = money-children;
        if (last < 7) return 0;
        int cnt = 0;
        while (last >= 7) {
            last -= 7;
            cnt++;
        }
        if (last == 3 && cnt == children-1) cnt--;
        return cnt;
    }
}