from typing import List


class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False for _ in range(n+1)] # dp[i+1]表示[0,i]是否可以被成功划分
        dp[0] = True
        for i in range(1,n):
            if nums[i] == nums[i-1] and dp[i-1]:
                dp[i+1] = True
            if i > 1:
                if nums[i] == nums[i-1] == nums[i-2] and dp[i-2]:
                    dp[i+1] = True
                if nums[i] == nums[i-1]+1 == nums[i-2]+2 and dp[i-2]:
                    dp[i+1] = True
        return dp[n]
