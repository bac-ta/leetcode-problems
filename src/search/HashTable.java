package search;

import java.util.LinkedList;

class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Entry<K, V> entry) {
        if (!this.key.equals(entry.key))
            return false;
        return this.value.equals(entry.value);
    }
}

public class HashTable<K, V> {
    private int capacity;
    private LinkedList<Entry<K, V>>[] buckets;

    public HashTable(int capacity) {
        this.capacity = capacity;
        buckets = ((LinkedList<Entry<K, V>>[]) new LinkedList[capacity]);
    }

    public int hashFunc(K key) {
        return Integer.parseInt(key.toString()) % capacity;
    }

    public void put(K key, V value) {
        int hashCode = hashFunc(key);
        if (buckets[hashCode] == null)
            buckets[hashCode] = new LinkedList<>();

        LinkedList<Entry<K, V>> list = buckets[hashCode];
        Entry<K, V> entry = new Entry<K, V>(key, value);
        list.add(entry);
    }

    public V get(K key) {
        int hashCode = hashFunc(key);
        if (buckets[hashCode] == null)
            return null;
        LinkedList<Entry<K, V>> list = buckets[hashCode];
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    public void delete(K key) {
        int hashCode = hashFunc(key);
        if (buckets[hashCode] == null)
            return;
        LinkedList<Entry<K, V>> list = buckets[hashCode];
        LinkedList<Entry<K, V>> list2 = new LinkedList<>(); // copy to another list
        for (Entry<K, V> entry : list) {
            if (!entry.key.equals(key))
                list2.add(entry);
        }
        buckets[hashCode] = (list2.size() == 0) ? null : new LinkedList<>(list2);
    }
}
