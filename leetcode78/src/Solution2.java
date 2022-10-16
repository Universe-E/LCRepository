import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums,int start,List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backTrack(nums, i + 1,cur);
            cur.remove(cur.size() - 1);
        }
    }
}
