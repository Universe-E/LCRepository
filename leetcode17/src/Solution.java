import java.util.*;

class Solution {
    String S2 = "abc";
    String S3 = "def";
    String S4 = "ghi";
    String S5 = "jkl";
    String S6 = "mno";
    String S7 = "pqrs";
    String S8 = "tuv";
    String S9 = "wxyz";
    String[] Strings = new String[] {S2,S3,S4,S5,S6,S7,S8,S9};
    List<String> list = new ArrayList<>();
    ArrayDeque<String> aq = new ArrayDeque<>();//设置队列用于存放元素
    public List<String> letterCombinations(String digits) {
        int i = 0;
        while (i < digits.length()) {
            String thisString = Strings[digits.charAt(i) - '2'];
            if (i == 0) {//如果i = 0，直接添加元素
                for (int j = 0; j < thisString.length(); j++) aq.add(String.valueOf(thisString.charAt(j)));
            }
            else {//i != 0的情况下：从队首取出元素，逐次添加字母后添加到队尾
                int size = aq.size();
                for (int j = 0; j < size; j++) {
                    String s = aq.pop();
                    for (int k = 0; k < thisString.length(); k++) aq.add(s + thisString.charAt(k));
                }
            }
            i++;
        }
        int size = aq.size();
        for (int j = 0; j < size; j++) {
            list.add(aq.pop());
        }
        return list;
    }
}
