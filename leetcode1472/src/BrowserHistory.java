class BrowserHistory {
    String[] ss = new String[5000];
    int cur,last;
    public BrowserHistory(String homepage) {
        ss[0] = homepage;
        cur = 0;
        last = 0;
    }

    public void visit(String url) {
        ss[++cur] = url;
        last = cur;
    }

    public String back(int steps) {
        cur = Math.max(cur - steps,0);
        return ss[cur];
    }

    public String forward(int steps) {
        cur = Math.min(last,cur + steps);
        return ss[cur];
    }
}