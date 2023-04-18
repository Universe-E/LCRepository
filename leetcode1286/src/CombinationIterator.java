import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationIterator {
    int size,index,len;
    List<String> list;
    public CombinationIterator(String characters, int combinationLength) {
        size = characters.length();
        index = 0;
        len = combinationLength;
        list = new ArrayList<>();
        backTrack(characters,0,new StringBuilder());
        Collections.sort(list);
    }

    public String next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private void backTrack(String characters, int idx, StringBuilder sb) {
        if (sb.length() == len) {
            list.add(sb.toString());
            return;
        }
        for (int i = idx; i < size; i++) {
            char c = characters.charAt(i);
            sb.append(c);
            backTrack(characters,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}