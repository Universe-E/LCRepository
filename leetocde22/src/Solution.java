import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        recursiveGenerate(resList,0,0,n,"");
        return resList;
    }

    private void recursiveGenerate(List<String> resList, int left, int right, int n, String s) {

        if (left == n && right == n) {
            resList.add(s);
            return;
        }
        if (left < n) {
            recursiveGenerate(resList,left + 1, right, n, s + "(");
        }
        if (right < n && right < left) {
            recursiveGenerate(resList, left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(4);
        for (String s : list) {
            System.out.print(s + "\t");
        }
    }
}
