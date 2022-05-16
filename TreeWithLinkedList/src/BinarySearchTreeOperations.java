import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeOperations {

	public BinaryTree binaryTree;

	public BinarySearchTreeOperations() {
		// set up tree
		if (binaryTree == null) {
			binaryTree = new BinaryTree();
			TreeNode root = new TreeNode(70);
			TreeNode n1 = new TreeNode(60);
			TreeNode n2 = new TreeNode(80);
			TreeNode n3 = new TreeNode(50);
			TreeNode n4 = new TreeNode(65);
			TreeNode n5 = new TreeNode(75);
			TreeNode n6 = new TreeNode(90);
			TreeNode n7 = new TreeNode(35);
			TreeNode n8 = new TreeNode(55);
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

	public void insert(TreeNode root, TreeNode treeNode) {
		if (root == null) {
			BinaryTree b = new BinaryTree();
			b.setRoot(treeNode);
			binaryTree = b;
		}

		TreeNode togo = null;
		if (root.getData() > treeNode.getData()) {
			togo = root.getLeft();
			if (togo == null) {
				root.setLeft(treeNode);
				return;
			}
		}

		if (root.getData() == treeNode.getData()) {
			// already there
			return;
		}

		if (root.getData() < treeNode.getData()) {
			togo = root.getRight();
			if (togo == null) {
				root.setRight(treeNode);
				return;
			}
		}
		insert(togo, treeNode);
	}

	public void traverse(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.getData());
		traverse(treeNode.getLeft());
		traverse(treeNode.getRight());
	}

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

		if (treeNode.getData() > s) {
			search(treeNode.getLeft(), s);
		}

		if (treeNode.getData() < s) {
			search(treeNode.getRight(), s);
		}

	}

	public void getDepthOfOneNode(TreeNode root, TreeNode treeNode, int currentDepth) {
		if (root == null) {
			return;
		}

		if (root.getData() == treeNode.getData()) {
			System.out.println("Found:" + treeNode.getData());
			System.out.println("Depth:" + currentDepth);
			return;
		}

		currentDepth++;
		if (root.getData() > treeNode.getData()) {
			getDepthOfOneNode(root.getLeft(), treeNode, currentDepth);
		}

		if (root.getData() < treeNode.getData()) {
			getDepthOfOneNode(root.getRight(), treeNode, currentDepth);
		}

	}

	public int getHeightOfTree(TreeNode aNode) {
		if (aNode == null)
			return 0;
		return 1 + Math.max(getHeightOfTree(aNode.getLeft()), getHeightOfTree(aNode.getRight()));
	}

	public void delete(TreeNode treeNode, int s) {
		if (treeNode == null) {
			return;
		}

		if (treeNode.getData() == s) {
			// no kid
			if (treeNode.getLeft() == null && treeNode.getRight() == null) {
				treeNode.setData(-1);
			}

			// one kid
			if (treeNode.getLeft() == null) {
				treeNode.setData(treeNode.getRight().getData());
				treeNode.setRight(null);
				return;
			}

			if (treeNode.getRight() == null) {
				treeNode.setData(treeNode.getLeft().getData());
				treeNode.setLeft(null);
				return;
			}

			// more kid
			TreeNode subRoot = treeNode.getRight();
			TreeNode subRootMom = treeNode;
			while (subRoot != null) {
				if (subRoot.getLeft() == null) {
					break;
				}
				subRootMom = subRoot;
				subRoot = subRoot.getLeft();
			}
			subRootMom.setRight(null);
			treeNode.setData(subRoot.getData());
			return;
		}

		if (treeNode.getData() > s) {
			delete(treeNode.getLeft(), s);
		}

		if (treeNode.getData() < s) {
			delete(treeNode.getRight(), s);
		}

	}

}
