class Solution {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[65536];
        for (int i : nums) {
            for (int j : nums) {
                cnt[i&j]++;
            }
        }
        int sum = 0;
        //如果k AND 某个数结果为0，则k的所有“子集”AND该数结果也为0，这样实现了状态压缩
        //如果把二进制数看成集合的话，二进制从低到高第 i 位为 1 表示 i 在集合中，为 0 表示 i 不在集合中，
        //例如 a=1101(2)表示集合 A={0,2,3}。
        for (int k : nums) {
            k ^= 0xffff;//取补集
            int s = k;
            do {
                sum += cnt[s];
                s = (s-1)&k;//枚举s的二进制子集
            } while (s != k);
        }
        return sum;
    }
}