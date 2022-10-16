import java.util.*;

class Solution {
    int mod=(int)1e9+7;
    public int rectangleArea(int[][] rectangles) {
        int[] map1 =compress(rectangles,0,2);
        int[] map2 =compress(rectangles,1,3);
        long ans = 0;
        for(int i=0;i<map1.length-1;i++){
            int[] count =new int[map2.length+5];
            for (int[] rectangle : rectangles) {
                if (i >= rectangle[0] && i < rectangle[2]) {
                    count[rectangle[1]]++;
                    count[rectangle[3]]--;
                }
            }
            long d = map1[i+1] - map1[i];
            if(count[0] > 0) ans += d * (map2[1] - map2[0]);
            for(int j=1;j<map2.length;j++){
                count[j] += count[j-1];
                if(count[j] > 0) ans += d * (map2[j+1] - map2[j]);
            }
        }
        return (int)(ans % mod);
    }
    int[] compress(int[][] r, int idx1, int idx2){
        TreeSet<Integer> set=new TreeSet<>();
        for (int[] ints : r) {
            set.add(ints[idx1]);
            set.add(ints[idx2]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans =new int[set.size()];
        int p=0;
        for(int a:set){
            ans[p]=a;
            map.put(a,p);
            p++;
        }
        for(int i=0;i<r.length;i++){
            r[i][idx1]=map.get(r[i][idx1]);
            r[i][idx2]=map.get(r[i][idx2]);
        }
        return ans;
    }
}
