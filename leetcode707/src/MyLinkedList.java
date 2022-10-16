class ListNode {
    int val;
    ListNode next;
    public ListNode() {

    }
    public ListNode (int val) {
        this.val = val;
    }
    public ListNode (int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class MyLinkedList {

    ListNode node,dummy;

    public MyLinkedList() {
        dummy = new ListNode(0, node);
    }

    public int get(int index) {
        ListNode cur = node;
        int i = 0;
        while (cur != null) {
            if (i == index) return cur.val;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        if (node == null) node = new ListNode(val);
        else node = new ListNode(val,node);//注意最后要让node等于新的头节点
    }

    public void addAtTail(int val) {
        if (node == null) node = new ListNode(val);
        else {
            ListNode cur = node;
            while (cur.next != null) cur = cur.next;
            cur.next = new ListNode(val);
        }
    }

    private int getSize() {
        int res = 0;
        ListNode cur = node;
        while (cur != null) {
            res++;
            cur = cur.next;
        }
        return res;
    }

    public void addAtIndex(int index, int val) {
        int size = getSize();
        System.out.println(size);
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        ListNode cur = node;
        int i = 0;
        while (i != index - 1) {
            cur = cur.next;
            i++;
        }
        cur.next = new ListNode(val,cur.next);
    }

    public void deleteAtIndex(int index) {
        int size = getSize();
        if (index >= 0 && index < size) {
            ListNode cur = node;
            if (index == 0) node = node.next;
            else {
                int i = 0;
                while (i != index - 1) {
                    cur = cur.next;
                    i++;
                }
                cur.next = cur.next.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */