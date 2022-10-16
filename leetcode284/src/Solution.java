// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> list;
    int p;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        p = 0;
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(p);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        p++;
        return list.get(p - 1);
    }

    @Override
    public boolean hasNext() {
        return p <= list.size() - 1;
    }
}
