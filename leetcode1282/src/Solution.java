import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    List<Integer> indexList = new ArrayList<>();//indexList用于去重
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        for (int i = 0; i < groupSizes.length; i++) {
            if (!indexList.contains(i)) {//如果该元素没有被添加过，则添加进去
                curList.add(i);
                indexList.add(i);
            }
            for (int j = i + 1; j < groupSizes.length; j++) {
                //对于curList，添加条件为：
                //1、curList未满
                //2、当前元素和groupSizes[i]相等才能分到同一组
                //3、该元素未被添加过
                if (curList.size() < groupSizes[i] && groupSizes[j] == groupSizes[i] && !indexList.contains(j)) {
                    curList.add(j);
                    indexList.add(j);
                }
            }
            //完成一轮操作后，将curList添加到resList中
            if (!curList.isEmpty()) {
                resList.add(new ArrayList<>(curList));
                curList.clear();
            }
        }
        return resList;
    }
}
