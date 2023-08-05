class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        n1,n2 = len(s1),len(s2)
        # dp[i+1][j+1]表示在s1[0,i]和s2[0,j]范围内的最大公共子序列和
        # 为避免单独讨论i,j为0的情况
        dp = [[0]*(n2+1) for _ in range(n1+1)]
        for i in range(n1):
            for j in range(n2):
                if s1[i]==s2[j]:
                    dp[i+1][j+1] = dp[i][j]+ord(s1[i])
                else:
                    dp[i+1][j+1] = max(dp[i+1][j],dp[i][j+1])
        total = sum(ord(s1[i]) for i in range(n1)) + sum(ord(s2[i]) for i in range(n2))
        return total - 2*dp[n1][n2]