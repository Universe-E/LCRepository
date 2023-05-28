import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer,String[]> p;
    HashMap<String,int[]> travel;
    public UndergroundSystem() {
        p = new HashMap<>();
        travel = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        p.put(id,new String[]{stationName, String.valueOf(t)});
    }

    public void checkOut(int id, String stationName, int t) {
        String[] ss = p.remove(id);
        String k = ss[0] + "->" + stationName;
        int cost = t-Integer.parseInt(ss[1]);
        travel.merge(k,new int[] {1,cost},(a,b) -> new int[]{a[0]+b[0],a[1]+b[1]});
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] arr = travel.get(startStation+"->"+endStation);
        return (double) arr[1]/arr[0];
    }
}