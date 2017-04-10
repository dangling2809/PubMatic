import java.util.LinkedHashMap;


public class LRUCache extends LinkedHashMap<String, String>{

	private final int capacity=4;

	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<String, String> eldest) {
		 return size() > this.capacity;
	}
	
	public static void main(String[] args) {
		
	}
}
