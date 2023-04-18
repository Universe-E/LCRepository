import java.util.ArrayDeque;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            //找到arr[i]能够作为最小值的数组左右边界l和r，相应的子数组数量等于(i - l) * (r - i)
            int l = i - 1,r = i + 1;
            while (l >= 0 && arr[i] < arr[l]) l--;
            while (r < n && arr[i] <= arr[r]) r++;
            res += (long) (i - l) * (r - i) * arr[i];
        }
        return (int) (res % 1000000007);
    }
}

class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        int M = (int) (1e9+7);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i <= n; i++) {
            //right bound is n
            int cur = i < n ? arr[i] : -1;
            while (stack.size() > 1 && arr[stack.peek()] >= cur) {
                int p = stack.pop();
                //p's right bound is i,left bound is the next top element of stack
                //calculating res
                res += (long) arr[p] * (i-p) * (p-stack.peek());
            }
            stack.push(i);
        }
        return (int)(res % M);
    }
}

class Solution3 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        int M = (int) (1e9+7);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //left[i] and right[i] refer to the bound of i
        int[] left = new int[n],right = new int[n];
        //constructing monotonic stack
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (int i = n-1; i >= 0; i--) {
            //here is exclusive greater than,or will lead to repeated calculation
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
            res += (long)arr[i] * (i-left[i]) * (right[i]-i);
        }
        return (int)(res % M);
    }
}