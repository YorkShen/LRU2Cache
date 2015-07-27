package me.york;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sy on 15/7/24.
 */
public class LRU2Cache<K,V extends Comparable<V>> {
    private MaxHeap<V> maxHeap;
    private Map<K,Node<V>> map;

    public LRU2Cache(int cacheSize){
        maxHeap=new MaxHeap<V>(cacheSize);
        map=new HashMap<K, Node<V>>((int) ((float) cacheSize / 0.75F + 1.0F));
    }

    public void put(K key,V value){
        if(key!=null&&value!=null) {
            Node<V> previous;
            if ((previous = map.get(key)) != null) {
                maxHeap.remove(previous.getIndex());
            }
            previous=new Node<V>(value);
            map.put(key,previous);
            maxHeap.add(previous);
        }
    }

    public V get(K key){
        V value=null;
        if(key!=null){
            Node<V> node=map.get(key);
            if(node!=null){
                value=node.getValue();
                maxHeap.reVisited(node.getIndex());
            }
        }
        return value;
    }
}
