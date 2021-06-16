//////////////////////////////
//Matt Wang
//Lab 3 Sorting Algorithms
//CSC 2720 Data Structures
//Baykal
//////////////////////////////
public class MergeSort {
	static long mergeDuration = 0;

	//fill array with random integers
	public static void fillArray(int[] a) {
		for(int i = 0; i<a.length; i++) {
			a[i] = (int)(Math.random() * 100);
		}
	}

	//Print array
	public static void printArray(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	public static void merge(int[] a, int left, int mid, int right) {
		/*
		 * Step 1; Start at the beginning of the array
		 * Step 2: Find the midpoint of array
		 * Step 3: split array into two subarrays
		 * Step 4: Sort the subarrays seperately
		 * 		   Compare elements in subarray(find minimum)
		 * Step 5: merge subarrays back into original array
		 * 
		 */ 
		//Step 2
		int size1 = mid - left + 1; 
		int size2 = right - mid; 

		//Step 3
		int[] leftArray = new int [size1]; 
		int[] rightArray = new int [size2]; 

		//copying original subarrays into temp arrays
		//part of Step 3
		for (int i=0; i<size1; ++i) 
			leftArray[i] = a[left + i]; 
		for (int j=0; j<size2; ++j) 
			rightArray[j] = a[mid + 1+ j]; 


		//Step 5
		// Start points of left array and right array
		int i = 0, j = 0; 

		// Start point of merged array
		int k = left; 
		while (i < size1 && j < size2) 
		{ 
			//checks which is smaller, then uses it as beginning of merged array
			if (leftArray[i] <= rightArray[j]) 
			{ 
				a[k] = leftArray[i]; 
				i++; 
			} 
			else
			{ 
				a[k] = rightArray[j]; 
				j++; 
			} 
			k++; 
		} 
		//Copy rest of left array into merged array if needed
		while (i < size1) 
		{ 
			a[k] = leftArray[i]; 
			i++; 
			k++; 
		} 
		//Copy rest of right array into merged array if needed
		while (j < size2) 
		{ 
			a[k] = rightArray[j]; 
			j++; 
			k++; 
		} 
		//end of step 5
	}
	//Step 4
	public static void mergeSort(int[] a, int left, int right) { 
		if (left < right) 
		{ 
			// Find the middle point 
			int mid = (left+right)/2; 

			// Sort left and right subarrays
			mergeSort(a, left, mid); 
			mergeSort(a, mid+1, right); 

			// Merge the sorted subarrays 
			merge(a, left, mid, right); 
		} 
	} 

	public static void main(String[] args) {

		int[] mergeArray = new int[100];
		fillArray(mergeArray);
		System.out.print("Merge Sort: " + "\n");
		printArray(mergeArray);
		final long mergeStartTime = System.nanoTime();
		mergeSort(mergeArray, 0, mergeArray.length-1);
		mergeDuration = System.nanoTime() - mergeStartTime;
		System.out.print("\n");
		printArray(mergeArray);
		System.out.println("\n " + (mergeDuration/(1*10^9)) + " seconds");
		System.out.print("\n");
	}
}
