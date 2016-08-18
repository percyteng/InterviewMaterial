package sort;

public class mergeSort {
    private int[] array;
    private int[] tempMergArr;
    private int length;
	public static void main (String[] args){
		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        mergeSort mms = new mergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
		int[] test2 = {100,2,2,39,225,77,82,81,39};

		quickSort(test2, 0, test2.length-1);
		for(int i = 0; i< test2.length; i++){
			System.out.println(test2[i]);
		}
	}
	public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
    	if (lowerIndex == higherIndex)
    		return;
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
	public static void quickSort(int[] arr, int low, int high){
		int i = low;
		int j = high;
		int pivot = arr[(low + high)/2];
		if (low == high)
			return;
		while (low <= high){
			while (arr[low] < pivot){
				low ++;
			}
			while (arr[high] > pivot)
				high--;
			if (low <= high){
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
				low ++;
				high --;
			}
		}
		quickSort(arr, i, low-1);
		quickSort(arr, low, j);
	}
}
