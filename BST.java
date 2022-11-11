public class BST<Value, Key extends Comparable<Key>> {
	Node root;
	
	public Node put(Key K, Value V) {
		return put(root, K, V);
	}
	
	private Node put(Node n, Key K, Value V) {
		if(n == null) return new Node(V, K);
		int comp = K.compareTo(n.K);
		if(comp > 0) n.right = put(n.right, K, V);
		else if(comp < 0) n.left = put(n.left, K, V);
		else n.V = V; 
	}
	
	public Value get(Key k) {
		return get(root, k);
	}
	
	private Value get(Node n, Key k) {
		if(n==null) return null;
		int comp = k.compareTo(n.K);
		if(comp > 0) return get(n.right, k);
		else if(comp < 0) return get(n.left, k);
		else return n.V;
	}
	
	public Node floor(Key K) {
		return floor(root, K);
	}
	
	private Node floor(Node n, Key K) {
		if(n==null) return null;
		int comp = K.compareTo(n.K);
		if(comp == 0) return n;
		else if(comp < 0) return floor(n.left, K);
		else { 
			Node t = floor(n.right, K);
			if(t != null) return t;
			else return n;
		}
	}
	
	public Node ceiling(Key K) {
		return ceiling(root, K);
	}
	
	private Node ceiling(Node n, Key K) {
		if(n==null) return null;
		int comp = K.compareTo(n.K);
		if(comp==0) return n;
		else if(comp > 0) return ceiling(n.right, K);
		else {
			Node t = ceiling(n.left, K);
			if(t != null) return t;
			else return n;
		}
	}
	
	public Key select(int i) {
		return select(root, i);
	}
	
	private Key select(Node n, int i) {
		if(n==null) return null;
		int s = size(n.left);
		if(s>i) return select(n.left, i);
		else if(s<i) return select(n.right, (i-(size(n.left)+1)));
		else return n.K;
	}
	
	class Node {
		Key K;
		Value V;
		Node right, left;
		int size = 0;
		
		public Node(Value V, Key K) {
			K = this.K;
			V = this.V; 
		}
		
		public int size(Node n) {
			return n.size;
		}
	}
}
