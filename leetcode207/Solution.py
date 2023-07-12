from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        inDeg = [0 for _ in range(numCourses)]
        for pre in prerequisites:
            g[pre[1]].append(pre[0])
            inDeg[pre[0]] += 1  # 将需要先修课的课程的入度+1
        q = deque()
        for i in range(numCourses):
            if inDeg[i] == 0:  # 添加所有入度为0的点，即不需要先修课的点
                q.append(i)
        while q:
            x = q.popleft()
            # 修完课程x，此时所有需要x作为先修课的课程y的入度-1
            for y in g[x]:
                inDeg[y] -= 1
                if inDeg[y] == 0:
                    q.append(y)

        for i in range(numCourses):
            if inDeg[i] != 0:
                return False
        return True
