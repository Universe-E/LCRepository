import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id,i);
        }
        int res = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(id);
        while (!q.isEmpty()) {
            int curId = q.pollFirst(),idx = map.get(curId);
            int ipt = employees.get(idx).importance;
            res += ipt;
            for (Integer subId : employees.get(idx).subordinates) {
                q.addLast(subId);
            }
        }
        return res;
    }
}