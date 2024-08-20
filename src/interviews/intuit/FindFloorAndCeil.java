package interviews.intuit;

public class FindFloorAndCeil {
	public static void main(String args[]) {
		FindFloorAndCeil obj = new FindFloorAndCeil();
		int arr[] = { 5, 6, 8, 9, 6, 5, 5, 6 };
		int x = 7;
		obj.floorAndCeil(arr, x);
	}

	private void floorAndCeil(int arr[], int x) {
		// indices of floor and ceiling
		int floorIndex = -1;
		int ceilIndex = -1;

		// Differences from x for closest floor and ceiling
		int floorDiff = Integer.MAX_VALUE, ceilDiff = Integer.MAX_VALUE;
		 
		for (int i = 0; i<arr.length;i++) { 
			int cur = arr[i];
			
			//ceil candidate
			if (cur > x && ceilDiff > cur-x) {
				ceilIndex = i;
				ceilDiff = cur-x;
			}
			
			//floor candidate
			if (cur < x && floorDiff > x-cur) {
				floorIndex = i;
				floorDiff = x-cur;
			}
		}
		
		if (ceilDiff != Integer.MAX_VALUE)
			System.out.println("ceil:"+arr[ceilIndex]);
		if (floorDiff != Integer.MAX_VALUE)
			System.out.println("floor:"+arr[floorIndex]);
	}

}
