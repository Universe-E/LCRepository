import java.util.Arrays;

class SmallestInfiniteSet {
    boolean[] rem;
    public SmallestInfiniteSet() {
        rem = new boolean[1001];
        Arrays.fill(rem,true);
    }

    public int popSmallest() {
        for (int i = 1; i <= 1000; i++) {
            if (rem[i]) {
                rem[i] = false;
                return i;
            }
        }
        return -1;
    }

    public void addBack(int num) {
        rem[num] = true;
    }
}