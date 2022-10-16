import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    ArrayList<List<Integer>> resList = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,0,target);
        return resList;
    }

    private void backTrack(int[] candidates,int start,int target) {
        //小于0的时候说明该元素过大，返回到上一层
        if (target < 0) return;
        //等于0的时候就把目标结果加进去
        if (target == 0) resList.add(new ArrayList<>(curList));
        for (int i = start; i < candidates.length; i++) {
            curList.add(candidates[i]);
            backTrack(candidates,i,target - candidates[i]);
            curList.remove(curList.size() - 1);
        }
    }
}
