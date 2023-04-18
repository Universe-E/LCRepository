import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        //按从小到大排序
        Arrays.sort(satisfaction);
        //sum记录菜品“满意度”总和，cur记录当前的“喜爱时间总和“
        int sum = 0,res = 0,cur = 0;
        for (int i = 0; i < n; i++) {
            sum += satisfaction[i];
            cur += (i+1)*satisfaction[i];
        }
        res = Math.max(res,cur);
        //从0开始逐个去掉比较，只需去掉喜爱程度为负的结果即可
        for (int i = 0; i < n && satisfaction[i] < 0; i++) {
            cur -= sum;//去掉satisfaction[i]后，后面的菜品烹饪时间依次减1，总体相当于减去了sum
            sum -= satisfaction[i];//每次更新sum
            res = Math.max(res, cur);
        }
        return res;
    }
}