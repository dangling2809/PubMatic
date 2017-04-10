import java.util.HashMap;
import java.util.Random;

interface ILRUCache<K,V>{
	
	void add(K k,V v);
	
	V get(K k);
}


public class LRUCacheWithoutLinkedhashmap<K,V> implements ILRUCache<K,V> {

	class Node{
		Node next;
		Node previous;
		V value;
		K key;
		public Node( K key,V value) {
			super();
			this.value = value;
			this.key = key;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", key=" + key + "]";
		}
		
	}
	
	private HashMap<K,Node> map=new HashMap<>();
	
	private Node head;
	
	private Node tail;
	
	private int capacity;
	
	public LRUCacheWithoutLinkedhashmap(int capacity) {
		super();
		this.capacity = capacity;
	}

	public void removeNode(Node node)
	{
		if(node.previous!=null)
		{
			node.previous.next=node.next;
		}else{
			head=node.next;
		}
		if(node.next!=null)
		{
			node.next.previous=node.previous;
		}else{
			tail=node.previous;
		}
		
	}
	
	public void setHead(Node node)
	{
		node.next=head;
		node.previous=null;
		if(head!=null)
			head.previous=node;
		if(tail==null)
			tail=head;
		head=node;
	}
	
	@Override
	public void add(K k, V v) {
		if(map.containsKey(k))
		{
			Node old=map.get(k);
			old.value=v;
			removeNode(old);
			setHead(old);
		}else{
			Node newNode=new Node(k, v);
			if(map.size()>=capacity)
			{
				Node removing=map.remove(tail.key);
				System.out.println("Removing LRU node"+removing);
				removeNode(tail);
				setHead(newNode);
			}else{
				setHead(newNode);
			}
			map.put(k, newNode);
		}
	}
	

	@Override
	public V get(K k) {
		V value=null;
		if(map.containsKey(k))
		{
			Node accessed=map.get(k);
			value=accessed.value;
			removeNode(accessed);
			setHead(accessed);
		}
		return value;
	}
	
	public static void main(String[] args) {
		ILRUCache<Integer, Integer> cache=new LRUCacheWithoutLinkedhashmap<Integer, Integer>(4);
		Random random=new Random();
		cache.add(1, random.nextInt());
		cache.add(2, random.nextInt());
		cache.add(3, random.nextInt());
		
		cache.get(1);
		
		cache.add(4, random.nextInt());
		cache.add(5, random.nextInt());
		
		cache.get(4);
		
		cache.add(3, random.nextInt());
	}
}
