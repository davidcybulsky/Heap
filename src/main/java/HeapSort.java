import Interfaces.HeapSortInterface;

public class HeapSort<T extends Comparable<T>> implements HeapSortInterface<T> {

    Heap<T> heap;

    @Override
    public T[] sort(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Array is equals to null");
        }

        heap = new Heap<T>(items);

        for (int i = items.length - 1; i >= 0; i--) {
            items[i] = heap.pop();
        }

        return items;
    }
}
