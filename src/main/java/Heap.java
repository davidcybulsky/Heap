import Interfaces.HeapInterface;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    List<T> heap;

    Heap() {
        heap = new ArrayList<T>();
    }

    Heap(T[] list) {
        T[] tmp = list.clone();
        heap = new ArrayList<T>(List.of(tmp));
        build();
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
            heapify(child);
        }

    }


    @Override
    public void put(T item) {
        heap.add(item);
        heapUp();
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

    @Override
    public T pop() {
        swap(0, heap.size() - 1);
        heapDown();
        return null;
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    private void heapDown() {
        int parent = 0;
        int child = 2 * parent + 1;

        while (child < heap.size()) {

            if ((child + 1 < heap.size()) && heap.get(child + 1).compareTo(heap.get(child)) > 0) {
                child++;
            }

            if (heap.get(child).compareTo(heap.get(parent)) > 0) {
                swap(child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                return;
            }
        }
    }

    @Override
    public int getSize() {
        return heap.size();
    }
}
