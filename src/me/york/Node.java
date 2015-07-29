package me.york;


import com.sun.istack.internal.NotNull;

class Node<K, V extends Comparable<V>> implements Comparable<Node<K, V>> {
    private K key;
    private V value;
    private int index;
    private long lastTime;
    private long lastSecondTime;
    public static long INIT = -1;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
        lastTime = INIT;
        lastSecondTime = INIT;
    }

    @Override
    public int compareTo(@NotNull Node<K, V> o) {
        return value.compareTo(o.getValue());
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    long getLastTime() {
        return lastTime;
    }

    void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    long getLastSecondTime() {
        return lastSecondTime;
    }

    void setLastSecondTime(long lastSecondTime) {
        this.lastSecondTime = lastSecondTime;
    }
}
