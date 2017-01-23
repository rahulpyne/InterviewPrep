package sortingGFG;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSortNonOpt(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		bs.bubbleSortOpt(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// Worst and Average case Time Complexity is O(n^2)
	public void bubbleSortNonOpt(int[] arr){
		int n = arr.length;
		for(int j = 0; j<n-1; j++){
			for(int i =0; i<n-1-j; i++){
				if(arr[i]>arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}			
		}
	}
	
	// Optimizing the bubble sort by breaking the loops
	// if there is no swap detected in the inner loop, i.e. the array is sorted.
	public void bubbleSortOpt(int[] arr){
		int n = arr.length;
		boolean swap = false;
		for(int j = 0; j<n-1; j++){
			swap  = false;
			for(int i =0; i<n-1-j; i++){
				if(arr[i]>arr[i+1]){
					swap = true;
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			if(!swap){
				break;
			}
		}
	}

}
