from typing import List


class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        n,M = len(nums),int(1e9+7)
        nums.sort()
        minSum = nums[0]
        cur = nums[0]**2*minSum%M
        for i in range(1,n):
            minSum = (minSum*2-nums[i-1]+nums[i])%M
            cur = (cur+nums[i]**2*minSum)%M
        return cur