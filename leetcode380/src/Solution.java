import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer,Integer> map;//val and id
    ArrayList<Integer> list;//val
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);//store id
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        //exchange current val with last val
        int id = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(id,lastVal);
        //renew last val with new id
        map.put(lastVal,id);
        list.remove(list.size()-1);

        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}