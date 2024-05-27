from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        prm = 0
        # 由于是闭合岛，且没有湖，只需要找北面+西面的即可，结果*2
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    if j == 0 or grid[i][j-1] == 0:
                        prm += 1
                    if i == 0 or grid[i-1][j] == 0:
                        prm += 1
        return prm * 2