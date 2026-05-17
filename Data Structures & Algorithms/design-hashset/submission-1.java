class MyHashSet {
    public boolean dataSet[];

    public MyHashSet() {
        dataSet=new boolean[1000001];
    }
    
    public void add(int key) {
        dataSet[key]=true;
    }
    
    public void remove(int key) {
        dataSet[key]=false;
    }
    
    public boolean contains(int key) {
        return dataSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */