from math import inf
from typing import List


class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n1,n2 = len(nums1),len(nums2)
        # dp[i+1][j+1]表示分别在nums1[0,i]和nums2[0,j]的范围内找到的子序列乘积的最大值
        dp = [[0] * (n2+1) for _ in range(n1+1)]
        # 索引0的位置无意义，值为负无穷
        for i in range (n1+1):
            dp[i][0] = -inf
        for j in range (n2+1):
            dp[0][j] = -inf
        for i in range(n1):
            for j in range(n2):
                # 对于每个dp[i+1][j+1]，选择是否累加当前乘积
                # 如果不选，则从上一位(dp[i][j+1])或左一位(dp[i+1][j])转移最大值
                # 如果选，则再分2中情况：
                # 1.不利用之前的状态，从零开始计算，此时值为乘积
                # 2.利用之前的状态，此时值为乘积+dp[i][j]
                mul = nums1[i] * nums2[j]
                dp[i+1][j+1] = max(dp[i+1][j],dp[i][j+1],mul+max(dp[i][j],0))
        return dp[n1][n2]