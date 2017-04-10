
public class MaxDiffTwoElements {
	
	class Interval{
		
		int buy;
		int sell;
	}
	
	public int find_max_diff(int[] arr)
	{
		Interval interval=new Interval();
		int max_diff=arr[1]-arr[0];
		int min_element=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(max_diff<(arr[i]-min_element))
			{
				max_diff=arr[i]-min_element;
				interval.sell=i;
			}
			if(arr[i]<min_element)
			{
				min_element=arr[i];
				interval.buy=i;
			}
		}
		System.out.println("Buy on day"+(interval.buy+1));
		System.out.println("Sell on day"+(interval.sell+1));
		return max_diff;
	}
	
	public static void main(String[] args) {
		MaxDiffTwoElements maxdif = new MaxDiffTwoElements();
	        int arr[] = {1, 2, 90, 10, 110};
	        int size = arr.length;
	        System.out.println("MaximumDifference is " + 
	                                maxdif.find_max_diff(arr));
	}

	
}
