
public class Fibonaaci {

	static int n1=0, n2=1,n3;
	
	public static void main(String[] args) {
		System.out.print(0 +" ");
		System.out.print(1 +" ");
		finbonacci(8);
	}
	
	//1 1 2 3 5 8
	public static void finbonacci(int n)
	{
		while(n>0)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+" ");
			n--;
		}
	}
	
	public static void printGivenFibonacciNumber()
	{
		
	}
}
