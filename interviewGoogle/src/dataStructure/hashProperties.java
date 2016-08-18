package dataStructure;
import java.util.*;

//1) List is an ordered collection it maintains the insertion order, which means upon displaying the list content it will display the elements in the same order in which they got inserted into the list.
//Set is an unordered collection, it doesn’t maintain any order. There are few implementations of Set which maintains the order such as LinkedHashSet (It maintains the elements in insertion order).
//2) List allows duplicates while Set doesn’t allow duplicate elements. All the elements of a Set should be unique if you try to insert the duplicate element in Set it would replace the existing value.
//3) List implementations: ArrayList, LinkedList etc.
//Set implementations: HashSet, LinkedHashSet, TreeSet etc.
//4) List allows any number of null values. Set can have only a single null value at most.
public class hashProperties {
	
	public static void main (String[] args){
		hashTable();
		hashMap();
		hashSet();
	}
	public static void hashMap(){
//		It allows null for both key and value.
//		HashMap does not maintain insertion order. The order is defined by the Hash function.
//		It is not synchronized. It will have better performance.
//		HashMap are not thread safe, but you can use Collections.synchronizedMap(new HashMap<K,V>())
		HashMap<Integer,String> myMap= new HashMap<Integer,String>();
		myMap.put(1, "First");
		myMap.put(2,"Second");
		myMap.put(3, null);
		System.out.println(myMap.get(1));
		System.out.println(myMap.get(3));
		System.out.println(myMap);

	}
	public static void hashTable(){
//		It does not allow null for both key and value. It will throw NullPointerException.
//		Hashtable does not maintain insertion order. The order is defined by the Hash function. So only use this if you do not need data in order.
//		It is synchronized. It is slow. Only one thread can access in one time.
//		HashTable rea thread safe.
//		HashTable uses Enumerator to iterate through elements.
		Hashtable<Integer,String> myTable= new Hashtable<Integer,String>();
		myTable.put(1, "John");
		myTable.put(2, "Cena");
//		myTable.put(3, null); /* NullPointerEcxeption at runtime*/
		System.out.println(myTable.get(1));
		System.out.println(myTable.get(2));
		System.out.println(myTable);
	}
	public static void hashSet(){
//		It provides add method rather put method.
//		You also use its contain method to check whether the object is already available in HashSet. HashSet can be used where you want to maintain a unique list.
		HashSet<String> mySet= new HashSet<String>();
		mySet.add ("First");
		mySet.add ("Second");
		mySet.add ("Third");
		mySet.add("Third");
		System.out.println(mySet);
		if(mySet.contains("First")){
			for (String theOne: mySet){
				if (theOne.equals("First"))
					System.out.println("found it");
			}
			System.out.println("The Set already contains First");
		}
	}
	
	//implement hashtable using array
	 private final static int TABLE_SIZE = 128;
	 
     HashEntry[] table;

     hashProperties() {
           table = new HashEntry[TABLE_SIZE];
           for (int i = 0; i < TABLE_SIZE; i++)
                 table[i] = null;
     }

     public int get(int key) {
           int hash = (key % TABLE_SIZE);
           while (table[hash] != null && table[hash].getKey() != key)
                 hash = (hash + 1) % TABLE_SIZE;
           if (table[hash] == null)
                 return -1;
           else
                 return table[hash].getValue();
     }

     public void put(int key, int value) {
           int hash = (key % TABLE_SIZE);
           while (table[hash] != null && table[hash].getKey() != key)
                 hash = (hash + 1) % TABLE_SIZE;
           table[hash] = new HashEntry(key, value);
     }
}
