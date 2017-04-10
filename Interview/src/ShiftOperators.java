
public class ShiftOperators {

	public static void main(String[] args) {
		int i=8;
		System.out.println(Integer.toBinaryString(8));
		int j=i<<1;
		System.out.println("After left shift:"+Integer.toBinaryString(j));
		int k=i>>1;
		System.out.println("After right shift:"+Integer.toBinaryString(k));
		int l=i>>>1;
		System.out.println("After right shift filled with zero:"+Integer.toBinaryString(l));
				
	}
}
