import java.util.TreeSet;

class ExamRoom {
    TreeSet<Integer> set;
    int n;
    public ExamRoom(int n) {
        set = new TreeSet<>();
        this.n = n;
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        //max记录最大的距离，l和r分别记录最大距离时的左右边界
        int max = 0, pre = -1,l = -1, r = 0;
        for (Integer idx : set) {
            if (pre == -1) {
                r = idx;
                max = r - l;
            }
            //对于中间的判断，要除以2进行比较，例如0 4 9，距离分别为4和5，但应该插入2而不是6
            else if ((idx - pre) / 2 > max / 2) {
                r = idx;
                l = pre;
                max = r - l;
            }
            pre = idx;
        }
        //遍历完之后，最后再判断n和set最后一个元素的距离是否最大
        if (n - set.last() > max) {
            set.add(n-1);
            return n-1;
        }
        if (l == - 1) {
            set.add(0);
            return 0;
        }
        //一般情况，添加在最大距离之间
        set.add((l + r) / 2);
        return (l + r) / 2;
    }

    public void leave(int p) {
        set.remove(p);
    }
}