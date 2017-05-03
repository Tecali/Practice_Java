import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

// Class traversing inOrder
class TreeNodeTraversal {

	TreeNode root;

	public static void inorderRecursiveTraversal(TreeNode root) {
		if (root != null) {
			inorderRecursiveTraversal(root.left);
			System.out.print(root.val+ " ");
			inorderRecursiveTraversal(root.right);
			
		}
	}

	public void inorderTraversal() {
		if (root == null) {
			return;
		}

		// Using a stack
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode treeNode = root;

		while (treeNode != null) {
			stack.push(treeNode);
			treeNode = treeNode.left;
		}

		while (stack.size() > 0) {

			// Visiting the stack at the top
			treeNode = stack.pop();
			System.out.print(treeNode.val + " ");
			if (treeNode.right != null) {
				treeNode = treeNode.right;

				// Visit the leftmost
				while (treeNode != null) {
					stack.push(treeNode);
					treeNode = treeNode.left;
				}
			}
		}
	}

	public static void main(String args[]) {
		// creating a binary tree
		TreeNodeTraversal tree = new TreeNodeTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		inorderRecursiveTraversal(tree.root);
		System.out.println(" And Iteratively ");
		tree.inorderTraversal();
		LinkedList<Integer> in = new LinkedList<Integer>();
		
		// TEsting rands
		Integer[] input = {1,2,3,4,2,3};
		//List<Integer> xs = new ArrayList<Integer>(Arrays.asList(input));
		Set<Integer> inSet = new HashSet<Integer>(new ArrayList<Integer>(Arrays.asList(input)));
		//inSet = ;
		System.out.println("\t"+inSet);
	}

}
