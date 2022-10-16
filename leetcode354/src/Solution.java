import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //注意，排序逻辑是所有的信封按照第一关键字升序、第二关键字降序进行排序
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        List<Integer> res = new ArrayList<>();
        res.add(envelopes[0][1]);
        int m = envelopes.length;
        for (int i = 1; i < m; i++) {
            int num = envelopes[i][1];
            if (num > res.get(res.size() - 1)) res.add(num);
            else {
                //找到比当前值小的最近元素的索引，并更新这个索引
                //这样的话，对于第一关键字相同的信封，res.get(i)不断更新变小
                //直到第一关键字更新且第二关键字大于最后的res.get(i)时，将其添加进去
                int index = binarySearch(res,num);
                res.set(index,num);
            }
        }
        return res.size();
    }

    private int binarySearch(List<Integer> res, int num) {
        int l = 0,r = res.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (res.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
