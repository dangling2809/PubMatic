import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringOperations {

	
	public static void main(String[] args) {
		String s="ABC";
		System.out.println(reverse(s));
		permutation("", s);
	}
	
	
	 public String trim(String value) {
	        int len = value.length();
	        int st = 0;
	        char[] val = value.toCharArray();   
	        while ((st < len) && (val[st] <= ' ')) {
	            st++;
	        }
	        while ((st < len) && (val[len - 1] <= ' ')) {
	            len--;
	        }
	        return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
	    }
	
	public static String reverse(String s)
	{
		if ((s==null) || (s.length() <= 1) )
            return s;
		return reverse(s.substring(1))+s.charAt(0);
	}
	//abc
	//bac
	//cba
	//bca
	//acb
	//cab
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	/*private static void permute(char[] arr,int i)
	{
		if((i==arr.length-1))
		{
			return;
		}
		
		for(int j=i;j<arr.length-1;j++)
		{
			char tmp=arr[j];
			arr[j]=arr[j+1];
			arr[j+1]=tmp;
			permute(arr, i+1);
			tmp=arr[j];
			arr[j]=arr[j+1];
			arr[j+1]=tmp;
		}
	}*/
	
}

