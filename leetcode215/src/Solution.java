import java.util.Random;

class Solution {
    Random rnd = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums,0,n-1,n-k);
    }


    private int quickSelect(int[] nums, int l, int r, int id) {
        int p = partition(nums,l,r);
        if (p == id) return nums[p];
        return p < id ? quickSelect(nums,p+1,r,id) : quickSelect(nums,l,p-1,id);
    }

    private int partition(int[] nums, int l, int r) {
        int i = l+rnd.nextInt(r-l+1);//random select in [l,r]
        swap(nums,i,r);
        int x = nums[r],cur = l;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) swap(nums,cur++,j);
        }
        swap(nums,cur,r);
        return cur;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}