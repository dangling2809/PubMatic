import java.util.ArrayList;
import java.util.List;


public class Stack<T> {
	
	private List<T> stack=null;
	
	public Stack(int size)
	{
		stack=new ArrayList<>(size);
	}
	
	public void push(T t)
	{
		System.out.println("Pushed" + t);
		stack.add(t);
	}

	public T pop()
	{
		if(stack.isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}else
		{
			System.out.println("Popped" + stack.get(stack.size()-1));
			return stack.remove(stack.size()-1);
		}	
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack=new Stack<Integer>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.pop();
		stack.pop();
		
		
	}
}
