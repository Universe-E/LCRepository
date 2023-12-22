import java.util.HashMap;
import java.util.TreeSet;

class FoodRatings {
    int[] rs;
    String[] fs;
    HashMap<String, TreeSet<Integer>> cuisineMap;
    HashMap<String,String> foodToCuisine;
    HashMap<String,Integer> foodIndex;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rs = ratings;
        this.fs = foods;
        int n = foods.length;
        cuisineMap = new HashMap<>();
        foodToCuisine = new HashMap<>();
        foodIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!cuisineMap.containsKey(cuisines[i])) {
                //同一烹饪方式的食物评分由大到小排序，如果评分相同，按字符排序
                cuisineMap.put(cuisines[i],new TreeSet<>((o1,o2) ->
                        rs[o1]==rs[o2] ? fs[o1].compareTo(fs[o2]) : (rs[o2]-rs[o1])));
            }
            //在该烹饪方式下加入编号
            cuisineMap.get(cuisines[i]).add(i);
            //加入当前食物的烹饪方式
            foodToCuisine.put(foods[i],cuisines[i]);
            //当前食物的索引
            foodIndex.put(foods[i], i);
        }
    }

    public void changeRating(String food, int newRating) {
        int i = foodIndex.get(food);
        String cuisine = foodToCuisine.get(food);
        cuisineMap.get(cuisine).remove(i);
        rs[i] = newRating;
        cuisineMap.get(cuisine).add(i);
    }

    public String highestRated(String cuisine) {
        return fs[cuisineMap.get(cuisine).first()];
    }
}