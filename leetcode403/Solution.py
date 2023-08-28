from typing import List


class Solution:
    def canCross(self, stones: List[int]) -> bool:
        n = len(stones)
        dp = [[False for _ in range(n + 1)] for _ in range(n)]
        if stones[1] != 1:
            return False
        dp[0][0] = dp[1][1] = True
        for i in range(2, n):
            for j in range(i - 1, -1, -1):
                diff = stones[i] - stones[j]
                if diff >= n:
                    break
                if dp[j][diff - 1] or dp[j][diff] or dp[j][diff + 1]:
                    dp[i][diff] = True

        for j in range(n):
            if dp[n-1][j]:
                return True
        return False
