
// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);
    public int length();

}


class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0,r = n-1;
        int top = findTop(l,r,n,mountainArr);
        if (mountainArr.get(top) == target) return top;
        //find left
        int lt = bs(l,top,target,mountainArr,true);
        if (lt != -1) return lt;
        return bs(top,r,target,mountainArr,false);
    }

    //find top index
    private int findTop(int l, int r,int n,MountainArray mountainArr) {
        while (l < r) {
            int mid = l + (r-l) / 2;
            int mr = mountainArr.get(mid);
            int lr = mid == 0 ? -1 : mountainArr.get(mid-1);
            int rr = mid == n-1 ? -1 : mountainArr.get(mid+1);
            if (mr > lr && mr > rr) return mid;
            else if (mr < lr && mr > rr) r = mid-1;
            else if (mr > lr && mr < rr) l = mid+1;
        }
        return l;
    }


    private int bs(int l,int r,int t,MountainArray mountainArr,boolean isLeft) {
        while (l <= r) {
            int mid = l + (r-l) / 2;
            int mr = mountainArr.get(mid);
            if (mr == t) return mid;
            else if (mr < t) {
                if (isLeft) l = mid+1;
                else r = mid-1;
            }
            else {
                if (isLeft) r = mid-1;
                else l = mid+1;
            }
        }
        return -1;
    }
}