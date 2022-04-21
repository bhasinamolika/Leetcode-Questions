class MyHashSet {
boolean[] checker;
public MyHashSet() {
checker=new boolean[1000006];
}

public void add(int key) {
    if(checker[key]!=true)
    {
        checker[key]=true;
    }
        
}

public void remove(int key) {
    if(checker[key]==true)
    {
        checker[key]=false;
    }
}

public boolean contains(int key) {
    return checker[key];
}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */