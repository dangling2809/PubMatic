import java.util.PriorityQueue;


public class Matrix {

	
	public void findKthLargest(int[][] matrix,int m,int n,int k)
	{
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				priorityQueue.add(matrix[i][j]);
			}
		}
		
		for(int i=0;i<k;i++)
		{
			priorityQueue.poll();
		}
		
		System.out.println("Kth largest element"+priorityQueue.poll());
	}
	
	public void binarySearch(int[] arr,int start,int end,int n)
	{
		int mid=(end+start)/2;
		
		if(arr[mid]==n)
		{
			System.out.println("Element found at"+mid);
			return;
		}else if(arr[mid]>n)
		{
			start=0;
			end=mid-1;
			binarySearch(arr,start, end, n);	
		}else{
			binarySearch(arr, mid+1,arr.length-1 , n);
		}
		
	}
	
	public void binarySearchMatrix(int[][] matrix,int i,int j,int k,int l,int key)
	{
		int midx=i+(j-i)/2;
		int midy=k+(l-k)/2;
		if(matrix[midx][midy]==key)
		{
			
		}else if(matrix[midx][midy]<key)
		{
			
		}else{
			
		}
	}
	
	public static void main(String[] args) 
	{
		int arr[]={1,2,3,4,5,6,7,8,9};
		Matrix m=new Matrix();
		m.binarySearch(arr, 0, arr.length-1, 8);
	}
}
