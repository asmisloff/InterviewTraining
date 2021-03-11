package ru.asmisloff.interviewtraining.ht02;

import java.util.Arrays;

public class ArrayList<T> {

    private T[] arr;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        arr = (T[]) new Object[capacity];
    }

    public void add(T elt) {
        if (size == arr.length) {
            ensureCapacity(size * 2);
        }
        arr[size++] = elt;
    }

    public void ensureCapacity(int newLength) {
        if (newLength > arr.length) {
            arr = Arrays.copyOf(arr, newLength);
        }
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index != size - 1) {
            System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        }

        --size;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
