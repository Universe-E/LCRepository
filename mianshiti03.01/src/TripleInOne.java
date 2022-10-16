class TripleInOne {
    int size;
    int[] arr;
    int p1,p2,p3;
    public TripleInOne(int stackSize) {
        size = stackSize;
        arr = new int[3 * size];
        p1 = stackSize;
        p2 = 2 * stackSize;
        p3 = 3 * stackSize;
    }

    public void push(int stackNum, int value) {
        switch (stackNum) {
            case 0 :{
                if (p1 == 0) return;
                p1--;
                arr[p1] = value;
                break;
            }
            case 1 :{
                if (p2 == size) return;
                p2--;
                arr[p2] = value;
                break;
            }
            case 2 :{
                if (p3 == 2 * size) return;
                p3--;
                arr[p3] = value;
                break;
            }
        }

    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        switch (stackNum) {
            case 0 :{
                int value = arr[p1];
                p1++;
                return value;
            }
            case 1 :{
                int value = arr[p2];
                p2++;
                return value;
            }
            default :{
                int value = arr[p3];
                p3++;
                return value;
            }
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        switch (stackNum) {
            case 0 : return arr[p1];
            case 1 : return arr[p2];
            default: return arr[p3];
        }
    }

    public boolean isEmpty(int stackNum) {
        switch (stackNum) {
            case 0 :return p1 == size;
            case 1 :return p2 == 2 * size;
            default:return p3 == 3 * size;
        }
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */