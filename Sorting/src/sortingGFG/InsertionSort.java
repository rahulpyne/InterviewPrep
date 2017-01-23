package sortingGFG;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {3,5,2,6,1,7,4};
		InsertionSort is = new InsertionSort();
		arr = is.insertionSort(arr);
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
	// Time complexity is  O(n^2) because there is one loop inside another one which is running till n
	public int[] insertionSort(int[] arr){
		int j = 1;
		while(j<arr.length){
			int key = arr[j];
			int i = j-1;
			while(i>=0 && arr[i]>key){
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
			j++;
		}
		return arr;
	}

}
