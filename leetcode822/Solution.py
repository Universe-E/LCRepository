from typing import List


class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        n = len(fronts)
        s = set()
        for i in range(n):
            if fronts[i] == backs[i]:
                s.add(fronts[i])
        res = 2001
        for x in fronts+backs:
            if x not in s:
                res = min(res,x)
        return res if res != 2001 else 0