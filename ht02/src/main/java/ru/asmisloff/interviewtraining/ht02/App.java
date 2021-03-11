package ru.asmisloff.interviewtraining.ht02;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testArrayList() {
        ArrayList<Integer> lst = new ArrayList<>(5);
        for (int i : IntStream.range(0, 10).toArray()) {
            lst.add(i);
        }
        System.out.println(lst);

        lst.remove(3);
        System.out.println(lst);

        lst.add(13);
        System.out.println(lst);

        lst.remove(lst.size() - 1);
        System.out.println(lst);
    }

    private static void testLinkedList() {
        LinkedList<Integer> lst = LinkedList.of(0, 1, 2, 3, 4, 5);
        System.out.println(lst);

        lst.append(6);
        lst.append(7);
        System.out.println(lst);

        lst.insert(13, 3);
        System.out.println(lst);

        lst.remove(3);
        System.out.println(lst);

        System.out.println(lst.get(3));

        LinkedList<Integer> empty = LinkedList.empty();
        empty.remove(0);
        empty.remove(0);
        System.out.println(empty);

        empty.append(0);
        empty.append(0);
        empty.append(1);
        System.out.println(empty);

        empty.remove(0);
        System.out.println(empty);
    }

}
