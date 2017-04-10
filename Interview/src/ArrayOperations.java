import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ArrayOperations {
	
	public static void main(String[] args) {
		
		int[] arr=new int[10];
		System.out.println(arr.length);
		//int arr[]={1,2,3,4,5,6,7};
		//remove(arr,3);
		//int arr1[] = {10, 2, -2, -20, 10};
		//findSubArrayWithGivenSumWithNegatives(arr1, -10);
		//int arr2[] = {1, 4, 20, 3, 10, 5};
		//findSubArrayWithGivenSumWithNegatives(arr2, 33);
		//int arr3[]={1,1,5,5,7,4,4,3,3,2,2};
		//System.out.println(findNonRepeated(arr3));
		
		
		int arr4[]={65,32,43,20,11,2,5,6,3,2,50,17};
	//	System.out.println(Arrays.toString(mergeSort(arr4)));
		
		int wave[]={10, 90, 49, 2, 1, 5, 23};
		//sortInWave(wave);
		
		int arr5[] = {12, 13, 1, 10, 34, 1};
	     findSecondMimimum(arr5);
	}

	private static void sortInWave(int[] arr)
	{
		int i=0;
		while((i<arr.length) && (i+2<arr.length))
		{
			if(i>0 && arr[i]<arr[i+2])
				swap(arr,i,i+2);
			
			if(i<arr.length && arr[i]<arr[i+1])
				swap(arr,i,i+1);
			
			i+=2;
		}
		System.out.println("After wave sort"+Arrays.toString(arr));
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

	private static void findSecondMimimum(int[] arr)
	{
		int firstMin=Integer.MAX_VALUE;
		int secondMin=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<firstMin)
			{
				secondMin=firstMin;
				firstMin=arr[i];
				
			}
			if((arr[i]<secondMin) && (arr[i]!=firstMin))
			{
				secondMin=arr[i];
			}
		}
		System.out.println(firstMin);
		System.out.println("Second min"+secondMin);
	}
	
	private static int findNonRepeated(int[] arr)
	{
		int result=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			result=result^arr[i];
		}
		return result;
	}
	
	private static void findSubArrayWithGivenSum(int[] arr,int sum)
	{
		
		int current_sum=arr[0];
		int start=0;
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			while(current_sum>sum && start < (i-1))
			{
				current_sum=current_sum-arr[start];
				start++;
			}
			
			if(current_sum==sum)
			{
				System.out.println("Start index"+start+"To Index"+(i-1));
			}
			
			if(i<n)
				current_sum+=arr[i];
		}
	}
	
	
	private static void findSubArrayWithGivenSumWithNegatives(int[] arr,int sum)
	{
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		int current_sum=0;
		int start=0;
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			current_sum+=arr[i];
			if(current_sum==sum)
			{
				System.out.println("Sum found between Start "+ 0 +" End "+ i);
			}
			
			if(map.containsKey(current_sum-sum))
			{
				System.out.println("Sum found between Start Index:"+map.get(current_sum-sum)+1+" and End"+i);
			}
			
			map.put((current_sum-sum),i);
		}
	}
	
	
	public static int[] merger(int[] a,int[] b)
	{
		int []result=new int[a.length+b.length];
		int i=0,j=0,k=0;
		
		while(i<a.length && j<b.length)
		{
			if(a[i]<=a[j])
			{
				a[k]=a[i];
				k++;
				i++;
			}else{
				a[k]=a[j];
				k++;
				j++;
			}
		}
		
		while(i<a.length && k<result.length)
		{
			a[k]=a[i];
			i++;
			k++;
		}
		
		while(j< b.length && k<result.length)
		{
			a[k]=a[j];
			j++;
			k++;
		}
		return result;
	}
	
	/*public static int[] merge(int[] a, int[] b) {

	    int[] answer = new int[a.length + b.length];
	    int i = 0, j = 0, k = 0;

	    while (i < a.length && j < b.length)  
	       answer[k++] = a[i] < b[j] ? a[i++] :  b[j++];

	    while (i < a.length)  
	        answer[k++] = a[i++];


	    while (j < b.length)    
	        answer[k++] = b[j++];

	    return answer;
	}*/
	
	public static int[] mergeSort(int A[])
	{
		if(A.length<=1)
		{
			return A;
		}
		int mid=A.length/2;
		int[] left=new int[mid];
		int []right;
		
		if(A.length%2==0)
		{
			right=new int[mid];
		}else{
			right=new int[mid+1];
		}
		
		for(int i=0;i<mid;i++)
		{
			left[i]=A[i];
		}
		int x=0;
		for(int j=mid;j<A.length;j++)
		{
			if(x<right.length)
			{
				right[x]=A[j];
				x++;
			}
		}
				
		left=mergeSort(left);
		right=mergeSort(right);
		int[] result=merger(left, right);
		return result;
	}
	
	private static void remove(int[] arr,int index) {
		int numToCopy=arr.length-index-1;
		System.out.println(arr.length);
		System.out.println(numToCopy);
		System.arraycopy(arr, index+1, arr, index, numToCopy);
		System.out.println(Arrays.toString(arr));
	}
	
	private int searchInSoretedRoatatedArray(int[] arr,int l,int h,int key)
	{
		if (l > h) return -1;
		 
	    int mid = (l+h)/2;
	    if (arr[mid] == key) return mid;
	 
	    /* If arr[l...mid] is sorted */
	    if (arr[l] <= arr[mid])
	    {
	        /* As this subarray is sorted, we can quickly
	           check if key lies in half or other half */
	        if (key >= arr[l] && key <= arr[mid])
	           return searchInSoretedRoatatedArray(arr, l, mid-1, key);
	 
	        return searchInSoretedRoatatedArray(arr, mid+1, h, key);
	    }
	 
	    /* If arr[l..mid] is not sorted, then arr[mid... r]
	       must be sorted*/
	    if (key >= arr[mid] && key <= arr[h])
	        return searchInSoretedRoatatedArray(arr, mid+1, h, key);
	 
	    return searchInSoretedRoatatedArray(arr, l, mid-1, key);
	}
	/**
	 * {3, 4, 5, 6, 1, 2}
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int findPivotInSortedRoatatedArray(int[] arr,int low,int high)
	{
	    int mid=(low+high)/2;
	    if (high < low)  return -1;
	    if (high == low) return low;
	    if(mid<high && arr[mid]>arr[mid+1])
	    	return mid;
	    if(mid>low && arr[mid]<arr[mid-1])
	    	return mid-1;
	    if (arr[low] >= arr[mid])
	        return findPivotInSortedRoatatedArray(arr, low, mid-1);
	    return findPivotInSortedRoatatedArray(arr, mid + 1, high);
	}
}
