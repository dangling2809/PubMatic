import java.util.Arrays;


public class Heap {

	public void buildMaxHeap(int arr[],int i, int length)
	{
		int l=2*i+1;
		int r=2*i+2;
		int size=length-1;
	    int max=i;
	    if(l<=size && arr[l]>arr[i])
	    	max=l;
		if(r<=size && arr[r]>arr[max])
			max=r;
		if(max!=i)
		{
	       swap(arr,i,max);
	       buildMaxHeap(arr, max,length);
		}
	}
	
	// to heapify a subtree with root at given index
		void MaxHeapify(int arr[], int i, int n)
		{
		    int l = 2*i + 1;
		    int r = 2*i + 2;
		    int largest = i;
		    if (l < n && arr[l] > arr[i])
		        largest = l;
		    if (r < n && arr[r] > arr[largest])
		        largest = r;
		    if (largest != i)
		    {
		        swap(arr,i, largest);
		        MaxHeapify(arr, largest, n);
		    }
		}

	private void maxHeapify(int[] arr, int length) {
		for(int i=((int) Math.floor(length/2))-1;i>=0;i--)
			buildMaxHeap(arr, i, length);
	}
	
	private void swap(int arr[],int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


	public void minHeapify(int arr[])
	{
		for(int i=((int) Math.floor(arr.length/2))-1;i>=0;i--)
			buildMinHeap(arr,i);
	}
	
	private void buildMinHeap(int[] arr, int i) {
		int l=2*i+1;
		int r=2*i+2;
		int min=i;
		int size=arr.length-1;
		if(l<=size && arr[l]<arr[i])
			min=l;
	    if(r<=size && arr[r]<arr[min])
		    min=r;
	    
	    if(min!=i)
	    {
	    	swap(arr,i,min);
	    	buildMinHeap(arr, min);
	    }
	}

	public static void main(String[] args) {
		int arr[]={3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		System.out.println("Array"+Arrays.toString(arr));
		Heap heap=new Heap();
		heap.maxHeapify(arr,arr.length);
		//System.out.println("Max heap"+Arrays.toString(arr));
		//heap.convertMaxHeap(arr, arr.length);
		//System.out.println("Max heap"+Arrays.toString(arr));
		
		
		int[] sorted=heap.heapsort(arr);
		System.out.println("Sorted "+Arrays.toString(sorted));
		heap.minHeapify(arr);
		System.out.println("Min heap"+Arrays.toString(arr));
	}

	
	 
	private  int[] heapsort(int[] arr) {
		int[] sortedArr=new int[arr.length];
		int count=0;
		int size=arr.length-1;
		while(size>=1)
		{
			sortedArr[count++]=arr[0];
			swap(arr, 0, size);
			System.out.println("After swap-->"+Arrays.toString(arr));
			size=size-1;
			buildMaxHeap(arr,0,size);
			System.out.println("After build heap-->"+Arrays.toString(arr));
		}
		return arr;
	}

	// This function basically builds max heap
	void convertMaxHeap(int arr[], int n)
	{
	    // Start from bottommost and rightmost
	    // internal mode and heapify all internal
	    // modes in bottom up way
	    for (int i = (n-2)/2; i >= 0; --i)
	        MaxHeapify(arr, i, n);
	}

}
