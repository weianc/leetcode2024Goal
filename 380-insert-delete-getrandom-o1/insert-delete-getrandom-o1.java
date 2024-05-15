class RandomizedSet {
    Map<Integer, Integer> table;
    List<Integer> res;
    Random rand;
    int p;
    public RandomizedSet() {
        this.table = new HashMap<>();
        this.res = new ArrayList<>();
        this.rand = new Random();
        this.p = 0;
    }
    
    public boolean insert(int val) {
        if(!table.containsKey(val)){
            table.put(val, p);
        }
        else {
            // table already contains val
            return false;
        }
        res.add(val);
        p++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!table.containsKey(val)){
            return false;
        }
        int index = table.get(val);
        // 將最後一個元素索引修改成index
        table.put(res.get(p-1), index);
        Collections.swap(res, index, p-1);
        // 刪掉res最後一個元素
        res.removeLast();
        // 刪掉table中的val
        table.remove(val);
        p--;
        return true;
    }
    
    public int getRandom() {
        // 0 to p-1
        int n = rand.nextInt(p);
        return res.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */