import javafx.util.Pair;

import java.util.*;

class Pair<K,V>{
    K k;
    V v;
    public Pair(K k,V v) {
        this.k = k;
        this.v = v;
    }
    public V getValue(){
        return v;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Pair<Character,Integer>[] g = new Pair[26];
        for (int i = 0; i < 26; i++) {
            g[i] = new Pair('A' + i,0);
        }
        for (char task : tasks) {
            int idx = task - 'A';
            int val = g[idx].getValue();
            g[idx] = new Pair<>(task,val+1);
        }
        //按照出现次数降序排序
        Arrays.sort(g, (o1,o2) ->(o2.getValue()-o1.getValue()));
        //分别得出最大值max，以及最大值有多少个
        int max = g[0].getValue();
        int maxCnt = 1;
        for (int i = 1; i < 26; i++) {
            if (g[i].getValue() == max) maxCnt++;
            else break;
        }
        return Math.max(tasks.length,(max-1)*(n+1) + maxCnt);
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        int maxTimes = cnt[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(cnt[i] == cnt[i - 1]) maxCount++;
            else break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}