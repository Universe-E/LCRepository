class Robot {
    int width,height,length,round;
    private static final String[] ss = new String[] {"East","North","West","South"};
    public Robot(int width, int height) {
        length = 0;
        this.width = width;
        this.height = height;
        round = 2 * (width + height) - 4;
    }

    public void step(int num) {
        length += num;
    }

    public int[] getPos() {
        int diff = length % round;
        if (diff == 0) return new int[] {0,0};
        if (diff < width) return new int[] {diff,0};
        if (diff >= width && diff < width + height - 1) return new int[] {width - 1,diff - width + 1};
        if (diff >= width + height - 1 && diff < 2 * width + height - 2) return new int[] {2 * width + height - diff - 3,height - 1};
        else return new int[] {0,round - diff};
    }

    public String getDir() {
        int[] pos = getPos();
        if (pos[0] == 0 && pos[1] == 0) {
            if (length == 0) return ss[0];
            else return ss[3];
        }
        if (pos[0] != 0 && pos[1] == 0) return ss[0];
        if (pos[0] == width - 1) return ss[1];
        if (pos[0] != width - 1 && pos[1] == height - 1) return ss[2];
        else return ss[3];
    }
}