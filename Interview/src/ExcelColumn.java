
public final class ExcelColumn {

    private ExcelColumn() {}

    public static int toNumber(String name) {
        int number = 0;
        for (int i = 0; i < name.length(); i++) {
            number = number * 26 + (name.charAt(i) - ('A' - 1));
        }
        return number;
    }

    public static String toName(int number) {
        StringBuilder sb = new StringBuilder();
        while (number-- > 0) {
            sb.append((char)('A' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
		System.out.println(ExcelColumn.toName(26));
		System.out.println(ExcelColumn.toNumber("AA"));
	}
}