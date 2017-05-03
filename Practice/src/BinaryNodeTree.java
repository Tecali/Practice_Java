
/* package whatever; // don't place package name! */

/* 

    1
  2   3
 6   4 5
    
[[1], [2,3], [6,4,5]]

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryNodeTree {
	private static Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

	// Depth First Approach
	public static Map<Integer, List<Integer>> getIntsInDepth(Node root, int h) {
		List<Integer> listNodes = new ArrayList<Integer>();
		if (root != null && result.size() == 0) {
			listNodes.add(root.getData());
			result.put(h, listNodes);
			h++;
		}
		listNodes = result.get(h) != null ? result.get(h) : new ArrayList();
		if (root.getLeft() != null) {
			listNodes.add(root.getLeft().getData());
		}
		if (root.getRight() != null) {
			listNodes.add(root.getRight().getData());
		}
		result.put(h, listNodes);
		if (root.getLeft() != null) {
			getIntsInDepth(root.getLeft(), h + 1);
		}
		if (root.getRight() != null) {
			getIntsInDepth(root.getRight(), h + 1);

		}
		return result;
	}

	// Breadth First Approach
//	public Map<Integer, List<Integer>> getValsInzHeight() {
//		List<Integer> listNodes = new ArrayList<Integer>();
//		if (root != null && result.size() == 0) {
//			listNodes.add(root.getData());
//			result.put(h, listNodes);
//			h++;
//		}
//		listNodes = result.get(h) != null ? result.get(h) : new ArrayList();
//		if (root.getLeft() != null) {
//			listNodes.add(root.getLeft().getData());
//		}
//		if (root.getRight() != null) {
//			listNodes.add(root.getRight().getData());
//		}
//		result.put(h, listNodes);
//		if (root.getLeft() != null) {
//			getIntsInDepth(root.getLeft(), h + 1);
//		}
//		if (root.getRight() != null) {
//			getIntsInDepth(root.getRight(), h + 1);
//
//		}
//		return result;
//	}

	class Node {
		int data;
		Node left, right;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public void levelOrderQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}

	public static void main(String args[]) {
		BinaryNodeTree bt = new BinaryNodeTree();

		BinaryNodeTree.Node n1 = bt.new Node(1);
		n1.setLeft(bt.new Node(2));
		n1.setRight(bt.new Node(3));

		n1.getLeft().setLeft(bt.new Node(6));

		n1.getRight().setLeft(bt.new Node(4));
		n1.getRight().setRight(bt.new Node(5));
		n1.getRight().getRight().setLeft(bt.new Node(9));

		Map<Integer, List<Integer>> rs = bt.getIntsInDepth(n1, 1);
		for (Map.Entry<Integer, List<Integer>> ls : rs.entrySet()) {
			System.out.print(ls.getValue());
		}
		
		bt.levelOrderQueue(n1);
	}
}
