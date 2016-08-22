package interviewGoogle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
// practice site: http://javarevisited.blogspot.com/2011/06/top-programming-interview-questions.html
public class Practice {
	static int count = 0;
	public static void main (String args[]){
		System.out.println("hola");
		System.out.println(isUnique("w"));
		System.out.println(reverseStr("holas"));
		System.out.println(reverseRec("hola",0));
		System.out.println(removeDup("aaaabbbbdescevsdsdsce"));
		System.out.println(anagram("abbbb","aaaaa"));
		System.out.println(replace(" ,"));
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(1);
		first.add(2);
		first.add(3);
		first.add(4);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = getSubsets(first,0);
		System.out.println(result);
		System.out.println(palindrome("hoohla"));
		System.out.println(removeGiven("holaaaaaewqew",'h'));
		System.out.println(permutation("abc"));
		System.out.println(permutationBetter("abc"));
		System.out.println(longestPalindrome("hoohla"));
		System.out.println(firstNoRepeat("holaho"));
		System.out.println(countCha("addsec",'a'));
		System.out.println((int)'z');
		System.out.println(anagramAsc("AD","BC"));
		int[] arr = new int[100];
		for (int i = 1; i < 101; i++)
			arr[i-1] = i;
		arr[94] = -1;
		arr[4] = -1;

		arr[49] = -1;
		ArrayList<Integer> ar = missingNumbers(arr);
		for (int i = 0; i < ar.size(); i++){
			System.out.println(ar.get(i));
		}
		arr[94] = 95;
		arr[4] = 5;
		arr[49] = 49;
		System.out.println(checkOneDuplicated(arr));
		arr[94] = 94;
		arr[4] = 4;
		ArrayList<Integer> set = checkMoreDuplicated(arr);
		for (int i = 0 ; i < set.size(); i ++){
			System.out.println("this is: " + set.get(i));
		}
	}
	public static ArrayList<Integer> missingNumbers(int[] arr){
		ArrayList<Integer> store = new ArrayList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (int a: arr)
			store.add(a);
		for (int i = 0; i < 100; i++){
			if (!store.contains(i+1))
				count.add(i);
		}
		return count;
	}
	public static boolean isUnique(String str){
		boolean[] char_set = new boolean[256];
		for (int i = 0; i <str.length(); i++){
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	public static boolean uniqueCha (String str){
		ArrayList<Character> strArr = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++){
			if (strArr.contains(str.charAt(i))){
				return false;
			}
			else{
				strArr.add(str.charAt(i));
			}
		}
		return true;
	}
	public static boolean anagramAsc(String s1, String s2){
		int count1 = 1, count2 = 1;
		for (int i = 0; i < s1.length(); i++)
			count1*= (int)s1.charAt(i);
		for (int j = 0; j<s2.length();j++)
			count2*=(int)s2.charAt(j);
		if (count1 == count2)
			return true;
		else
			return false;
	}
	public static boolean uniqueNoBuffer(String str){
		for (int i = 0; i < str.length()-1; i ++){
			for (int j = i+1; j < str.length(); j++){
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
	public static String reverseStr(String str){
		int length = str.length();
		char[] charArr = str.toCharArray();
		for (int i = 0; i < length/2; i++){
			char first = charArr[i];
			char last = charArr[length-1-i];
			charArr[i] = last;
			charArr[length-i-1] = first;
		}
		String newStr = new String(charArr);
		return newStr;
	}
	public static String reverseRec(String str, int stack){
		if (str == null)
			return null;
		else if (str.length() == 1){
			System.out.println(stack);
			return str;
		}
		else{
			return str.charAt(str.length()-1) + reverseRec(str.substring(0, str.length()-1), stack+1);
		}
	}
	public static String removeDup(String str){
		ArrayList<Character> newStr = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++){
			if (!newStr.contains(str.charAt(i))){
				newStr.add(str.charAt(i));
			}
		}
		String newStrr = "";

		for (int j = 0; j < newStr.size(); j++){
			newStrr += newStr.get(j);
		}
		return newStrr;
	}
	public static boolean anagram(String str1, String str2){
		if (str1.length() != str2.length())
			return false;
		ArrayList<String> middle = new ArrayList<String>(); 
		for (int i = 0; i < str1.length(); i++){
			middle.add(Character.toString(str1.charAt(i)));
		}
		for (int j = 0; j < str2.length(); j++){
			if (!middle.contains(Character.toString(str2.charAt(j)))){
				return false;
			}
			else{
				middle.remove(Character.toString(str2.charAt(j)));
			}
		}
		return true;
	}
	public static String replace(String str){
		char[] charArr = str.toCharArray();
		int spaceCount = 0;
		for (int i = 0; i < charArr.length; i++){
			if (charArr[i] == ' ')
				spaceCount++;
		}
		char[] newStr = new char[str.length()+spaceCount*2];
		int index = 0;
		for (int j = 0; j < str.length(); j++){
			if (charArr[j] != (' ')){
				newStr[index] = charArr[j];
				index ++;
			}
			else{
				newStr[index] = '%';
				newStr[index+1] = '2';
				newStr[index+2] = '0';
				index += 3;
			}
		}
		String newS = new String(newStr);
		return newS;
		
	}
	//failed wrong idiot
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> subsets;
		if (set.size() == index){
			subsets = new ArrayList<ArrayList<Integer>>();
			subsets.add(new ArrayList<Integer>());
			return subsets;
		}
		subsets = getSubsets(set, index +1);
		ArrayList<ArrayList<Integer>> sub = new ArrayList<ArrayList<Integer>>();
		int item = set.get(index);
	
		for (ArrayList<Integer> sett: subsets){
			ArrayList<Integer> news = new ArrayList<Integer>();
			news.add(item);
			news.addAll(sett);
			sub.add(news);
		}
		subsets.addAll(sub);
		
		return subsets;
	}
	public static boolean palindrome(String str){
		if (str == null)
			return false;
		for (int i = 0; i < str.length()/2; i++){
			if (str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		}
		return true;
	}
	public static String removeGiven(String str, char given){
		if (str == null)
			return null;
		else if(str == "")
			return "";
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) == given){
				if (i == 0)
					return str.substring(1);
				else{
					return str.substring(0, i) + str.substring(i+1,str.length());
				}
			}
		}
		return str;
	}


	private static ArrayList<String> permutation(String str) {
	    int n = str.length();
	    ArrayList<String> resu = new ArrayList<String>();
	    if (n == 0) return resu;
	    else if (n == 1){
	    	resu.add(str);
	    	return resu;
	    }
	    else {
	        for (int i = 0; i < n; i++){
	           ArrayList<String> result = permutation(str.substring(0, i) + str.substring(i+1, n));
	           for (String st: result){
	        	   count++;
	        	   resu.add(str.charAt(i) + st);
	           }
	        }
	    }
	    return resu;
	}
	private static ArrayList<String> permutationBetter(String str) {
	    int n = str.length();
	    ArrayList<String> resu = new ArrayList<String>();
	    if (n == 0){
	    	resu.add("");
	    	return resu;
	    }
	    else if (n == 1){
	    	resu.add(str);
	    	return resu;
	    }
    	ArrayList<String> remainder = permutationBetter(str.substring(1));
        for (String st: remainder){
        	for (int i = 0; i <= st.length(); i++){
        	   resu.add(st.substring(0, i)+ str.charAt(0) + st.substring(i));


        	}
        }


	    return resu;
	}
	public static String longestPalindrome(String str){
		if (str.length() <=1)
			return str;
		for (int i = str.length(); i > 1; i--){
			if (palindrome(str.substring(0,i)))
				return str.substring(0,i);
			
		}
		return Character.toString(str.charAt(0));
	}
	public static char firstNoRepeat(String str){
		if (str.length() <= 1){
			return str.charAt(0);
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i =0; i < str.length(); i++){
			if (map.containsKey(str.charAt(i))){
				int tmp = map.get(str.charAt(i));
				map.put(str.charAt(i), tmp+1);
			}
			else{
				map.put(str.charAt(i),1);
			}
		}
		for (int j = 0; j < str.length(); j++){
			if(map.get(str.charAt(j)) == 1)
				return str.charAt(j);
		}
		return ' ';
	}
	public static int checkOneDuplicated(int[] arr){
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++){
			if (!set.add(arr[i])){
				return i;
			}
		}
		for (int bro: set)
			System.out.print(bro + ",");
		return -1;
	}
	public static ArrayList<Integer> checkMoreDuplicated(int[] arr){

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> set = new ArrayList<Integer>();
		if (arr.length <= 1){
			set.add(arr[0]);
			return set;
		}
		for (int i = 0; i < arr.length; i++){
			if (map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}
			else
				map.put(arr[i],1);
		}
		for (int j = 1; j < map.size();j++){
			if (map.get(j) != null &&map.get(j) > 1){
				set.add(j);
			}
		}
		return set;
	}
	public static int countCha(String str, char ch){
		int count = 0;
		for (int i = 0; i < str.length();i++){
			if (str.charAt(i) == ch)
				count++;
		}
		return count;
	}
	
}
