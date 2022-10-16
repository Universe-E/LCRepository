class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //nums3数组：[a1^b1,a1^b2,a1^b3, ... a1^bn2 ... an1^b1,an1^b2 ... an1^bn2]
        //问题转化为所有元素的异或结果，其中nums1中每个数被异或了n2次，nums2中的每个数被异或了n1次
        int cur1 = 0,cur2 = 0;
        //异或运算性质：a ^ a = 0, 0 ^ a = a，因此同一个数字a异或自身偶数次结果为0，奇数次结果为a
        if (n2 % 2 != 0) {
            for (int num : nums1) {
                cur1 ^= num;
            }
        }
        if (n1 % 2 != 0) {
            for (int num : nums2) {
                cur2 ^= num;
            }
        }
        return cur1 ^ cur2;
    }
}