import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[1001];
        ArrayList<Integer> prime = new ArrayList<>();
        //埃氏筛法求[0,1000]范围的质数：要得到自然数n以内的全部素数，必须把不大于根号n的所有素数的倍数剔除，剩下的就是素数。
        for (int i = 2; i*i <= 1000; i++) {
            if (!flag[i]) {
                for (int j = 2*i; j <= 1000; j += i) {
                    flag[j] = true;
                }
            }
        }
        for (int i = 2; i <= 1000; i++) {
            if (!flag[i]) prime.add(i);
        }
        //接下来分解质因数，得到每个质数的出现次数
        HashMap<Integer, Integer> r = new HashMap<>();
        //a[i]记录nums[i]的质因数
        ArrayList<Integer>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
            int num = nums[i];
            for (Integer p : prime) {
                if (num % p != 0) continue;
                a[i].add(p);
                r.put(p,r.getOrDefault(p,0)+1);
                while (num%p == 0) num /= p;
            }
            //如果处理完，num不为1，说明存在比1000更大的质数，此时将其加入到map和a中
            if (num > 1) {
                r.put(num,r.getOrDefault(num,0)+1);
                a[i].add(num);
            }
        }
        //随后从0到n-2遍历，保证左右两侧的质数不能有交集
        HashMap<Integer,Integer> l = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (Integer p : a[i]) {
                l.put(p,l.getOrDefault(p,0)+1);
                r.put(p,r.get(p)-1);
                if (r.get(p)==0) r.remove(p);
            }
            boolean valid = true;
            for (Integer lk : l.keySet()) {
                if (r.containsKey(lk)) {
                    valid = false;
                    break;
                }
            }
            if (valid) return i;
        }
        return -1;
    }
}