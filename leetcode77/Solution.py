from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        path = []
        def backTrack(n,k,start) -> None:
            if k == 0:
                res.append(path.copy())
                return
            for i in range(start,n+1):
                path.append(i)
                backTrack(n,k-1,i+1)
                path.pop()

        backTrack(n,k,1)
        return res
