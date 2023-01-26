import Interfaces.HeapSortInterface;

public class HeapSort<T extends Comparable<T>> implements HeapSortInterface<T> {

    Heap<T> heap;

    @Override
    public T[] sort(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Array is equals to null");
        }

        heap = new Heap<T>(items);

        return items;
    }
}
