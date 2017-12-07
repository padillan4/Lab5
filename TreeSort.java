
public final class TreeSort {
	private static AVLTree tree = new AVLTree();
	
	public static void sort(MyArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			tree.insert(new Node(list.get(i)));
		}
		tree.inOrder(tree.getRoot());
	}

}
