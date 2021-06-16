public class BubbleSort {
	static long bubbleDuration;
	
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
	
	public static void bubbleSort(int[] a) {
		/*
		 * Step 1; Start at the beginning of the array
		 * Step 2: compare element(j) with element plus one(j+1) (find minimum)
		 * Step 3: if element plus one(j+1) is larger than element(j), switch the two
		 * Step 4: otherwise, continue comparing until end of array
		 * Step 5: repeat process until sorted
		 * 
		 */ 
		//Step 1
		for (int i = 0; i < a.length-1; i++) { //Step 5
			for (int j = 0; j < a.length-i-1; j++) { //Step 4
				//Step 2
				if (a[j] > a[j+1]) 
				{ 
					//Step 3 
					int temp = a[j]; 
					a[j] = a[j+1]; 
					a[j+1] = temp; 
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] bubbleArray = new int[100];
		fillArray(bubbleArray);
		System.out.print("Bubble Sort: " + "\n");
		printArray(bubbleArray);
		final long bubbleStartTime = System.nanoTime();
		bubbleSort(bubbleArray);
		bubbleDuration = System.nanoTime() - bubbleStartTime;
		System.out.print("\n");
		printArray(bubbleArray);
		System.out.println("\n " + (bubbleDuration/(1*10^9)) + " seconds");
		System.out.print("\n");
	}
}
