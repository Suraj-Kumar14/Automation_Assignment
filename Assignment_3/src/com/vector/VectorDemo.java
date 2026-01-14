package com.vector;
import java.util.*;

public class VectorDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- Constructors ----------------

        Vector<Integer> v1 = new Vector<>();        // Default constructor
        Vector<Integer> temp = new Vector<>();      // Collection constructor
        temp.add(100);
        temp.add(200);
        int choice;

        do {
            System.out.println("\n===== VECTOR MENU =====");
            System.out.println("1. Add elements (add)");
            System.out.println("2. Add element (addElement)");
            System.out.println("3. Get element");
            System.out.println("4. Set element");
            System.out.println("5. Remove by index");
            System.out.println("6. Remove by value");
            System.out.println("7. Size");
            System.out.println("8. Capacity");
            System.out.println("9. Contains");
            System.out.println("10. IndexOf");
            System.out.println("11. First Element");
            System.out.println("12. Last Element");
            System.out.println("13. Is Empty");
            System.out.println("14. Display using Enumeration");
            System.out.println("15. Clear Vector");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number of elements: ");
                    int n = sc.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        v1.add(sc.nextInt());
                    }
                    System.out.println("Vector: " + v1);
                    break;

                case 2:
                    System.out.print("Enter element to add: ");
                    int addEle = sc.nextInt();
                    v1.addElement(addEle);
                    System.out.println("Vector: " + v1);
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    int getIndex = sc.nextInt();
                    System.out.println("Element: " + v1.get(getIndex));
                    break;

                case 4:
                    System.out.print("Enter index: ");
                    int setIndex = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int setValue = sc.nextInt();
                    v1.set(setIndex, setValue);
                    System.out.println("Vector: " + v1);
                    break;

                case 5:
                    System.out.print("Enter index to remove: ");
                    int remIndex = sc.nextInt();
                    v1.remove(remIndex);
                    System.out.println("Vector: " + v1);
                    break;

                case 6:
                    System.out.print("Enter value to remove: ");
                    int remEle = sc.nextInt();
                    v1.removeElement(remEle);
                    System.out.println("Vector: " + v1);
                    break;

                case 7:
                    System.out.println("Size: " + v1.size());
                    break;

                case 8:
                    System.out.println("Capacity: " + v1.capacity());
                    break;

                case 9:
                    System.out.print("Enter element to check: ");
                    int conEle = sc.nextInt();
                    System.out.println("Contains? " + v1.contains(conEle));
                    break;

                case 10:
                    System.out.print("Enter element: ");
                    int idxEle = sc.nextInt();
                    System.out.println("Index: " + v1.indexOf(idxEle));
                    break;

                case 11:
                    System.out.println("First Element: " + v1.firstElement());
                    break;

                case 12:
                    System.out.println("Last Element: " + v1.lastElement());
                    break;

                case 13:
                    System.out.println("Is Empty? " + v1.isEmpty());
                    break;

                case 14:
                    System.out.println("Elements using Enumeration:");
                    Enumeration<Integer> e = v1.elements();
                    while (e.hasMoreElements()) {
                        System.out.print(e.nextElement() + " ");
                    }
                    System.out.println();
                    break;

                case 15:
                    v1.clear();
                    System.out.println("Vector cleared");
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}