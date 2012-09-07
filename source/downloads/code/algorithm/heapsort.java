/**
 * Heap sort for an array
 */
public class HeapSort
{
	public static void heapSort (int[] arr)
	{
		int i = 0;
		// Build a max heap
		for (i = arr.length / 2; i >= 0 ; i--)
		{
			filterDown(arr, i, arr.length);
		}
		//Swap the last element with the first element,
		//then bulid the max heap again
		for (i = arr.length - 1; i >= 0; i--)
		{
			swap(arr, 0, i);
			filterDown(arr, 0, i);
		}
	}

	/**
	 * Get the left child of i
	 * @param i
	 * @return
	 */
	private static int leftChild(int i)
	{
		return 2 * i + 1;
	}

	/**
	 * @param arr  The array to be heap sorted
	 * @param i    The index which is the start to be filter down
	 * @param n    The length
	 */
	private static void filterDown(int[] arr, int i, int n)
	{
		int child;
		int tmp;
		for (tmp = arr[i]; leftChild(i) < n; i = child)
		{
			child = leftChild(i);
			// the condition "child != n - 1" is important
			if (child != n - 1 && arr[child] < arr[child + 1])
			{
				child++;
			}
			if (tmp < arr[child])
			{
				arr[i] = arr[child];
			}
			else {
				break;
			}
		}
		arr[i] = tmp;
	}

	public static void swap(int[] arr, int i ,int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void display(int[] arr)
	{
		for (int i : arr)
		{
			System.out.println(i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] arr = {1 , 24, 3, 12, 15, 16, 2, 17, 16};
		heapSort(arr);
		display(arr);
	}

}