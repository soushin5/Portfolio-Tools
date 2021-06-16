public class SelectionSort {
	static long selectionDuration;
	
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
		
		public static void selectionSort(int[] a) {
			/*
			 * Step 1: Start at beginning of array
			 * Step 2: compare the first element(i) of the 
			 * 		   array with the rest of the array(find minimum element)
			 * Step 3: move the minimum element to the first 
			 * 	 	   position if needed, if not move to step 5
			 * Step 4: add 1 to the first element(i) and compare with the rest of the array
			 * Step 5: repeat steps 2 - 4
			 * Step 6: Stop when no longer able to add 1 to first element(i)
			 */
			//Step 1 
			for (int i = 0; i < a.length-1; i++){ //also Step 4
				//keeps track of sorted array

				int min= i; 
				for (int j = i+1; j < a.length; j++) { 
					//runs through unsorted array 

					//Step 2
					if (a[j] < a[min]) {
						min = j; 
					}

					//Step 3
					int temp = a[min]; 
					a[min] = a[i]; 
					a[i] = temp; 
					//Step 5
				}
				//Step 6
			}
		}
		
		public static void main(String[] args) {

			int[] selectionArray = new int[100];
			fillArray(selectionArray);
			System.out.print("Selection Sort: " + "\n");
			printArray(selectionArray);
			final long selectionStartTime = System.nanoTime();
			selectionSort(selectionArray);
			selectionDuration = System.nanoTime() - selectionStartTime;
			System.out.print("\n");
			printArray(selectionArray);
			System.out.println("\n " + (selectionDuration/(1*10^9)) + " seconds");
			System.out.print("\n");
		}

}
