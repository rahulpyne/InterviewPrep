package sortingGFG;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {3,5,2,6,1,7,4};
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, arr.length-1);
		for(int i = 0; i<arr.length;i++){
			System.out.print(arr[i]);
		}

	}
	
	// Time complexity is O(nlogn)
	public void mergeSort(int arr[], int start, int last){
		if(start<last){
			int mid = (start+last)/2;
			mergeSort(arr,start, mid);
			mergeSort(arr,mid+1,last);
			merge(arr,start,mid,last);
		}
	}
	
	
	public void merge(int[] arr, int start, int mid, int last){
		int size1 = mid-start+1;
		int size2 = last-mid;
		int[] left = new int[size1];
		int[] right = new int[size2];
		
		// initializing the counters for both the arrays as 0
		for(int i=0; i< size1; i++){
			left[i] = arr[start+i];
		}
		for(int j=0;j<size2;j++){
			right[j] = arr[mid+1+j];
		}
		
		int i = 0;
		int j = 0;
		int k = start;		
		while(i<size1 && j<size2){
			if(left[i]<right[j]){
				arr[k] = left[i];
				i++;
				k++;
			}
			else{
				arr[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i<size1){
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<size2){
			arr[k] = right[j];
			j++;
			k++;
		}		
		
	}

}
