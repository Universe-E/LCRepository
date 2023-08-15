from typing import List


class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        replace = list(zip(indices, sources, targets))
        replace.sort(reverse=True)  # 按indices倒序排序
        for indice, source, target in replace:
            if s[indice:].startswith(source):
                s = s[:indice] + target + s[indice + len(source):]
        return s
