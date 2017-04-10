import java.util.Stack;


public class BinaryTree {

	public Node root;
	
	public static boolean b1=false,b2=false;
	
	public Node findLCA(Node root,int x1,int x2)
	{
		if(root==null)
			return null;
		if(root.data==x1 || root.data==x2)
		{
			return root;
		}
		Node left_lca=findLCA(root.left, x1, x2);
		Node right_lca=findLCA(root.right, x1, x2);
		if(left_lca!=null && right_lca!=null)
			return root;
		return left_lca!=null?left_lca:right_lca;
	}
	
	
	public Node findLCA1(Node root,int x1,int x2)
	{
		if(root==null)
			return null;
		
		if(root.data==x1)
		{
			b1=true;
			return root;
		}
		if(root.data==x2)
		{
			b2=true;
			return root;
		}
		
		Node left_lca=findLCA1(root.left, x1, x2);
		Node right_lca=findLCA1(root.right, x1, x2);
        if (left_lca != null && right_lca != null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
	}
	
	private Node findLCA(int i, int j) {
		// TODO Auto-generated method stub
		b1=false;b2=false;
		
		Node lca= findLCA1(root, i, j);
		
		if(b1&&b2)
			return lca;
		else
			return null;
	}
	
	private void printSpiral(){
		
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
		
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		
		s1.push(tree.root);
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.empty())
			{
				Node node=s1.pop();
				System.out.println("--"+node.data);
				if(node.right!=null)
					s2.push(node.right);
				if(node.left!=null)
					s2.push(node.left);
			}
			while(!s2.empty())
			{
				Node node=s2.pop();
				System.out.println("--"+node.data);
				
				if(node.left!=null){
					s1.push(node.left);
				}
				if(node.right!=null)
				{
					s1.push(node.right);
				}	
			}
			}
		}
	
 	
	
	public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
		/**        20
		 * 		/      \
		 *     8        22
		 *     /\		/	\
		 *	4	12		10  14
		 *
		 *
		 *
		 */
		
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        
        tree.printSpiral();
  
    }
	
	private Node lca(Node node, int n1, int n2) {
		 if (node == null)
	            return null;
	  
	       
	        if (node.data > n1 && node.data > n2)
	            return lca(node.left, n1, n2);
	  
	       
	        if (node.data < n1 && node.data < n2) 
	            return lca(node.right, n1, n2);
	  
	        return node;
	}

	
	public boolean isBST(Node node,int min,int max)
	{
		if(node==null)
			return true;
		
		if(node.data>min || node.data<max)
			return false;
		
		return (isBST(node.left, min, node.data-1) && isBST(node, node.data+1, max));
	}
	
	public void preorder(Node node)
	{
		if (node == null)
            return;
		System.out.println(node.data);
		preorder(root.left);
		preorder(root.right);
	}

	public static void main1(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");
 
        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
	}
}


class Node{
	
	public int data;
	
	public Node left;
	
	public Node right;

	public Node(int data) {
		super();
		this.data = data;
	}
}