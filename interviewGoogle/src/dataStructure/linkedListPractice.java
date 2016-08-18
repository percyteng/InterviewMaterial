package dataStructure;

import java.util.*;
//The main advantages of linked lists are that insertions or 
//deletions don’t require moving the other nodes around in memory. 
//All that is required is to change the link pointers.

//The disadvantage of a linked list is that there is no instant access to 
//a particular element or node (except the first one). 
//You need to search through the list
public class linkedListPractice {
    static LinkedListNode fifth = new LinkedListNode(5,null);
    static LinkedListNode fourth = new LinkedListNode(4,fifth);
    static LinkedListNode third = new LinkedListNode(3,fourth);
    static LinkedListNode second = new LinkedListNode(2,third);
    static LinkedListNode first = new LinkedListNode(1,second);
	public static void main(String args[]){
        LinkedList<String> linkedlist = new LinkedList<String>();
        LinkedListNode fifth = new LinkedListNode(5,first);
        LinkedListNode fourth = new LinkedListNode(4,fifth);
        LinkedListNode third = new LinkedListNode(3,fourth);
        LinkedListNode second = new LinkedListNode(2,third);
        LinkedListNode first = new LinkedListNode(1,second);
        LinkedListNode cpy = new LinkedListNode(3,second);
//        LinkedListNode cpy = removeDup(first);
//        printList(cpy);
        printList(shit(0,cpy,first));
        System.out.println("");
        System.out.println(nthNode(first,3));
        System.out.println(nthNodeS(first,3));
        printList(circular(first));
        System.out.println("");
        printList(skip(first));

	}
	public static LinkedListNode circular(LinkedListNode n){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		LinkedListNode cpy = n;
		while (cpy != null){
			if (arr.contains(cpy.getData())){
				System.out.println("got it");
				return cpy;
			}
			else{
				arr.add(cpy.getData());
				cpy = cpy.next;
			}
		}
		return cpy;
	}
	public static void printList(LinkedListNode n){
		while (n != null){
			System.out.print(n.getData());
			n = n.next;
		}
	}
	public static int nthNodeS(LinkedListNode n, int index){
		LinkedListNode p = n;
		for (int i = 0; i < index-1; i++){
			n = n.next;
		}
		while(n.next != null){
			n = n.next;
			p = p.next;
		}
		return p.getData();
	}
	public static int nthNode(LinkedListNode n, int index){
		LinkedListNode p = n;
		int count = 1;
		while (n.next != null){
			n = n.next;
			count++;
		}
		for (int i = 0; i < count-index; i++){
			p = p.next;
		}
		return p.getData();
		
	}
	public static LinkedListNode skip(LinkedListNode n){
		LinkedListNode cpy = n;
		cpy.setData(n.next.getData());
		cpy.next = n.next.next;
		return cpy;
	}
	public static LinkedListNode shit(int carry, LinkedListNode l1, LinkedListNode l2){
		if (l1 == null && l2 == null&&carry == 0)
			return null;
		if (l1 == null && l2 == null&&carry != 0)
			return new LinkedListNode(carry,null);
		int value = 0;
		if (l1 != null){
			value += l1.getData();
		}
		if (l2 != null){
			value += l2.getData();
		}
		value += carry;
		if (value >= 10){
			carry = value/10;
			value -= carry*10;
		}
		else 
			carry = 0;
		return new LinkedListNode(value, shit(carry, l1.next ,l2.next));
		
		
	}
	public static LinkedListNode removeDup(LinkedListNode n){
		LinkedListNode copy = n;
		LinkedListNode follow = copy;
		ArrayList<Integer> count = new ArrayList<Integer>();
		while (n != null){
			if (count.contains(n.getData())){
				
				follow.next = n.next;
			}
			else{
				count.add(n.getData());
				follow = n;
			}
			n = n.next;
		}
		return copy;
	}
}
