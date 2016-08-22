package interviewGoogle;
import java.util.*;

import dataStructure.BST;
import dataStructure.LinkedListNode;
//haha
public class secondPractice{
	
	
	public static ArrayList<Integer> notPresent(int[] arr1, int[] arr2){
		ArrayList<Integer> val = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i =0 ; i < arr1.length; i ++){
			map.put(i, 1);
		}
		for (int j = 0; j < arr2.length; j++){
			if (!map.containsKey(arr2[j]))
					val.add(arr2[j]);
		}
		return val;
	}
	public static int binarySearch(int[] arr, int target){
		int low = 0;
		int high = arr.length-1;
		while (low <= high){
			int middle = (low + high)/2;
			if (arr[middle] == target) return middle;
			else if (arr[middle] < target) low = middle+1;
			else high = middle-1;
		}
		return -1;
		
	}
	public static void quickSort(int[] arr, int left, int right){
		if (left == right)
			return;
		int low = left;
		int high = right;
		int pivot = arr[(low + right)/2];
		while (low <= high){
			while (arr[low] < pivot){
				low++;
			}
			while (arr[high] > pivot)
				high--;
			if (low <= high){
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
				low ++;
				high--;
			}
		}
		quickSort(arr, left, low-1);
		quickSort(arr,low, right);

	}
	public static LinkedListNode middleLinked(LinkedListNode lis){
		LinkedListNode tmp = lis;
		LinkedListNode traversal = lis;
		while (tmp.next!= null && tmp.next.next != null){
			tmp = tmp.next.next;
			traversal = traversal.next;
		}
		return traversal;
		
	}
	public static LinkedListNode findN(LinkedListNode lis, int n){
		LinkedListNode tmp = lis;
		LinkedListNode traversal = lis;
		for (int i = 0; i < n; i++){
			tmp = tmp.next;
		}
		while (tmp.next != null){
			tmp = tmp.next;
			traversal = traversal.next;
		}
		return traversal;
	}
	public static void main (String[] args){
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {2,3,5,0,7};
		System.out.println(notPresent(arr1,arr2));
		int[] arr= {2,39,10,2344,953,2300};
		System.out.println(secondHighest(arr));
		int[] r = {1,2,3,4,5,6,7};
		printPairs(r, 5);
		System.out.println(binarySearch(r,5));
		int[] w = {1,3,5,6,2,3,5,7,4,34,1,5346,6};
		quickSort(w,0,w.length-1);
		for (int q: w)
			System.out.print(q + ", ");
		LinkedListNode fifth = new LinkedListNode(5, null);
		LinkedListNode fourth = new LinkedListNode(4, fifth);
		LinkedListNode third = new LinkedListNode(3, fourth);
		LinkedListNode second = new LinkedListNode(2, third);
		LinkedListNode first = new LinkedListNode(1, second);
		LinkedListNode middle = middleLinked(first);
		System.out.println(middle.getData());
		LinkedListNode three = findN(first,2);
		System.out.println(three.getData());
		System.out.println(findIfLoop(first));
		BST eleven = new BST(null, 11, null);
		BST seven = new BST(null, 7, null);
		BST one = new BST (null, 1, null);
		BST two = new BST (one, 2, null);
		BST five = new BST(two, 5, seven);
		BST eight = new BST(five,8, eleven);
		System.out.println(depthTree(eight));
	}
	public static int depthTree(BST tree){
		if (tree == null)
			return 0;
		return 1 + Math.max(depthTree(tree.left), depthTree(tree.right));
	
	}
	public static void inorder(BST tree){
		
	}
	public static boolean findIfLoop(LinkedListNode lis){
		LinkedListNode tmp = lis;
		LinkedListNode traversal = lis;
		while(tmp != null && tmp.next != null){
			tmp = tmp.next.next;
			traversal = traversal.next;
			if(tmp == traversal)
				return true;
		}
		return false;
			
	}
	
	public static int secondHighest(int[] arr){
		int highest = 0;
		int second = 0;
		for (int i = 0; i < arr.length; i ++){
			if (arr[i] > second && arr[i] < highest)
				second = arr[i];
			else if (arr[i] > highest){
				second = highest;
				highest = arr[i];
			}
		}
		return second;
	}
	public static void printPairs(int[] arr, int target){
		Arrays.sort(arr);
		int left = 0, right =arr.length-1;
		while (left < right){
			int sum = arr[left] + arr[right];
			if (sum == target){
				System.out.println(arr[left] + " + " + arr[right]);
				left++;
				right--;
			}
			else if (sum < target){
				left++;
			}
			else
				right--;
		}
	}
}
