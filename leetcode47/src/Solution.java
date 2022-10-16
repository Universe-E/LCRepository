import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] visited = new boolean[n];
        backTrack(nums,n,visited,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums,int n,boolean[] visited, List<Integer> cur) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            backTrack(nums,n,visited,cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}