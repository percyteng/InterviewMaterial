package sort;

public class quickSort {
	public static void main (String[] args){
		int[] test = {100,2,2,39,225,77,82,81,39};

		partitionRec(test, 0, test.length-1);
		for(int i = 0; i< test.length; i++){
			System.out.println(test[i]);
		}
	}
	public static void partitionRec(int arr[], int left, int right)
	{
		if (left == right)
			return;
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      }
	      partitionRec(arr, left, i-1);
	      partitionRec(arr, i, right);
	     
	}
	public static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	public static void quickSortAlgo(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	    	  quickSortAlgo(arr, left, index - 1);
	      if (index < right)
	    	  quickSortAlgo(arr, index, right);
	}

}
