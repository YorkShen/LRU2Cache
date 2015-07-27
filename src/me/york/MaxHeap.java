package me.york;


/**
 * Created by sy on 15/7/24.
 */
class MaxHeap<V extends Comparable<V>> {
    private Node<V>[] heap;
    private int currentSize;
    private long count;
    MaxHeap(int size){
        count=0;
        currentSize=1;
        heap=new Node[size+1];
    }

    Node<V> add(Node<V> value) {
        Node<V> previous=value;
        if(currentSize>=heap.length){
            previous=removeMax();
        }
        if(value.getLastSecondTime()!=Node.INIT){
            value.setLastSecondTime(value.getLastTime());
        }
        else{
            value.setLastSecondTime(count);
        }
        value.setLastTime(count++);
        value.setIndex(currentSize);
        heap[currentSize++]=value;
        siftUp(currentSize - 1);
        return previous;
    }

    Node<V> removeMax(){
        return heap[currentSize--];
    }

    Node<V> reVisited(int index){
        Node<V> node=heap[index];
        remove(node.getIndex());
        add(node);
        return node;
    }

    Node<V> remove(int index){
        Node<V> previous=heap[index];
        heap[index]=heap[--currentSize];
        siftDown(index);
        return previous;
    }

    private void siftDown(int index){
        int left = 2*index;
        int right = 2*index+1;
        int largest;
        if(left<currentSize&&heap[left].compareTo(heap[index])>0)
            largest = left;
        else
            largest = index;
        if(right<currentSize&&heap[right].compareTo(heap[largest])>0)
            largest=right;
        if(largest!=index){
            Node<V> temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heap[index].setIndex(largest);
            heap[largest].setIndex(index);
            siftDown(largest);
        }
    }

    private void siftUp(int index){
        while (index >1 && heap[index].compareTo(heap[index/2])>0){
            Node<V> temp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = temp;
            heap[index].setIndex(index/2);
            heap[index/2].setIndex(index);
            index = index/2;
        }
    }
}
