package ru.asmisloff.interviewtraining.ht02;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private LinkedList(T elt) {
        head = new Node<>(elt, null);
        tail = head;
    }

    private LinkedList() {
        head = tail = null;
    }

    @SafeVarargs
    public static <T> LinkedList<T> of(T... elts) {
        LinkedList<T> lst = new LinkedList<>(elts[0]);
        for (int i = 1; i < elts.length; ++i) {
            lst.append(elts[i]);
        }

        return lst;
    }

    public static <T> LinkedList<T> empty() {
        return new LinkedList<>();
    }

    public void append(T elt) {
        Node<T> newNode = new Node<>(elt, null);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.tail = newNode;
            tail = newNode;
        }
    }

    private Node<T> getNode(int index) {
        int cnt = 0;
        Node<T> curr = head;

        while (cnt++ != index) {
            curr = curr.tail;
            if (curr == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        return curr;
    }

    public T get(int index) {
        return getNode(index).head;
    }

    public void insert(T elt, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index - 1);
        node.tail = new Node<>(elt, node.tail);
    }

    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                return;
            }
            if (head.tail == null) {
                head.head = null;
            } else {
                head = head.tail;
            }
            return;
        }

        Node<T> prev = getNode(index - 1);
        Node<T> theOne = prev.tail;
        if (theOne == tail) {
            prev.tail = null;
            tail = prev;
            return;
        }

        prev.tail = theOne.tail;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.head).append(" -> ");
            curr = curr.tail;
        }
        sb.setLength(sb.length() - 4);
        sb.append("]");
        return sb.toString();
    }

    static class Node<T> {

        private T head;
        private Node<T> tail;

        public Node(T head, Node<T> tail) {
            this.head = head;
            this.tail = tail;
        }

    }

}
