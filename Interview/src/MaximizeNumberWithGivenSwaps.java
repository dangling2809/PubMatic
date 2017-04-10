
public class MaximizeNumberWithGivenSwaps {

	static class Result{
		int max;
	}
	
	private static void maximize(int[] number,int numofSwaps,Result result){
		if(numofSwaps==0)
			return;
		
		for(int i=0;i<number.length;i++)
		{
			for(int j=i+1;j<number.length;j++)
			{
				if(number[i]<number[j])
				{
					swap(number,i,j);
				}
				int numberValue=convertArraytoNumber(number);
				if(result.max<numberValue)
				{
					result.max=numberValue;
				}
				maximize(number, numofSwaps-1, result);
				
				swap(number, i, j);
			}
		}
	}

	private static int convertArraytoNumber(int[] number) {
		StringBuilder buidler=new StringBuilder();
		for(int i:number)
			buidler.append(i);
		return Integer.parseInt(buidler.toString());
	}

	private static void swap(int[] number, int i, int j) {
		int temp=number[i];
		number[i]=number[j];
		number[j]=temp;
	}
	public static void main(String[] args) {
		Result r=new Result();
		maximize(new int[]{2,5,4}, 1, r);
		System.out.println("Max number"+r.max);
		
		r.max=0;
		
		maximize(new int[]{2,5,4},2,r);

		System.out.println("Max number"+r.max);
		
		String sampleString= new String ( "     Remove spaces from both sides of a string object      " );

		String resultantString = sampleString .replaceAll ("^\\s+|\\s+$","");

		System.out.println ( resultantString );
	}
}
