
public class ClassInitializationOrder {
	public static void main(String[] args) {
		Parent parent=new Child();
	}
}


class Parent {
	private static String STATIC_FIELD="parentStaticField";
	String NON_STATIC_FIELD="parentNonStaticField";
	static {
		System.out.println("Static block of parent"+STATIC_FIELD);
	};
	{
		System.out.println("Non static block of parent"+STATIC_FIELD+"--"+NON_STATIC_FIELD);
	}
	public Parent()
	{
		System.out.println("Constructor of parent"+NON_STATIC_FIELD);
	}
}

class Child extends Parent{
	
	static {
		System.out.println("Static block of child");
	};
	{
		System.out.println("Non static block of child"+NON_STATIC_FIELD+"--"+NON_STATIC_FIELD);
	}
	public Child()
	{
		System.out.println("Constructor of child"+NON_STATIC_FIELD);
	}
}

