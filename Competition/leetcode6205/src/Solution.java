import java.util.HashSet;

class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            StringBuilder sb = new StringBuilder();
            String str = String.valueOf(num);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
            set.add(Integer.parseInt(sb.reverse().toString()));
        }
        return set.size();
    }
}