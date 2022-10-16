class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {

        //如果都不是叶子节点，则递归到下一层
        if (!quadTree1.isLeaf && ! quadTree2.isLeaf){
            Node res = new Node();
            res.val = true;
            res.isLeaf = false;
            res.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
            res.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
            res.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            res.bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            //如果以下条件均满足，则
            if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf
                    && res.topLeft.val == res.topRight.val == res.bottomLeft.val == res.bottomRight.val) {
                return new Node(true, true, null, null, null, null);
            }
            else {
                return new Node(false,false,res.topLeft,res.topRight,res.bottomLeft,res.bottomRight);
            }
        }

        //如果都是叶子节点，则直接赋值
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
        }
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            else {
                return quadTree2;
            }
        }
        else {
            if (quadTree2.val) {
                return new Node(true, true, null, null, null, null);
            }
            else {
                return quadTree1;
            }
        }

    }
}
