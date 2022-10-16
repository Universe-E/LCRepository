/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int res;
        do {
            res = (rand7() - 1) * 7 + rand7();//构建0-49的均匀随机数
        } while (res < 40);
        //res=40-49时跳出
        return res % 10 + 1;
    }
}