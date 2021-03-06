class MyHashMap {

    int keyValue[];
    public MyHashMap() {
        keyValue=new int[1000006];
        Arrays.fill(keyValue,-1);
    }
    
    public void put(int key, int value) {
        keyValue[key]=value;
    }
    
    public int get(int key) {
       return keyValue[key];
    }
    
    public void remove(int key) {
        keyValue[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */