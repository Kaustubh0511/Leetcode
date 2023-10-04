class MyHashMap {
    static final int size = 19997;
    ListNode[] data;
    public MyHashMap() {
        this.data = new ListNode[size];
    }
    
    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key,value,data[h]);
        data[h] = node;
    }
    
    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        while(node != null){
            if(node.key == key){
                return node.val;
            }
            node = node.next;

        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if(node==null){
            return;
        }
        if(node.key==key){
            data[h] = node.next;
        }
        else{
            while(node.next != null){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return; 
                }
                node = node.next;
            }
        }
    }
    private int hash(int key){
        return key%size;
    }
}
class ListNode{
    int key;
    int val;
    ListNode next;
    public ListNode(int key,int val,ListNode next){
        this.key =  key;
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */