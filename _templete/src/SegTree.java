public class SegTree {
    private int[] tree,data;
    private int n;
    public SegTree(int[] arr) {
        n = arr.length;
        tree = new int[4*n];//线段树开4倍长度的空间
        data = new int[n];
        System.arraycopy(arr,0,data,0,n);
        build(0,0,n-1);
    }

    //在root的位置创建表示区间为[l,r]的线段树
    public void build(int root,int l,int r) {
        if (l == r) {
            tree[root] = data[l];
            return;
        }
        //拿到左右子节点之后，创建左右子树
        int lr = left(root),rr = right(root);
        int m = (l+r)/2;
        build(lr,l,m);
        build(rr,m+1,r);
        //接着拿到root的值，这个值和业务逻辑相关
        tree[root] = operate(tree[lr],tree[rr]);
    }

    //返回区间[ql,qr]区间存储的值
    public int query(int ql,int qr) {
        return query(0,0,n-1,ql,qr);
    }

    //在以root为根的线段树中[l,r]范围里，搜索区间[ql,qr]的值
    private int query(int root,int l,int r,int ql,int qr) {
        if (l == ql && r == qr) return tree[root];//重合
        int m = (l+r)/2;
        int lr = left(root),rr = right(root);
        if (ql >= m+1) return query(rr,m+1,r,ql,qr);//只在右区间查找
        else if (qr <= m) return query(lr,l,m,ql,qr);//只在左区间查找
        //要在两个区间查找
        else {
            int res1 = query(lr,l,m,ql,m),res2 = query(rr,m+1,r,m+1,qr);
            return operate(res1,res2);
        }
    }


    //具体操作线段树的业务逻辑，例如求最值，求和等等
    private int operate(int a, int b) {
        return a+b;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,0,3,-5,2,-1};
        SegTree st = new SegTree(nums);
        System.out.println(st.query(2,5));
    }

}
