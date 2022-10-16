import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class Solution {

    int[] nums;
    HashSet<Integer> set;//set用于记录所有nums索引
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        set = new HashSet<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) set.add(i);
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        //复制索引到list中
        ArrayList<Integer> list = new ArrayList<>(set);
        int n = nums.length,count = 0;
        int[] res = new int[n];
        while (!list.isEmpty()) {
            //随机找一个索引
            int p = random.nextInt(list.size());
            res[count++] = nums[list.remove(p)];
        }
        return res;
    }
}
