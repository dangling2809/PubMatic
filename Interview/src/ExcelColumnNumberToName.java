
public class ExcelColumnNumberToName {

	public static void main(String[] args) {
		printColumnName(28);
		printColumnName(26);
	}
	
	public static void printColumnName(int number)
	{
		int base=26;
		String result="";
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while(number>0)
		{
			int position=number%base;
			result=(position==0?'Z':chars.charAt(position>0?position-1:0))+result;
			number=(number-1)/base;
		}
		System.out.println(result);
	}
}
