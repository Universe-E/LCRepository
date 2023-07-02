class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return k <= numOnes ? k : k <= (numOnes+numZeros) ? numOnes : (2*numOnes+numZeros-k);
    }
}