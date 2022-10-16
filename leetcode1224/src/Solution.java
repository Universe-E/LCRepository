import java.util.HashMap;

class Solution {
    public int maxEqualFreq(int[] nums) {
        int count[] = new int[100005];//记录每种数字的频率
        int freq[] = new int[100005];//记录每种频率出现的次数
        int min = 1,max = 1,numOfFreq = 1,ans =1 ;//最大频率，最小频率，频率的种数，答案
        count[nums[0]]++;
        freq[1]++;
        for(int i = 1;i < nums.length;i++){
            count[nums[i]]++;
            //先处理freq数组：
            freq[count[nums[i]]]++;
            if(count[nums[i]] > 1){freq[count[nums[i]]-1]--;}
            //再处理numOfFreq：
            if(freq[count[nums[i]]]==1){numOfFreq++;}
            if(count[nums[i]]>1&&freq[count[nums[i]]-1]==0){numOfFreq--;}
            //再处理max,min：
            if(count[nums[i]]==1){min=1;}
            else if(min==count[nums[i]]-1&&freq[count[nums[i]]-1]==0){min++;}
            if(count[nums[i]]>max){max++;}
            //接下来处理ans：三种情况：
            // 1、所有数频率都是1；
            // 2、就出现过一种数字;
            // 3、有两种频率，其中一种是1且出现一次；
            // 4、两种频率，较大的出现1次，且最大最小值相邻;
            if(numOfFreq==1&&(max==1||freq[max]==1)||numOfFreq==2&&(min==1&&freq[1]==1||max-min==1&&freq[max]==1)){ans=i+1;}
        }
        return ans;
    }
}