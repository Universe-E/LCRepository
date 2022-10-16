import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    private int ptr;
    private String[] temp;
    public OrderedStream(int n) {
        ptr = 1;
        temp = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        temp[idKey] = value;
        ArrayList<String> res = new ArrayList<>();
        while (ptr < temp.length && temp[ptr] != null) {
            res.add(temp[ptr]);
            ptr++;
        }
        return res;
    }
}

