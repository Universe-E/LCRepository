import java.util.*;

class LockingTree {
    ArrayList<Integer>[] g;
    int n;
    int[] parent;
    HashMap<Integer,Integer> map;
    public LockingTree(int[] parent) {
        n = parent.length;
        this.parent = parent;
        g = new ArrayList[n];
        map = new HashMap<>();
        Arrays.setAll(g,e->new ArrayList<>());
        for (int i = 1; i < n; i++) {
            //add children
            g[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        //num is unlocked
        if (!map.containsKey(num)) {
            map.put(num,user);
            return true;
        }
        else return false;
    }

    public boolean unlock(int num, int user) {
        //num is locked
        if (map.getOrDefault(num,-1) == user) {
            map.remove(num);
            return true;
        }
        else return false;
    }

    public boolean upgrade(int num, int user) {
        //1. node is unlocked
        if (map.containsKey(num)) return false;
        //2. does not have any locked ancestors
        int fa = parent[num];
        while (fa != -1) {
            if (map.containsKey(fa)) return false;
            fa = parent[fa];
        }
        //3. has at least one locked descendant
        ArrayList<Integer> locked = bfs(num);
        if (locked.isEmpty()) return false;
        map.put(num,user);
        for (Integer y : locked) {
            map.remove(y);
        }
        return true;
    }

    private ArrayList<Integer> bfs(int num) {
        var q = new ArrayDeque<Integer>();
        for (Integer x : g[num]) {
            q.addLast(x);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            if (map.containsKey(x)) res.add(x);
            for (Integer y : g[x]) {
                q.addLast(y);
            }
        }
        return res;
    }
}