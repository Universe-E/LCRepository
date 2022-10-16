class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1,j = b.length() - 1;
        int val,next = 0;
        while (true) {
            if (i == -1 && j == -1) {
                if (next != 0) sb.append(next);
                break;
            }
            int[] temp;
            if (i == -1) {
                temp = plus(0,b.charAt(j) - '0',next);
                j--;
            }
            else if (j == -1) {
                temp = plus(a.charAt(i) - '0',0,next);
                i--;
            }
            else {
                temp = plus(a.charAt(i) - '0',b.charAt(j) - '0',next);
                i--;
                j--;
            }
            val = temp[0];
            next = temp[1];
            sb.append(val);
        }
        return sb.reverse().toString();
    }

    /**
     *
     * @param a 加数
     * @param b 加数
     * @param next 当前的进位数
     * @return 第一位表示当前数字，第二位表示下一位的进位数
     */
    private int[] plus(int a, int b, int next) {
        if (a == 0 && b == 0) {
            if (next == 0) return new int[] {0,0};
            else return new int[] {1, 0};
        }
        if (a == 1 && b == 1) {
            if (next == 0) return new int[] {0, 1};
            else return new int[] {1, 1};
        }
        else {
            if (next == 0) return new int[] {1, 0};
            else return new int[] {0, 1};
        }

    }

    public static void main(String[] args) {
        String s1 = "1010",s2 = "1011";
        String s = new Solution().addBinary(s1,s2);
        System.out.println(s);
    }
}