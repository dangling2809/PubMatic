import java.util.Stack;


interface Queue{
	public void add(int i);
	public int remove();
}


class QueueImplUsingArray implements Queue{
	
	private int front;
	private int rear;
	private int length;
	private int capacity;
	
	private int[] queue=null;
	

	public QueueImplUsingArray(int capacity) {
		super();
		this.front=-1;
		this.rear=-1;
		this.capacity = capacity;
		this.queue=new int[capacity];
	}

	@Override
	public void add(int i) {
		if(capacity>=length)
		{
			System.out.println("Overflow");
		}else{
			if(rear==-1)
			{
				queue[0]=i;
				front=0;
				rear=0;
			}else{
				queue[rear++]=i;
			}
			length++;
		}
	}

	@Override
	public int remove() {
		int returnValue=queue[front];
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}else
		{
			front++;
		}
		length--;
		return returnValue;
	}
}


class QueueImplUsingTwoStacks implements Queue {

	private Stack<Integer> inbox=new Stack<Integer>();
	private Stack<Integer> outbox=new Stack<Integer>();
	
	@Override
	public void add(int i) {
		inbox.add(i);
	}

	@Override
	public int remove() {
		if(outbox.isEmpty())
		{
			for(int i=0;i<inbox.size();i++)
			{
				outbox.add(inbox.pop());
			}
		}
		return outbox.pop();
	}
	
}


public class QueueImpl{
	public static void main(String[] args) {
		Queue q=new QueueImplUsingTwoStacks();
		for(int i=0;i<5;i++)
			q.add(i);
		System.out.println(q.remove());
		q.add(6);
		System.out.println(q.remove());
		
	}
}