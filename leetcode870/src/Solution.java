import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        //索引数组按nums2中的元素大小顺序排列
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, Comparator.comparingInt(a -> nums2[a]));
        //l和r初始时分别匹配nums2最小值所在索引和最大值所在索引，即idx[l]和idx[r]
        int[] res = new int[n];
        int l = 0,r = n - 1;
        for (int i = 0; i < n; i++) {
            //注意res是跟着nums2的索引走，例如：
            //如果nums1[i]比nums2最小值还要小，则去让nums2中的最大值去匹配当前的nums1[i]
            //否则就让当前nums2最小值匹配当前的nums1[i]
            //即每一个nums1[i]都比nums2对应值取得最微弱优势，取不到优势的就让nums2中的最大值去匹配，田忌赛马
            if (nums1[i] > nums2[idx[l]]) {
                res[idx[l]] = nums1[i];
                l++;
            }
            else {
                res[idx[r]] = nums1[i];
                r--;
            }
        }
        return res;
    }

}