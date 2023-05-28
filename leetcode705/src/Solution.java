import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class MyHashSet {

    ArrayList<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!contains(key)) list.add(key);
    }

    public void remove(int key) {
        int ptr = binarySearch(key);
        if (ptr != -1) list.remove(ptr);
    }

    public boolean contains(int key) {
        return binarySearch(key) != -1;
    }

    private int binarySearch(int key) {
        if (list.size() == 0) return -1;
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int t = list.get(mid);
            if (t == key) return mid;
            if (key > t) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}

class MyHashSet {
    private static final int M = 997;
    ArrayList<Integer>[] data;
    public MyHashSet() {
        data = new ArrayList[M];
        Arrays.setAll(data,e->new ArrayList<>());
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer num : data[h]) {
            if (num == key) return;
        }
        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer num : data[h]) {
            if (num == key) {
                data[h].remove(num);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (Integer num : data[h]) {
            if (num == key) return true;
        }
        return false;
    }

    private int hash(int key) {
        return key%M;
    }
}
