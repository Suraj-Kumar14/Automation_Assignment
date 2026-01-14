package com.hashmap;
import java.util.*;
public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);

//HashMap constructors
HashMap<Integer,String> hm1=new HashMap<>();
HashMap<Integer,String> temp=new HashMap<>();
temp.put(1, "A");
temp.put(2, "B");
HashMap<Integer,String> hm4=new HashMap<>(temp);
int choice;
do {
	System.out.println("\n==== HASHMAP MENU =====");
	System.out.println("1. Put(add key-value)");
	System.out.println("2. Put If Absent");
	System.out.println("3. Get value");
	System.out.println("4. Remove entry");
	System.out.println("5. Contains Key");
	System.out.println("6. Contains Value");
	System.out.println("7. Size");
	System.out.println("8. Is Empty");
	System.out.println("9. Key Set");
	System.out.println("10. Values");
	System.out.println("11. Entry Set");
	System.out.println("12. Replace value");
	System.out.println("13. Get Or Deafult");
	System.out.println("14. For Each");
	System.out.println("15. Clear Map");
	System.out.println("0. Exit");
	System.out.print("Enter your choice: ");
	
	choice=sc.nextInt();
	
	switch(choice) {
	case 1:
		System.out.print("Enter key: ");
		int key=sc.nextInt();
		System.out.print("Enter value: ");
		String value=sc.next();
		hm1.put(key, value);
		System.out.println("HashMap: " + hm1);
		break;
		
	case 2:
		System.out.print("Enter key: ");
		int key1=sc.nextInt();
		System.out.print("Enter value: ");
		String val1=sc.next();
		hm1.putIfAbsent(key1, val1);
		System.out.println("hashMap: " + hm1);
		break;
		
	case 3:
		System.out.print("Enter key: ");
		int getKey=sc.nextInt();
		System.out.println("Value: " + hm1.get(getKey));
		break;
		
	case 4:
		System.out.print("Enter key to remove: ");
		int remKey=sc.nextInt();
		hm1.remove(remKey);
		System.out.println("HashMap: " + hm1);
		break;
		
	case 5:
		System.out.print("Enter key: ");
		int cKey=sc.nextInt();
		System.out.println("Contains Key?" + hm1.containsKey(cKey));
		break;
		
	case 6:
		System.out.print("Enter value: ");
		String cVal=sc.next();
		System.out.println("Contains Value?" + hm1.containsValue(cVal));
		break;
		
	case 7:
		System.out.println("Size: " + hm1.size());
		break;
		
	case 8:
		System.out.println("Is Empty? " + hm1.isEmpty());
		break;
		
	case 9:
		System.out.println("Key Set: " + hm1.keySet());
		break;
		
	case 10:
		System.out.println("Values: " + hm1.values());
		break;
		
	case 11:
		System.out.println("Entry Set: " + hm1.entrySet());
		break;
		
	case 12:
		System.out.print("Enter key: ");
		int rKey=sc.nextInt();
		System.out.print("Enter new value: ");
		String rVal=sc.next();
		hm1.replace(rKey, rVal);
		System.out.println("HashMap: " + hm1);
		break;
		
	case 13:
		System.out.print("Enter key: ");
		int dKey=sc.nextInt();
		System.out.print("Enter default value: ");
		String dVal=sc.next();
	
		System.out.println("Value: " + hm1.getOrDefault(dVal, dVal));
		break;
		
	case 14:
		System.out.println("Using forEach:");
		hm1.forEach((k,v)-> System.out.println(k+"="+v));
		break;
		
	case 15:
		hm1.clear();
		System.out.println("HashMap cleared");
		break;
		
	case 0:
		System.out.println("Exitin program...");
		break;
		
		default:
			System.out.println("Invalid choice!");
	}
}while(choice!=0);
sc.close();
	}

}