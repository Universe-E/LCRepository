import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0);
        return resList;
    }

    private void backTrack(int[] nums,int start) {
        //不需要等到将nums全部遍历结束，只要满足curList.size() > 1即可
        if (curList.size() > 1) {
            resList.add(new ArrayList<>(curList));
        }
        //例如[4,6,7（1）,7（2）]，当回溯到第3层时，有两种情况：添加第1个7或添加第2个7。
        //由于第1个7添加后，回溯进入了下一层（第4层），该层又new了一个HashSet，因此在该层不影响第2个7的加入（即[4,6,7,7]也是合理解）
        //但当回溯重新回到第3层时，由于该层的HashSet中已包含元素7，故第2个7加不进去
        //这样就实现了[4,6,7（1）]和[4,6,7（2）]的去重
        HashSet<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (curList.isEmpty() || nums[i] >= curList.get(curList.size() - 1)) {
                curList.add(nums[i]);
                visited.add(nums[i]);
                backTrack(nums,i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }
}