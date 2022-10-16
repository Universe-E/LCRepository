import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int candy(int[] ratings) {
        //用于存储每个孩子的糖果数
        int[] candy = new int[ratings.length];

        //首先将所有该置为1的地方置为1
        for (int i = 1; i < ratings.length; i++) {
            //两种边界情况，分别对应ratings[0]和ratings[ratings.length - 1]
            if (i == 1 && ratings[i - 1] <= ratings[i]) candy[i - 1] = 1;
            else if (i == ratings.length - 1 && ratings[i - 1] >= ratings[i]) candy[i] = 1;
            //对于中间的ratings，如果同时小于等于两边，则等于1
            else if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) candy[i] = 1;
        }


        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
        List<Integer> list = Arrays.stream(candy).boxed().collect(Collectors.toList());
        //只要list包含0，就一直调用
        while (list.contains(0)) {
            //接下来是不等于1的情况
            for (int i = 0; i < ratings.length; i++) {
                if (candy[i] == 1) continue;
                //首先如果ratings[1] != 0，则考虑左边界情况
                if (i == 1 && ratings[i - 1] > ratings[i] && candy[i] != 0) candy[i - 1] = candy[i] + 1;
                //右边界同理
                else if (i == ratings.length - 1 && ratings[i] > ratings[i - 1] && candy[i - 1] != 0) candy[i] = candy[i - 1] + 1;
                else if (ratings[i] > ratings[i + 1] && ratings[i] > ratings[i - 1]
                        && candy[i - 1] != 0 && candy[i + 1] != 0) candy[i] = Math.max(candy[i - 1],candy[i + 1]) + 1;
                //这里对应一边大于一边不大于的情况
                else if (candy[i - 1] != 0 && candy[i + 1] != 0) candy[i] = Math.min(candy[i - 1], candy[i + 1]) + 1;
            }
            //每次更新list
            list = Arrays.stream(candy).boxed().collect(Collectors.toList());
        }
        return Arrays.stream(candy).sum();

    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        int res = new Solution().candy(ratings);
        System.out.println(res);
    }
}
