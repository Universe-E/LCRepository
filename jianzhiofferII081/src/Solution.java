import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,new ArrayList<>(),0,target);
        return res;
    }

    private void backTrack(int[] candidates,List<Integer> list,int p,int cur) {
        if (cur == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = p; i < candidates.length; i++) {
            if (cur - candidates[i] < 0) return;
            list.add(candidates[i]);
            cur -= candidates[i];
            backTrack(candidates,list,i,cur);
            list.remove(list.size() - 1);
            cur += candidates[i];
        }
    }
}