package me.york;

import java.util.HashMap;
import java.util.Map;

public class LRU2Cache<K, V extends Comparable<V>> {
    private MaxHeap<K, V> maxHeap;
    private Map<K, Node<K, V>> map;

    public LRU2Cache(int cacheSize) {
        maxHeap = new MaxHeap<K, V>(cacheSize);
        map = new HashMap<K, Node<K, V>>((int) ((float) cacheSize / 0.75F + 1.0F));
    }

    public void put(K key, V value) {
        if (key != null && value != null) {
            Node<K, V> previous;
            if ((previous = map.get(key)) != null) {
                maxHeap.remove(previous.getIndex());
            }
            if (maxHeap.isFull())
                map.remove(maxHeap.getMax().getKey());
            previous = new Node<K, V>(key, value);
            map.put(key, previous);
            maxHeap.add(previous);
        }
    }

    public V get(K key) {
        V value = null;
        if (key != null) {
            Node<K, V> node = map.get(key);
            if (node != null) {
                value = node.getValue();
                maxHeap.reVisited(node.getIndex());
            }
        }
        return value;
    }
}
