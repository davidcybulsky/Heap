package Interfaces;

public interface HeapSortInterface<T extends Comparable<T>> {

    T[] sort(T[] items);
}
