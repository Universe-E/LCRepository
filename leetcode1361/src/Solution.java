import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> set = new HashSet<>();
        //using set to store every child node
        for (int i : leftChild) {
            if (i == -1) continue;
            set.add(i);
        }
        //if there are duplicate children, return false
        for (int i : rightChild) {
            if (i == -1) continue;
            if (set.contains(i)) return false;
            set.add(i);
        }
        //the amount of child must be n-1
        if (set.size() != n-1) return false;
        //the only node that not in set is root
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                root = i;
                break;
            }
        }
        //bfs from root
        boolean[] v = new boolean[n];
        var q = new ArrayDeque<Integer>();
        q.add(root);
        v[root] = true;
        while (!q.isEmpty()) {
            int p = q.pollFirst();
            int l = leftChild[p],r = rightChild[p];
            if (l != -1) {
                q.addLast(l);
                v[l] = true;
            }
            if (r != -1) {
                q.addLast(r);
                v[r] = true;
            }
        }
        for (boolean b : v) {
            if (!b) return false;
        }
        return true;
    }
}