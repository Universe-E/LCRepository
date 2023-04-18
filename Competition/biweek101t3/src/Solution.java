import java.util.ArrayList;
import java.util.Collections;

class Solution {
    //结论：一个循环数组如果既有周期n，又有周期k，则必然有周期gcd(n,k)
    //每一个周期，对应的元素都要相等，此时中位数贪心，操作数最少
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int r = gcd(n,k);//周期
        long res = 0;
        for (int i = 0; i < r; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            //按周期将不同组的元素添加到一个list中
            for (int j = i; j < n; j+=r) {
                list.add(arr[j]);
            }
            Collections.sort(list);
            //list的中位数
            int mid = list.get(list.size()/2);
            for (Integer member : list) {
                res += Math.abs(member-mid);
            }
        }
        return res;
    }

    private int gcd(int a,int b) {
        if (b == 0) return a;
        return gcd(b,a%b);
    }
}