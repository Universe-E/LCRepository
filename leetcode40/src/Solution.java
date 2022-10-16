import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,0,target);
        return resList;
    }

    private void backTrack(int[] candidates,int start,int target) {
        if (target < 0) return;
        if (target == 0) resList.add(new ArrayList<>(curList));
        for (int i = start; i < candidates.length; i++) {
            //对这行条件判断可以这样理解：
            //candidates = [1,1,2,5,6,7,10]，target = 8，数组可标记为[1(1),1(2),2,5,6,7,10]
            //如果不去重，会出现[1(1),2,5]和[1(2),2,5]两个重复结果
            if (i > start && candidates[i] == candidates[i-1]) continue;
            curList.add(candidates[i]);
            backTrack(candidates,i + 1,target - candidates[i]);
            curList.remove(curList.size() - 1);
        }
    }
}
