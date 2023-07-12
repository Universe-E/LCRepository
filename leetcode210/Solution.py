from typing import List
from collections import deque


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(numCourses)]
        inDeg = [0 for _ in range(numCourses)]
        for pre in prerequisites:
            g[pre[1]].append(pre[0])
            inDeg[pre[0]] += 1  # 将需要先修课的课程的入度+1
        q = deque()
        cnt = numCourses
        res = []
        for i in range(numCourses):
            if inDeg[i] == 0:  # 添加所有入度为0的点，即不需要先修课的点
                q.append(i)
                res.append(i)
                cnt -= 1
        while q:
            x = q.popleft()
            # 修完课程x，此时所有需要x作为先修课的课程y的入度-1
            for y in g[x]:
                inDeg[y] -= 1
                if inDeg[y] == 0:
                    q.append(y)
                    res.append(y)
                    cnt -= 1
        if cnt != 0:
            return []
        return res