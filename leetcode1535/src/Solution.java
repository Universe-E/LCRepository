/*
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：51.5 MB, 在所有 Java 提交中击败了100.00%的用户
解题思路：无论k有多大，胜利者都在arr数组中，尝试一次遍历。
遇见arr数组中的最大值之前都没有满足条件的胜利者，那么胜利者一定是这个最大值。
最多遍历一次就会遇见arr数组中的最大值，所以输掉的就不用再考虑。
*/
class Solution {
    public int getWinner(int[] arr, int k) {
        int win=arr[0],count=0;/*win:胜利者,count:获胜场次*/
        for(int i=1;i<arr.length&&count<k;i++){/*到达获胜场次跳出循环*/
            if(arr[i]<win){/*arr[i]比win小*的情况*/
                count++;
            }else{/*如果win输掉了产生新的胜利者，count置为1*/
                win=arr[i];
                count=1;
            }
        }
        return win;/*遍历一遍都没到达k,直接返回最大值*/
    }
}