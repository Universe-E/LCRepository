import java.util.HashMap;

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        //先把id和座位序号放到HashMap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(row[i],i);
        //从0开始，按步长为2遍历数组，如果i的右侧不是自己的情侣，则让他和自己的情侣换位，随后从i+=2
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            //如果是偶数，找比它大1的奇数，果是奇数，找比它小1的偶数
            int pos = row[i] % 2 == 0 ? map.get(row[i] + 1) : map.get(row[i] - 1);
            if (pos == i+1) continue;
            //互换位置，注意要先更新一下HashMap，row[i]±1无需更新，因为已经被放到row[i+1]处，下一轮被略过
            map.put(row[i+1],pos);
            row[pos] = row[i+1];
            row[i+1] = row[i] + row[i] % 2 == 0 ? 1 : -1;
            res++;
        }
        return res;
    }
}