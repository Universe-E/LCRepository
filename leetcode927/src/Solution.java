class Solution {
    //由于三等分，必有：
    //1、arr中1的数量必须是3的倍数，
    //2、不考虑前导0和后补0，每一部分从首位1到末位1的部分必定相同
    //3、如果有后补0，则后补0的数量必定一致
    StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder(),sb3 = new StringBuilder();
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length,count1 = 0;
        for (int num : arr) if (num == 1) count1++;
        if (count1 == 0) return new int[] {0, n - 1};
        if (count1 % 3 != 0) return new int[] {-1,-1};
        //接下来partition，先从arr[0]开始数(count1 / 3)个1，找到最后一个1的下标，分别记为p1,p2,p3
        int diff = count1 / 3;

        //先从0开始找
        int[] res1 = partition(arr,0,diff,1);
        int p1 = res1[1];
        //接下来从p1+1开始找
        int[] res2 = partition(arr,p1 + 1,diff,2);
        int secondPre0 = res2[0],p2 = res2[1];
        //这里判断sb1和sb2是否匹配
        if (!sb1.toString().equals(sb2.toString())) return new int[] {-1,-1};
        //最后从p2+1开始找
        int[] res3 = partition(arr,p2 + 1,diff,3);
        int thirdPre0 = res3[0],p3 = res3[1];
        if (!sb1.toString().equals(sb3.toString())) return new int[] {-1, -1};
        //后补0的个数由p3和n决定
        int post0 = n - 1 - p3;
        //第2部分和第3部分的前导0（同时也是第1部分和第2部分的后补0）必须满足：
        //secondPre0 >= post0 && thirdPre0 >= post0，否则说明前两部分后补0数量不够
        if (secondPre0 < post0 || thirdPre0 < post0) return new int[] {-1, -1};
        //如果满足条件，将p1和p2向后移动post0距离即可
        return new int[] {p1 + post0,p2 + post0 + 1};
    }

    //遍历三等分的每一部分，返回前导0个数和最后一个1所在下标
    private int[] partition(int[] arr,int start, int diff,int flag) {
        int pre0 = 0,cur1 = 0,p = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == 1) {
                cur1++;
                if (flag == 1) sb1.append(arr[i]);
                else if (flag == 2) sb2.append(arr[i]);
                else if (flag == 3) sb3.append(arr[i]);
                if (cur1 == diff) {
                    p = i;
                    break;
                }
            }
            if (arr[i] == 0) {
                //先找出前导0的数量
                if (cur1 == 0) pre0++;
                //如果不是前导0，则添加到sb中
                else {
                    if (flag == 1) sb1.append(arr[i]);
                    else if (flag == 2) sb2.append(arr[i]);
                    else if (flag == 3) sb3.append(arr[i]);
                }
            }
        }
        return new int[] {pre0,p};
    }
}