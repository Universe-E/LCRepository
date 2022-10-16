class Solution {
    public boolean validUtf8(int[] data) {
        int n = 0;//这里n表示是UTF-8的某种情况
        for (int datum : data) {
            if (n > 0) {
                if (datum >> 6 != 0b10) return false;
                n--;
            } else if (datum >> 7 == 0b0) n = 0;
            else if (datum >> 5 == 0b110) n = 1;
            else if (datum >> 4 == 0b1110) n = 2;
            else if (datum >> 3 == 0b11110) n = 3;
            else return false;
        }
        return n == 0;
    }
}
