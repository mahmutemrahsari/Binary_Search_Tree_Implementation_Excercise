import java.util.Stack;

public class BST implements BSTInterface {
    static class Node{
        private final int data;
        private Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }

        //Checks if node is leaf (there is no node after it)
        public boolean isLeaf(){
            return left == null && right == null;
            //alternatively can be written as:
            // return left == null ? right == null : false;
        }
    }

    //Root of BST
    Node root;

    //Constructor
    BST(){
        root = null;
    }

    public Node insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        //Recursive happens here!
        if(data < root.data)
            root.left = insertRecursive(root.left, data);
        else if(data > root.data)
            root.right = insertRecursive(root.right,data);

        //Returns the unchanged node pointer
        return root;
    }

    /*
    Depth First Traversals:
        (a) Inorder (Left, Root, Right)
        (b) Preorder (Root, Left, Right)
        (c) Postorder (Left, Right, Root)
     */

    // 1.visit left subtree, -> 2.print value of the current node or root, -> 3. visit right subtree
   public void inorderRecursive(Node root){
        if(root==null){
            return;
        }
        inorderRecursive(root.left);
        System.out.println(root.data); // Prints root data
        inorderRecursive(root.right);
    }

    // 1.print the value of the current node or root, -> 2.visit the left subtree, -> 3. visit right subtree
   public void preOrderRecursive(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    //  1.visit the left subtree, -> 2. visit right subtree , -> 3.print the value of the current node or root
    public void postOrderRecursive(Node root){
        if (root == null ){
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.data);
    }

    /*
        Notes about *** Stack.peek() ***
        The java.util.Stack.peek() method in Java is used to retrieve or fetch the first element of the Stack
        or the element present at the top of the Stack.
        The element retrieved does not get deleted or removed from the Stack.
    */

    //iterative pre-post-in-Order traversal algorithm without recursion!
    public void preOrderWithoutRecursion(){
        /*
        iterativePreorder(node)
            if (node == null)
                return
            stack ← empty stack
            stack.push(node)
            while (not stack.isEmpty())
                node ← stack.pop()
                visit(node)
    //right child is pushed first so that left is processed first
                if node.right ≠ null
                    stack.push(node.right)
                if node.left ≠ null
                    stack.push(node.left)
         */

        Stack<Node> nodes = new Stack<>();

        if(root == null)
            return;
        nodes.push(root);

        while(!nodes.isEmpty()){
            root = nodes.pop();
            System.out.println(root.data);
            if(root.right != null)
                nodes.push(root.right);
            if(root.left != null)
                nodes.push(root.left);
        }
    }

    public void inOrderWithoutRecursion(){
        /*
        iterativeInorder(node)
        stack ← empty stack
        while (node ≠ null or not stack.isEmpty())
            if (node ≠ null)
            stack.push(node)
            node ← node.left
        else
            node ← stack.pop()
            visit(node)
            node ← node.right
         */
        Stack<Node> nodes = new Stack<>();
        while (root != null || !nodes.isEmpty()){
            if(root != null){
                nodes.push(root);
                root = root.left;
            }else{
                root = nodes.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }

    }

    public void postOrderWithoutRecursion(){
        Stack<Node> nodes = new Stack<>();

        if(root == null)
            return;
        nodes.push(root);

        while(!nodes.isEmpty()){
           Node current = nodes.peek();
           if(current.isLeaf()){
               Node node = nodes.pop();
               System.out.println(node.data);
           }else{
               if(current.right !=null){
                   nodes.push(current.right);
                   current.right = null;
               }
               if(current.left != null){
                   nodes.push(current.left);
                   current.left = null;
               }
           }
        }
    }



}
