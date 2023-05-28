import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Integer[] bs = new Integer[n];
        for (int i = 0; i < n; i++) {
            bs[i] = barcodes[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b : bs) {
            map.put(b,map.getOrDefault(b,0)+1);
        }
        Arrays.sort(bs,(o1,o2) -> map.get(o1).equals(map.get(o2)) ? (o1-o2) : (map.get(o2)-map.get(o1)));
        int[] res = new int[n];
        int l = 0,r = (n-1)/2 + 1;//r向上取整
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) res[i] = bs[l++];
            else res[i] = bs[r++];
        }
        return res;
    }
}