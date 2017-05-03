//import java.util.LinkedList;
//
//import javax.swing.tree.TreeNode;
//
///**
// * public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
// * x) {val = x;} }
// */
//public class LevelOrderTraverse {
//	static void levelOrderTraverse(TreeNode root) {
//		// null check
//		if (root == null)
//			return;
//
//		// BFS with queue
//		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.add(root);
//		// node count
//		int currentLevelCount = 1;
//		int nextLevelCount = 0;
//
//		while (!queue.isEmpty()) {
//			while (currentLevelCount > 0) {
//				TreeNode n = queue.poll();
//				// add child nodes to the queue
//				if (n.left != null) {
//					queue.add(n.left);
//					nextLevelCount++;
//				}
//				if (n.right != null) {
//					queue.add(n.right);
//					nextLevelCount++;
//				}
//				System.out.print(n.val + " ");
//				currentLevelCount--;
//			}
//
//			// go to next level
//			currentLevelCount = nextLevelCount;
//			nextLevelCount = 0;
//			System.out.print("\n");
//		}
//	}
//
//	// test
//	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		levelOrderTraverse(root);
//	}
//	
//	
//}