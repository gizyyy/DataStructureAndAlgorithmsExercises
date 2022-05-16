import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {

	public BinaryTree binaryTree;

	public TreeOperations() {
		// set up tree
		if (binaryTree == null) {
			binaryTree = new BinaryTree();
			TreeNode root = new TreeNode(1);
			TreeNode n1 = new TreeNode(2);
			TreeNode n2 = new TreeNode(3);
			TreeNode n3 = new TreeNode(4);
			TreeNode n4 = new TreeNode(5);
			TreeNode n5 = new TreeNode(6);
			TreeNode n6 = new TreeNode(7);
			TreeNode n7 = new TreeNode(8);
			TreeNode n8 = new TreeNode(9);
			binaryTree.setRoot(root);
			root.setLeft(n1);
			root.setRight(n2);

			n1.setLeft(n3);
			n1.setRight(n4);

			n2.setLeft(n5);
			n2.setRight(n6);

			n3.setLeft(n7);
			n3.setRight(n8);
		}
	}

	// traverse root -> left-> right O(N)
	public void traverse(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.getData());
		traverse(treeNode.getLeft());
		traverse(treeNode.getRight());
	}

	// traverse due to levels O(N)
	public void traverseDueToLevel() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(binaryTree.getRoot());
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			System.out.println(node.getData());

			if (node.getLeft() != null) {
				q.add(node.getLeft());
			}
			if (node.getRight() != null) {
				q.add(node.getRight());
			}
		}
	}

	public void search(TreeNode treeNode, int s) {
		if (treeNode == null) {
			return;
		}
		if (treeNode.getData() == s) {
			System.out.println("Found:" + s);
			return;
		}
		search(treeNode.getLeft(), s);
		search(treeNode.getRight(), s);
	}

	
	public void insertDueToLevel(TreeNode treeNode) {
		if (binaryTree.getRoot() == null) {
			binaryTree.setRoot(treeNode);
			return;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(binaryTree.getRoot());
		while (!q.isEmpty()) {
			TreeNode remove = q.remove();
			if (remove.getLeft() == null && remove.getRight() == null) {
				remove.setLeft(treeNode);
				return;
			}

			if (remove.getLeft() == null) {
				remove.setLeft(treeNode);
				return;
			}

			if (remove.getRight() == null) {
				remove.setRight(treeNode);
				return;
			}
			q.add(remove.getLeft());
			q.add(remove.getRight());

		}
	}

	public void deleteWithChilds(TreeNode treeNode, int toDeleted) {
		if (treeNode == null) {
			return;
		}
		if (treeNode.getData() == toDeleted) {
			treeNode = null;
			return;
		}
		deleteWithChilds(treeNode.getLeft(), toDeleted);
		deleteWithChilds(treeNode.getRight(), toDeleted);
		
		
	}

}
