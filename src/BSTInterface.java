public interface BSTInterface {

    //search

    //Insert
    BST.Node insertRecursive(BST.Node root, int data);
    //Pre-Order Traversal
    void preOrderRecursive(BST.Node root);
    //Inorder traversal
    void inorderRecursive(BST.Node root);
    //postorder traversal
    void postOrderRecursive(BST.Node root);

    //without recursion
    void preOrderWithoutRecursion();

    void inOrderWithoutRecursion();

    void postOrderWithoutRecursion();

}
