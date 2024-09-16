import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i],-1);
        }
        int i = 0, j = 0, d = 0;
        boolean[][] v = new boolean[m][n];
        while (head != null) {
            res[i][j] = head.val;
            v[i][j] = true;
            if (d == 0) {
                if (j == n-1 || v[i][j+1]) {
                    d = 1;
                    i++;
                }
                else j++;

            }
            else if (d == 1) {
                if (i == m-1 || v[i+1][j]) {
                    d = 2;
                    j--;
                }
                else i++;
            }
            else if (d == 2) {
                if (j == 0 || v[i][j-1]) {
                    d = 3;
                    i--;
                }
                else j--;
            }
            else {
                if (i == 0 || v[i-1][j]) {
                    d = 0;
                    j++;
                }
                else i--;
            }
            head = head.next;
        }
        return res;
    }
}