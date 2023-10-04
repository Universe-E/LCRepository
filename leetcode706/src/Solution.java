import java.util.ArrayList;
import java.util.Arrays;

class MyHashMap {

    class Pair {
        int k;
        int v;
        public Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }

    public static final int B = 3331;
    ArrayList<Pair>[] arr;
    public MyHashMap() {
        arr = new ArrayList[B];
        Arrays.setAll(arr,e->new ArrayList<>());
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (Pair p : arr[h]) {
            if (p.getK() == key) {
                p.setV(value);
                return;
            }
        }
        arr[h].add(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        for (Pair p : arr[h]) {
            if (p.getK() == key) return p.getV();
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        for (Pair p : arr[h]) {
            if (p.getK() == key) {
                arr[h].remove(p);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % B;
    }
}