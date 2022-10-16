import java.util.*;

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        backTrack(visited,nums,0);
        return resList;
    }

    private void backTrack (boolean[] visited,int[] nums,int start) {
        if (curList.size() == nums.length) {
            resList.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            curList.add(nums[i]);
            backTrack(visited,nums,i + 1);
            visited[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
}