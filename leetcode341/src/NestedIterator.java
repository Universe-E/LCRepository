import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    ArrayDeque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) return true;
            else {
                stack.pop();
                List<NestedInteger> nl = ni.getList();
                for (int i = nl.size() - 1; i >= 0; i--) {
                    stack.push(nl.get(i));
                }
            }
        }
        return false;
    }
}

public class NestedIterator2 implements Iterator<Integer> {

    List<Integer> list;
    int idx;
    public NestedIterator2(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        idx = 0;
        for (NestedInteger ni : nestedList) {
            add(ni);
        }
    }

    private void add(NestedInteger ni) {
        if (ni.isInteger()) list.add(ni.getInteger());
        else {
            List<NestedInteger> nl = ni.getList();
            for (NestedInteger ni2 : nl) {
                add(ni2);
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
}