import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums,visited,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums,boolean[] visited,int start,List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            //遇到相同元素，只有前面元素被之前被放进去过，后面元素才跟着放进去
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            backTrack(nums,visited,i + 1,cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}