package interviewGoogle;

import java.util.ArrayList;

public class Practice {
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
}
