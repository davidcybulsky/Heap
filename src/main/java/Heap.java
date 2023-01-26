import Interfaces.HeapInterface;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private final List<T> heap;

    public Heap() {
        heap = new ArrayList<T>();
    }

    public Heap(T[] list) {

        if (list == null) {
            throw new IllegalArgumentException("List is equals to null");
        }

        T[] cloned = list.clone();
        heap = new ArrayList<T>(List.of(cloned));
        build();
    }

    @Override
    public void put(T item) {

        if (item == null) {
            throw new IllegalArgumentException("Null can not be putted into the heap");
        }

        heap.add(item);
        heapUp();
    }

    @Override
    public T pop() {
        int last = heap.size() - 1;

        if (heap.size() == 0) {
            throw new IllegalStateException("Elem can not be poped from the empty heap");
        }

        T poped = heap.get(0);

        if (heap.size() == 1) {
            heap.remove(0);
            return poped;
        }

        heap.set(0, heap.remove(heap.size() - 1));
        heapDown();
        return poped;
    }

    @Override
    public int getSize() {
        return heap.size();
    }

    private void heapUp() {
        int child = heap.size() - 1;
        int parent = (child - 1) / 2;

        while (child > 0) {

            if (heap.get(parent).compareTo(heap.get(child)) < 0) {
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                return;
            }
        }
    }

    private void heapDown() {
        int parent = 0;
        int child = 1;

        while (child < heap.size()) {

            if ((child + 1 < heap.size()) && heap.get(child + 1).compareTo(heap.get(child)) > 0) {
                child++;
            }

            if (heap.get(parent).compareTo(heap.get(child)) < 0) {
                swap(child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                return;
            }
        }
    }

    private void build() {
        int n = heap.size() - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int parent) {
        int child = 2 * parent + 1;

        if ((child + 1 < heap.size()) && heap.get(child + 1).compareTo(heap.get(child)) > 0) {
            child++;
        }

        if (heap.get(child).compareTo(heap.get(parent)) > 0) {
            swap(child, parent);
            heapify(parent);
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
