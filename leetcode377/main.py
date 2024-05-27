from functools import cache
from typing import List


class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(i: int) -> int:
            if i == 0: return 1  # 递归到底
            return sum(dfs(i-x) for x in nums if x <= i)
        return dfs(target)