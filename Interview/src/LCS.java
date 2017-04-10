import java.util.Arrays;


public class LCS {

	public void printLCS(char[] X,char[] Y)
	{
		
		int m=X.length; int n=Y.length;
		int[][] L=new int[m+1][n+1];
		
		for (int i=0; i<=m; i++)
		   {
		     for (int j=0; j<=n; j++)
		     {
		       if (i == 0 || j == 0)
		         L[i][j] = 0;
		       else if (X[i-1] == Y[j-1])
		         L[i][j] = L[i-1][j-1] + 1;
		       else
		         L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
		     }
		   }
		 
		for(int i=0;i< L.length;i++)
		{
			for(int j=0;j< L[i].length;j++)
			{
				System.out.print(L[i][j]+" ");
			}
			System.out.println("");
		}
		
		int index=L[m][n];
		char[] lcs=new char[index];
		int i = m, j = n;
		   while (i > 0 && j > 0)
		   {
		      // If current character in X[] and Y are same, then
		      // current character is part of LCS
		      if (X[i-1] == Y[j-1])
		      {
		          lcs[index-1] = X[i-1]; // Put current character in result
		          i--; j--; index--;     // reduce values of i, j and index
		      }
		 
		      // If not same, then find the larger of two and
		      // go in the direction of larger value
		      else if (L[i-1][j] > L[i][j-1])
		         i--;
		      else
		         j--;
		   }
		System.out.println("LCS "+Arrays.toString(lcs));
		
	}
	
	public static void main(String[] args) {
		LCS lcs=new LCS();
		char[] x="AGGTAB".toCharArray();
		char[] y="GXTXAYB".toCharArray();
		if(x.length>0 && y.length>0)
			lcs.printLCS(x, y);
	}
	
}
