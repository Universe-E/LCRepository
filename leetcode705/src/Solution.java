import java.util.ArrayList;
import java.util.Collections;

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
