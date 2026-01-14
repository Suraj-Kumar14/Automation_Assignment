package com.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ----------------------------
        // Constructors of ArrayList
        // ----------------------------

        // 1. Default constructor
        ArrayList<String> list1 = new ArrayList<>();

        // 2. Constructor with initial capacity
        System.out.print("Enter initial capacity for list2: ");
        int capacity = sc.nextInt();
        ArrayList<String> list2 = new ArrayList<>(capacity);

        // 3. Collection constructor
        ArrayList<String> list3 = new ArrayList<>();

        // ----------------------------
        // Taking user input
        // ----------------------------
        System.out.print("\nEnter number of elements for list1: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list1.add(sc.nextLine());   // add()
        }

        // ----------------------------
        // 15 ArrayList Methods
        // ----------------------------

        // Method 1: add(index, element)
        System.out.print("\nEnter element to add at index 0: ");
        list1.add(0, sc.nextLine());
        System.out.println("List after add(index, element): " + list1);

        // Method 2: size()
        System.out.println("Size of list: " + list1.size());

        // Method 3: get()
        System.out.print("Enter index to get element: ");
        int index = sc.nextInt();
        System.out.println("Element at index " + index + ": " + list1.get(index));
        sc.nextLine();

        // Method 4: set()
        System.out.print("Enter index to replace element: ");
        int setIndex = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new value: ");
        list1.set(setIndex, sc.nextLine());
        System.out.println("After set(): " + list1);

        // Method 5: remove(index)
        System.out.print("Enter index to remove element: ");
        int removeIndex = sc.nextInt();
        list1.remove(removeIndex);
        System.out.println("After remove(index): " + list1);
        sc.nextLine();

        // Method 6: remove(object)
        System.out.print("Enter element to remove: ");
        String rem = sc.nextLine();
        list1.remove(rem);
        System.out.println("After remove(object): " + list1);

        // Method 7: contains()
        System.out.print("Enter element to check contains(): ");
        String search = sc.nextLine();
        System.out.println("Contains " + search + "? " + list1.contains(search));

        // Method 8: isEmpty()
        System.out.println("Is list empty? " + list1.isEmpty());

        // Method 9: addAll()
        System.out.print("\nEnter number of elements for list3: ");
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            System.out.print("Enter element " + (i + 1) + " for list3: ");
            list3.add(sc.nextLine());
        }

        list1.addAll(list3);
        System.out.println("After addAll(): " + list1);

        // Method 10: indexOf()
        System.out.print("Enter element to find indexOf(): ");
        String ind = sc.nextLine();
        System.out.println("Index of " + ind + ": " + list1.indexOf(ind));

        // Method 11: lastIndexOf()
        System.out.print("Enter element to find lastIndexOf(): ");
        String last = sc.nextLine();
        System.out.println("Last index of " + last + ": " + list1.lastIndexOf(last));

        // Method 12: iterator()
        System.out.print("\nElements using Iterator: ");
        Iterator<String> itr = list1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // Method 13: toArray()
        Object[] arr = list1.toArray();
        System.out.print("Array using toArray(): ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // Method 14: clear()
        list2.clear();
        System.out.println("List2 after clear(): " + list2);

        // Method 15: ensureCapacity()
        list1.ensureCapacity(20);
        System.out.println("ensureCapacity() called on list1");

        sc.close();
    }
}