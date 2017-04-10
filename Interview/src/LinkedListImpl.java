public class LinkedListImpl {

	static Node head;
	 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
	
    /* Utility functions */
    
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    
    
    public void reverse(Node curr,Node prev)
    {
    	if(curr.next==null)
    	{
    		head=curr;
    		
    		curr.next=prev;
    		
    		return;
    	}
    	
    	Node next1=curr.next;
    	
    	curr.next=prev;
    	
    	prev=curr;
    	
    	reverse(next1,prev);
    }
    
    // Driver program to test above functions
    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        LinkedListImpl.head = new Node(50);
        LinkedListImpl.head.next = new Node(20);
        LinkedListImpl.head.next.next = new Node(15);
        LinkedListImpl.head.next.next.next = new Node(4);
        LinkedListImpl.head.next.next.next.next = new Node(10);
        list.printList(head);
        System.out.println()
        ;
        System.out.println("After reverse");
        list.reverse(head, null);
        list.printList(head);
        // Creating a loop for testing 
       // head.next.next.next.next.next = head.next.next;
       // list.detectAndRemoveLoop(head);
        //System.out.println("Linked List after removing loop : ");
        //list.printList(head);
        
        
        /*LinkedListImpl llist1= new LinkedListImpl();
        
         Constructed Linked List is 1->2->3->4->5->null 
        llist1.push(5);
        llist1.push(4);
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);
         
        System.out.println("Linked List before calling deleteAlt() ");
        llist1.printList(llist1.head);
         System.out.println("Linked List after reverse");
        llist1.reverse(llist1.head, null);
        llist1.printList(llist1.head);
        
        llist1.deleteAlt();
         
        System.out.println("Linked List after calling deleteAlt() ");
        llist1.printList(llist1.head);*/
        
    }

 // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private Node deleteAlt(){
    	Node current=head.next;
    	Node prev=head;
    	
    	while(prev!=null && current!=null){
    		prev.next=current.next;
    		current=null;
            prev = prev.next;
            if (prev != null) 
            	current = prev.next;
    	}
    	
    	return head;
    }
    
    
    private Node pairWiseSwap(Node node){
    	
    	if(node==null || node.next==null)
    		return node;
    	
    	 // Store head of list after two nodes
        Node remaing = node.next.next;
 
        // Change head
        Node newhead = node.next;
 
        // Change next of second node
        node.next.next = node;
 
        // Recur for remaining list and change next of head
        node.next = pairWiseSwap(remaing);
 
        // Return new head of modified list
        return newhead;
    	
    	
    }
    
    public Node pairWiseSwapIterative(Node node)
    {
    	// If linked list is empty or there is only one node in list
        if (node == null || node.next == null) {
            return null;
        }
 
        // Initialize previous and current pointers
        Node prev = node;
        Node curr = node.next;
 
        node = curr;  // Change head before proceeeding
 
        // Traverse the list
        while (true) {
            Node next = curr.next;
            curr.next = prev; // Change next of current as previous node
 
            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
 
            // Change next of previous to next next
            prev.next = next.next;
 
            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return node;
    }

    
    
	private void detectAndRemoveLoop(Node node) {
		 Node slow = node;
	        Node fast = node.next;
	 
	        // Search for loop using slow and fast pointers
	        while (fast != null && fast.next != null) {
	            if (slow == fast) {
	                break;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	 
	        /* If loop exists */
	        if (slow == fast) {
	            slow = node;
	            while (slow != fast.next) {
	                slow = slow.next;
	                fast = fast.next;
	            }
	 
	            /* since fast->next is the looping point */
	            fast.next = null; /* remove loop */
	 
	        }
		
	}
	
}
