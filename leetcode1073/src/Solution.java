import java.util.ArrayDeque;

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n1 = arr1.length,n2 = arr2.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //按照-2进制相加的思路，每一位有-1,0,1,2,3五种情况
        for (int i = n1-1,j = n2-1,add = 0;i >= 0 || j >= 0 || add != 0;i--,j--) {
            int cur = (i>=0 ? arr1[i] : 0) + (j>=0 ? arr2[j] : 0) + add;
            if (cur == 0 || cur == 1) {//不进位
                add = 0;
                q.addFirst(cur);
            }
            else if (cur == 2) {//进位-1，当前位为0
                add = -1;
                q.addFirst(0);
            }
            else if (cur == -1) {//从前一位借1，等价于进位1，当前位为1
                add = 1;
                q.addFirst(1);
            }
            else if (cur == 3) {//进位-1，当前位为1
                add = -1;
                q.addFirst(1);
            }
        }
        //如果不是[0]的情况，则去掉前导零
        while (q.size() > 1 && q.peek() == 0) q.pollFirst();
        int sz = q.size();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = q.pollFirst();
        }
        return res;
    }
}