
public class TreeWithLinkedListApplication {

	public static void main(String args[]) {
		//TreeOperations op = new TreeOperations();
		//op.traverse(op.binaryTree.getRoot());
		//op.traverseDueToLevel();
		//op.search(op.binaryTree.getRoot(), 3);
		
		//TreeNode toInsert= new TreeNode(11);
		//op.insertDueToLevel(toInsert);
		//op.deleteWithChilds(op.binaryTree.getRoot(), 4);
		//op.traverse(op.binaryTree.getRoot());
		
		BinarySearchTreeOperations op = new BinarySearchTreeOperations();
		//op.insert(op.binaryTree.getRoot(),new TreeNode(42));
		//op.traverseDueToLevel();
		//op.delete(op.binaryTree.getRoot(), 50);
		//op.getDepthOfOneNode(op.binaryTree.getRoot(), new TreeNode(70), 0);
		System.out.println(op.getHeightOfTree(op.binaryTree.getRoot()));
		//op.traverseDueToLevel();
	}
}

//is avl