package dataStructure;

public class LinkedListNode {
	private int data;
	public LinkedListNode next;
	public LinkedListNode(int data, LinkedListNode next){
		this.data = data;
		this.next = next;
	}
	public int getData(){
		return data;
	}
	public void setData(int newData){
		data = newData;
		
	}

	
}
