import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                if (veganFriendly == 0) list.add(i);
                else if (restaurants[i][2] == 1) list.add(i);
            }
        }
        list.sort((o1, o2) -> (
                restaurants[o1][1] != restaurants[o2][1] ?
                        restaurants[o2][1] - restaurants[o1][1] :
                        restaurants[o2][0] - restaurants[o1][0]
        ));
        List<Integer> res = new ArrayList<>();
        for (Integer integer : list) {
            res.add(restaurants[integer][0]);
        }
        return res;
    }
}