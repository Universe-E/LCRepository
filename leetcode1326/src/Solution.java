import java.util.Arrays;
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] arr = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            arr[i] = new int[] {Math.max(0,i-ranges[i]),Math.min(n,i+ranges[i])};
        }
        //如果起始点相等，按终点倒序排序
        Arrays.sort(arr,(o1,o2) -> (o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0]));
        int rBound = arr[0][1];
        int idx = 0,count = 1;
        while (rBound < n) {
            //far是已覆盖区域的喷泉能喷到的最右侧，初始默认为rBound
            int far = rBound;
            //在已覆盖的区域中找到最右边的一个
            for (int i = idx; i <= n; i++) {
                if (arr[i][0] <= rBound) {
                    idx++;
                    far = Math.max(far,arr[i][1]);
                }
                else break;
            }
            //如果已覆盖区域的最右侧得不到更新，则下一轮不可能再与rBound交集
            // 即下一轮arr[i][0]>rBound恒成立
            if (rBound >= far) return -1;
            rBound = far;
            count++;
        }
        return count;
    }
}