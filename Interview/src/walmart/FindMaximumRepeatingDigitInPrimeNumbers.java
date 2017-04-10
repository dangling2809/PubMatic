package walmart;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumRepeatingDigitInPrimeNumbers {

	// Sieve of Eratosthenes
	void sieve(boolean prime[], int n)
	{
	    for (int p = 2; p * p  <= n; p++)
	    {
	        if (prime[p] == false)
	            for (int i = p*2; i <= n; i+=p)
	                prime[i] = true;
	    }
	}
	
	public void maxrepeatingDigit(int L,int R)
	{
		boolean prime[]=new boolean[R+1];
		int maxKey=0;
		
		sieve(prime, R);
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=L;i<R;i++)
		{
			if(!prime[i])
			{
				int number=i;
			
				while(number>0)
				{
					int digit=number%10;
					if(map.containsKey(digit))
					{
						map.put(digit, map.get(digit)+1);
					}else{
						map.put(digit, 1);
					}
					
					number=number/10;
			}
		}
		
			//find number from map with highest 
		int max=0;
		
			
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			int key=entry.getKey();
			int value=entry.getValue();
			
			if(max<value)
			{
				max=value;
				maxKey=key;
				
				if(maxKey<key){
					maxKey=key;
				}
			}
		}
	
	}
		System.out.println("maximum repeating digit"+maxKey);
	}
	
	public static void main(String[] args) {
		FindMaximumRepeatingDigitInPrimeNumbers o=new FindMaximumRepeatingDigitInPrimeNumbers();
		o.maxrepeatingDigit(1, 20);
	}
	
}
