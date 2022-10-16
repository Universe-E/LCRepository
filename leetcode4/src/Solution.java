import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        int[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr,0,arr.length - 1,temp);
        if (arr.length % 2 == 0) return  (arr[arr.length / 2] + arr[(arr.length - 1) / 2]) / 2.0;
        else return arr[arr.length / 2];
    }

    private void mergeSort(int[] arr,int l,int r,int[] temp){
        if (l >= r) return;

        //声明中间值
        int mid = l + (r - l) / 2;
        //分别递归对arr[l,mid]和arr[mid + 1,r]归并排序
        mergeSort(arr,l,mid,temp);
        mergeSort(arr,mid + 1,r,temp);
        //接下来对做归并操作，其中arr[l,mid]和arr[mid + 1,r]都已经排好序
        if (arr[mid] > arr[mid + 1]) merge(arr,l,mid,r,temp);
    }

    private void merge(int[] arr,int l,int mid,int r,int[] temp){
        System.arraycopy(arr, l, temp, l, r - l + 1);
        //下面开始归并操作
        int i = l,j = mid + 1;
        //arr[k]是arr[i]和arr[j]中的较小值
        for (int k = l; k < r + 1; k++) {
            //如果i > mid，说明[l,mid]数组已被遍历完毕，此时只需放入temp[j]即可
            if (i > mid){
                arr[k] = temp[j];
                j++;
            }
            //如果j > r，说明[mid + 1,r]数组已被遍历完毕，此时只需放入temp[i]即可
            else if (j > r){
                arr[k] = temp[i];
                i++;
            }
            //如果两个数组都没有遍历完，则比较temp[i]和temp[j]的大小，较小者赋值给arr[k]
            else if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            }
            else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {9,5,7,3,1,11,13,15,17,19};
        int[] num2 = {10,6,8,4,2,12,14,16,18};
        System.out.println(new Solution().findMedianSortedArrays(num1,num2));
    }
}
