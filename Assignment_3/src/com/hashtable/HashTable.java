package com.hashtable;
import java.util.*;
public class HashTable {
	
	public static void main(String[] args) {
			
	Scanner sc=new Scanner(System.in);
	
	//HashTable constructors
	
	Hashtable<Integer,String> ht1=new Hashtable<>();
	Hashtable<Integer,String> ht2=new Hashtable<>(10);
	Hashtable<Integer,String> ht3=new Hashtable<>(10,0.75f);
	
	Hashtable<Integer,String> temp=new Hashtable<>();
	temp.put(1,"A");
	temp.put(2, "B");
	Hashtable<Integer,String> ht4=new Hashtable<>(temp);
	
	int choice;
	do {
		System.out.println("\n===== HASHTABLE MENU ====");
		System.out.println("1. Put (add key-value)");
		System.out.println("2. Get value");
		System.out.println("3. Remove entry");
		System.out.println("4. Contains Key");
		System.out.println("5. Contains Value");
		System.out.println("6. Size");
		System.out.println("7. Is Empty");
		System.out.println("8. Keys");
		System.out.println("9. Elements");
		System.out.println("10. Key Set");
		System.out.println("11. Values");
		System.out.println("12. Entry Set");
		System.out.println("13. Replace value");
		System.out.println("14. For Each");
		System.out.println("15. Clear Hashtable");
		System.out.println("0 Exit");
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.print("Enter key: ");
			int key=sc.nextInt();
			System.out.print("Enter value: ");
			String value=sc.next();
			ht1.put(key, value);
			System.out.println("Hashtable: " + ht1);
			break;
			
		case 2:
			System.out.print("Enter key: ");
			int getKey=sc.nextInt();
			System.out.println("Value: " + ht1.get(getKey));
			break;
			
		case 3:
			System.out.print("Enter key to remove: ");
			int remKey=sc.nextInt();
			ht1.remove(remKey);
			System.out.println("Hashtable : " + ht1);
			break;
			
		case 4:
			System.out.print("Enter key: ");
			int cKey=sc.nextInt();
			System.out.println("Contains Key? " + ht1.containsKey(cKey));
			break;
			
		case 5:
			System.out.print("Enter value: ");
			String cVal=sc.next();
			System.out.println("Contains Value? " + ht1.containsValue(cVal));
			break;
			
		case 6:
			System.out.println("Size: " + ht1.size());
			break;
			
		case 7:
			System.out.println("Is Empty? " + ht1.isEmpty());
			break;
			
		case 8:
			System.out.println("Keys:");
			Enumeration<Integer> k=ht1.keys();
			while(k.hasMoreElements()) {
				System.out.print(k.nextElement() + " ");
			}
			System.out.println();
			break;
			
		case 9:
			System.out.println("Elements:");
			Enumeration<String> e=ht1.elements();
			while(e.hasMoreElements()) {
				System.out.print(e.nextElement() + " ");
				
			}
			System.out.println();
			break;
			
		case 10:
			System.out.println("Key Set: " + ht1.keySet());
			break;
			
		case 11:
			System.out.print("Values: " + ht1.values());
			break;
			
		case 12:
			System.out.println("Entry Set: " + ht1.entrySet());
			break;
			
			
		case 13:
			System.out.print("Enter key: ");
			int rKey=sc.nextInt();
			System.out.print("Enter new Value: ");
			String rVal=sc.next();
			ht1.replace(rKey,rVal);
			break;
			
		case 14:
			System.out.println("Using forEach:");
			ht1.forEach((k1,v1)->System.out.println(k1 + "=" +v1));
			break;
			
		case 15:
			ht1.clear();
			break;
			
		case 0:
			System.out.println("Exiting program...");
			break;
			
			default:
				System.out.println("Invalid choice!");			
		}		
	}while(choice!=0);
	sc.close();
	}
}