import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NewClass {
    public static void main(String[] args) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        list.add(new Pair<>(2,3));
        list.add(new Pair<>(2,4));
        list.add(new Pair<>(3,3));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
