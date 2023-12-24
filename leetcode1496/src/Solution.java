import java.util.HashSet;

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Integer> set = new HashSet<>();
        int pos = 0;
        set.add(pos);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N' -> pos += 1<<16;
                case 'S' -> pos -= 1<<16;
                case 'W' -> pos -= 1;
                case 'E' -> pos += 1;
            }
            if (set.contains(pos)) return true;
            set.add(pos);
        }
        return false;
    }
}