import java.util.HashMap;

/**
 * 方法一：双向链表
 */
class Node {
    int key,val;
    Node prev,next;
    public Node (int key,int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node dummyHead,dummyTail;//虚拟头节点、尾结点
    HashMap<Integer,Node> map;//HashMap用于存储节点
    int size;
    int capacity;
    public LRUCache(int capacity) {
        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        //实现更新操作先从map中拿到这个节点的值，然后从双向链表中删除该节点，放到首位
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int value = curNode.val;
            //实现删除操作
            delete(curNode);
            //然后将该节点放到头部
            insertHead(curNode);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        Node curNode;
        if (map.containsKey(key)) {
            curNode = map.get(key);
            curNode.val = value;
            //删除当前节点，后续更新到头部
            delete(curNode);
        }
        else {
            //如果双向链表已满，则删除末尾的节点，并从map中移除
            if (size == capacity) {
                Node tail = dummyTail.prev;
                int delKey = tail.key;
                map.remove(delKey);
                delete(tail);
            }
            //在添加节点
            curNode = new Node(key,value);
            map.put(key,curNode);
        }
        //注意，两种情况都要更新
        insertHead(curNode);
    }

    private void delete(Node node) {
        Node pre = node.prev,nex = node.next;
        pre.next = nex;
        nex.prev = pre;
        size--;
    }

    private void insertHead(Node node) {
        Node head = dummyHead.next;
        dummyHead.next = node;
        node.next = head;
        head.prev = node;
        node.prev = dummyHead;
        size++;
    }
}