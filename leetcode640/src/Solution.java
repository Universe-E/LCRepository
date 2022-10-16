class Solution {
    public String solveEquation(String equation) {
        int factor = 0, constant = 0;
        int index = 0, n = equation.length(), sign1 = 1; // 等式左边默认系数为正
        while (index < n) {
            //用sign1控制正负，不必分等号左右两种情况讨论
            if (equation.charAt(index) == '=') {
                sign1 = -1; // 等式右边默认系数为负
                index++;
                continue;
            }

            //正负号只用于控制正负，不必用正负号作为每一项的断点分类讨论
            int sign2 = sign1, number = 0;
            boolean valid = false; // 记录 number 是否有效
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // 去掉前面的符号
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }

            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }

            //没有系数的时候默认为1
            if (index < n && equation.charAt(index) == 'x') { // 变量
                factor += valid ? sign2 * number : sign2;
                index++;
            } else { // 数值
                constant += sign2 * number;
            }
        }

        if (factor == 0) {
            return constant == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-constant / factor);
    }
}