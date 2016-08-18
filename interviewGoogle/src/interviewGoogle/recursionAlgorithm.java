package interviewGoogle;

import java.util.ArrayList;
import java.util.HashMap;
//"In computing, memoization is an optimization technique used primarily to speed up computer programs by having function calls avoid repeating the calculation of results for previously-processed inputs."
//
//"In mathematics and computer science, dynamic programming is a method for solving complex problems by breaking them down into simpler subproblems."
//
//When breaking a problem into smaller/simpler subproblems, we often encounter the same subproblem more then once - so we use Memoization to save results of previous calculations so we don't need to repeat them.
//
//Dynamic programming often encounters situations where it makes sense to use memoization but You can use either technique without necessarily using the other.



//Greedy algorithm: choose the cheapest path in each junction without considering further cost.
//Expecting to find a global optimum solution with local optimum solutions.
public class recursionAlgorithm {
	static HashMap<Integer, String> map = new HashMap<Integer,String>();

	public static void main(String[] args){
//		int i = fibonacci(50);
		map.put(1,"1");
		map.put(2, "1");
		int j = fib(50);
		System.out.println("hola " + map.get(3));
		String k = fibo(5);
		System.out.println("third is: " + k);
//		System.out.println("first is: " + i);
		System.out.println("second is: " + j);

	}
	public static int fibonacci(int i){
		if (i == 1|| i == 2)
			return 1;
		else if (i == 0)
			return 0;
		else{
			return fibonacci(i-1) + fibonacci(i-2);
		}
	}
	public static String fibo(int i){
		if (i == 1|| i == 2){
			return map.get(i);
		}
		else if(map.get(i) != null){
			System.out.println("juju" + map.get(i));
			return map.get(i);
		}
		else{
			String x1 = fibo(i-1);
			String x2 = fibo(i-2);
			String value = Integer.toString(Integer.parseInt(x1) + Integer.parseInt(x2));
			map.put(i,value);
			return map.get(i);
		}
	}
	public static int fib(int i){
		int x1 = 1;
		int x2 = 1;
		for (int j = 3; j <= i; j++){
			int x3 = x1 + x2;	
			x1 = x2;
			x2 = x3;
		}
		return x2;
	}

	
}

