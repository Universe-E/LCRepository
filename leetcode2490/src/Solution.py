class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        s = sentence.split(" ")
        return all(s[i][-1] == s[(i+1)%len(s)][0] for i in range(len(s)))