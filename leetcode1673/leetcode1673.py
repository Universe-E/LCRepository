from collections import deque
from typing import List


class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        q = deque()
        # 单调栈构建最小子序列
        for i in range(n):
            # 注意不能无限取最小值，因为要保证序列长度至少为k
            # 当前元素序号为i，若nums[i]满足条件，则：
            # 设栈中已有q.size个元素，待取出1个元素，待加入（包括当前元素）有n-i个元素
            # q.size-1+n-i >= k
            while q and nums[i] < q[-1] and (len(q)-1+n-i >= k):
                q.pop()
            q.append(nums[i])
        res = [0] * k
        for i in range(k):
            res[i] = q.popleft()
        return res