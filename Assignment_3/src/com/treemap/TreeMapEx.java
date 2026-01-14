package com.treemap;
import java.util.*;
public class TreeMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);

//TreeMap Constructors
TreeMap<Integer,String> tm1=new TreeMap<>();
TreeMap<Integer,String> tm2=new TreeMap<>(Collections.reverseOrder());
TreeMap<Integer,String> temp=new TreeMap<>();
temp.put(1,"A");
temp.put(2, "B");
TreeMap<Integer,String> tm3=new TreeMap<>(temp);
TreeMap<Integer,String> tm4=new TreeMap<>(tm1);

int choice;
do {
	System.out.println("\n===== TREEMAP MENU ====");
	System.out.println("1. Put(add key-value)");
	System.out.println("2. Get value");
	System.out.println("3. Remove entry");
	System.out.println("4. Contains Key");
	System.out.println("5. Contains Value");
	System.out.println("6. Size");
	System.out.println("7. Is Empty");
	System.out.println("8. First Key");
	System.out.println("9. Last key");
	System.out.println("10. Higher Key");
	System.out.println("11. Lower Key");
	System.out.println("12. Ceiling Key");
	System.out.println("13. Floor key");
	System.out.println("14. Entry Set");
	System.out.println("15. Clear TreeMap");
	System.out.println("0. Exit");
	System.out.print("Enter your choice: ");
	
	choice=sc.nextInt();
	
	switch(choice) {
	case 1:
		System.out.print("Enter key: ");
		int key=sc.nextInt();
		System.out.print("Enter value: ");
		String value=sc.next();
	tm1.put(key, value);
	System.out.println("TreeMap: "  + tm1);
	break;
	
	case 2:
		System.out.print("Entery key: ");
		int getKey=sc.nextInt();
		System.out.println("Value: " + tm1.get(getKey));
		break;
		
	case 3:
		
		System.out.print("Enter key to remove: ");
		int remKey=sc.nextInt();
		tm1.remove(remKey);
		System.out.println("TreeMap: " + tm1);
		break;
		
	case 4:
		System.out.print("Enter key: ");
		int cKey=sc.nextInt();
		System.out.println("Conatins Key? "  + tm1.containsKey(cKey));
		break;
		
	case 5:
		System.out.print("Enter valye: ");
		String cVal=sc.next();
		System.out.println("Contains Value?" + tm1.containsValue(cVal));
		break;
		
	case 6:
		System.out.println("Size: " + tm1.size());
		break;
		
	case 7:
		System.out.println("Is Empty?" + tm1.isEmpty());
		break;
		
	case 8:
		System.out.println("First Key: " + tm1.firstKey());
		break;
		
	case 9:
		System.out.println("Last Key: " + tm1.lastKey());
		break;
		
	case 10:
		System.out.print("Enter key: ");
		int hk=sc.nextInt();
		System.out.println("Higher Key: " + tm1.higherKey(hk));
		break;
		
	case 11:
		System.out.print("Enter key: ");
		int lk=sc.nextInt();
		System.out.println("Lower Key: " + tm1.lowerKey(lk));
	break;
	
	case 12:
		System.out.print("Enter key: ");
		int ck=sc.nextInt();
		System.out.println("Ceiling Key: " + tm1.ceilingKey(ck));
		break;
		
	case 13:
		System.out.print("Enter key: ");
		int fk=sc.nextInt();
		System.out.println("Floor Key: " + tm1.floorKey(fk));
		break;
		
	case 14:
		System.out.println("Entery Set: " + tm1.entrySet());
		break;
		
	case 15:
		tm1.clear();
		System.out.println("TreeMap cleared");
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