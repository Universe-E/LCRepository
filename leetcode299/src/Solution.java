import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public String getHint(String secret, String guess) {
        List<Integer> secretWithoutBulls = new ArrayList<>();
        List<Integer> guessWithoutBulls = new ArrayList<>();
        int bulls = 0,cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                secretWithoutBulls.add(secret.charAt(i) - '0');
                guessWithoutBulls.add(guess.charAt(i) - '0');
            }
        }
        //下面开始暴力匹配
        Collections.sort(secretWithoutBulls);
        Collections.sort(guessWithoutBulls);
        int i = 0,j = 0;
        while (j < guessWithoutBulls.size() && i < secretWithoutBulls.size()){
            if (secretWithoutBulls.get(i).equals(guessWithoutBulls.get(j))){
                cows++;
                i++;
                j++;
            }
            else if (secretWithoutBulls.get(i) < guessWithoutBulls.get(j)) i++;
            else j++;
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("11123","11123"));
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] sc = new int[10],gc = new int[10];
        int a = 0,b = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) a++;
            else {
                sc[secret.charAt(i)-'0']++;
                gc[guess.charAt(i)-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(sc[i],gc[i]);
        }
        return a+"A"+b+"B";
    }
}
