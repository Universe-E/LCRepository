from collections import Counter
from typing import List


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        changed.sort()
        ans = []
        cnt = Counter()
        for x in changed:
            if x not in cnt: # x是非双倍元素
                cnt[x*2] += 1
                ans.append(x)
            else: # x是双倍后元素
                cnt[x] -= 1
                if cnt[x] == 0:
                    del cnt[x]
        # 如果cnt为空，则ans有效，否则ans无效
        return [] if cnt else ans

