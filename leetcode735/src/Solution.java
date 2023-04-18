import java.util.ArrayDeque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            //声明当前行星是否被撞毁
            boolean col = false;
            //只有添加向左运动的行星，才可能与已有行星发生碰撞
            if (ast < 0) {
                //单调栈判断碰撞条件，当且仅当栈顶有向右移动的行星时，才会发生碰撞（出栈）
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int t = stack.peek();
                    //如果栈顶绝对值小于当前绝对值，则栈顶行星被撞毁（出栈），当前行星继续向左运动
                    if (t < -ast) stack.pop();
                    //否则当前行星被撞毁
                    else {
                        //如果绝对值相等，则栈顶行星也被撞毁（出栈）
                        if (t == -ast) stack.pop();
                        col = true;
                        break;
                    }
                }
                //如果没有被撞毁，则添加到栈中
                if (!col) stack.push(ast);
            }
            //添加向右运动的行星不会与已有行星发生碰撞
            else stack.push(ast);
        }
        int sz = stack.size();
        int[] res = new int[sz];
        //注意数组的添加顺序和出栈顺序相反
        for (int i = 0; i < sz; i++) {
            res[sz-i-1] = stack.pop();
        }
        return res;
    }
}