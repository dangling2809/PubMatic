
public class CoinChange {

	public static void main(String[] args) {
		int coins[]={1,2,3};
		int total=4;
		int[] X=new int[total];
		for(int i=0;i<total;i++)
		{
			X[i]=i;
		}
		getChange(X, coins);
	}

	
	public static void getChange(int[] X,int[] coins)
	{
		int n=X.length; 
		int m=coins.length;
		int[][] matrix=new int[m+1][n+1];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 || j==0)
					matrix[i][j]=0;
				else if(j >=coins[i])
				{
					matrix[i][j]=Math.min(matrix[i-1][j],1+matrix[i][j-coins[i]]);
				}else{
					matrix[i][j]=matrix[i-1][j];
				}
			}
		}
		
		for(int i=0;i< matrix.length;i++)
		{
			for(int j=0;j< matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		
		
	}
}
