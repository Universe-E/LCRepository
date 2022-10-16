class LUPrefix {

    int[] videos;
    int p;
    public LUPrefix(int n) {
        videos = new int[n + 2];
        p = 0;
    }

    public void upload(int video) {
        videos[video] = 1;
    }

    public int longest() {
        while (videos[p + 1] == 1) {
            p++;
        }
        return p;
    }
}