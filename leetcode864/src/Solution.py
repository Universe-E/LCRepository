from collections import deque
from typing import List


class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        d = [1, 0, -1, 0, 1]
        n, m, keys = len(grid), len(grid[0]), 0
        start = [0] * 4
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '@':
                    start[0], start[1] = i, j
                # 统计存在几个钥匙
                if grid[i][j].islower():
                    keys += 1

        v = [[[False] * (1 << keys) for _ in range(m)]for _ in range(n)]
        q = deque([start])
        v[0][0][0] = True
        while q:
            a = q.popleft()
            i, j, k, step = a[0], a[1], a[2], a[3]
            # 获取了所有钥匙
            if k == ((1 << keys) - 1):
                return step
            for d0 in range(4):
                i2, j2, k2 = i + d[d0], j + d[d0 + 1], k
                if 0 <= i2 < n and 0 <= j2 < m:
                    c = grid[i2][j2]
                    # 墙
                    if c == '#':
                        continue
                    # 找到钥匙，可以不修改cs[i2][j2]的状态，直接按位或即可
                    # 注意这里不能直接修改k,而是要用k2接收k，否则遍历其他位置时，造成“隔空取钥匙”导致步数缩短
                    if c.islower():
                        k2 |= (1 << (ord(c) - ord('a')))
                    # 遇到锁，没有钥匙
                    if c.isupper() and (k2 & (1 << (ord(c) - ord('A')))) == 0:
                        continue
                    # 该状态之前访问过
                    if v[i2][j2][k2]:
                        continue
                    v[i2][j2][k2] = True
                    q.append([i2, j2, k2, step + 1])

        return -1
