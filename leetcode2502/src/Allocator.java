import java.util.Arrays;

class Allocator {

    private int[] mem;
    private int length;
    public Allocator(int n) {
        mem = new int[n];
        length = n;
    }

    public int allocate(int size, int mID) {
        int empty = 0;
        for (int i = 0; i < length; i++) {
            if (mem[i] == 0) {
                empty++;
            }
            else empty = 0;
            if (empty == size) {
                Arrays.fill(mem, i + 1 - size,i + 1,mID);
                return i + 1 - size;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (mem[i] == mID) {
                mem[i] = 0;
                cnt++;
            }
        }
        return cnt;
    }
}