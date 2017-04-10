import java.util.Arrays;


public class QuickSort {

	public void quickSort(int[] arr,int low,int high)
	{
		int mid=(low+high)/2;
		int i=low;
		int j=high;
		while(i<=j)
		{
			while(arr[i]<arr[mid])
				i++;
			while(arr[j]>arr[mid])
				j--;
			if(i<=j)
			{
				swap(arr,i,j);
				i++;
				j--;
			}
			if(low<j)
				quickSort(arr,low,j);
			if(i<high)
				quickSort(arr, i, high);
		}
	}

	private void swap(int[] arr, int low, int high) {
		int temp=arr[low];
		arr[low]=arr[high];
		arr[high]=temp;
	}
	
	public static void main(String[] args) {
		int arr[]={12,37,4,3,6,1,2,25,45,21,19,17};
		QuickSort sort=new QuickSort();
		System.out.println(Arrays.toString(arr));
		sort.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
