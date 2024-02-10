import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return res;
        int[] dp = new int[n];
        int numMax = 1;
        int numMaxIndex = 0;

        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i] > numMax){
                numMax = dp[i];
                numMaxIndex = i;
            }
        }
        //处理list
        for(int i=numMaxIndex;i>=0;i--){
            if(nums[numMaxIndex]%nums[i] == 0 && dp[i]==numMax){
                res.add(nums[i]);
                numMax--;
            }
        }
        return res;
    }
}