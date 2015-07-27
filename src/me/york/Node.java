package me.york;


/**
 * Created by sy on 15/7/24.
 */
class Node<V extends Comparable<V>> implements Comparable<Node<V>> {
    private V value;
    private int index;
    private long lastTime;
    private long lastSecondTime;
    public static long INIT=-1;

    Node(V value){
        this.value=value;
        lastTime=INIT;
        lastSecondTime=INIT;
    }

    @Override
    public int compareTo(Node<V> o) {
        return 0;
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
