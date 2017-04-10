import java.util.Arrays;


public class SortZeroAndOne {

	 static void sort012(int a[], int arr_size)
	    {
	        int lo = 0;
	        int hi = arr_size - 1;
	        int mid = 0,temp=0;
	        while (mid <= hi)
	        {
	            switch (a[mid])
	            {
	            case 0:
	            {
	                temp   =  a[lo];
	                a[lo]  = a[mid];
	                a[mid] = temp;
	                lo++;
	                mid++;
	                break;
	            }
	            case 1:
	                mid++;
	                break;
	            case 2:
	            {
	                temp = a[mid];
	                a[mid] = a[hi];
	                a[hi] = temp;
	                hi--;
	                break;
	            }
	            }
	        }
	    }
	
	
	public void sort(int[] arr)
	{
		int left=0;
		int right=arr.length-1;
		
		while(left<right)
		{
			
			while(arr[left]==0 && left<right)
			{
				left++;
			}
			
			while(arr[right]==1 && left<right)
			{
				right--;
			}
			
			if(left<right)
			{
				arr[left]=0;
				arr[right]=1;
				left++;
				right--;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = new int[]{0, 1, 0, 1, 1, 1};
		SortZeroAndOne szao=new SortZeroAndOne();
		szao.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
