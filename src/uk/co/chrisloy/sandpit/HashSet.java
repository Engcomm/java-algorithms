package uk.co.chrisloy.sandpit;

public class HashSet<T> implements Set<T> {
    
    private final HashTable<T, Void> table;
    
    public HashSet(int capacity) {
        table = new HashTable<T, Void>(capacity);
    }
    
    @Override
    public void add(T t) {
        table.insert(t, null);
    }

    @Override
    public boolean contains(T t) {
        return table.containsKey(t);
    }

}
