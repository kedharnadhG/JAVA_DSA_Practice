
package Trees;

class  Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
    
}

public class preAndPostOrderTrav {
    Node root;

    preAndPostOrderTrav() {
        root = null;
    }

    //function definition of PreOrder Traversal of the tree
    void preOrderTraversal(Node node){
        if(node==null){
            return;
        }

        //NLR     (Recursion concept)

        //1. visit the root node (print the data)
        System.out.print(node.data+" ");

        //2. traverse the left subtree
        preOrderTraversal(node.left);

        //3. traverse the right subtree
        preOrderTraversal(node.right);
    }


    //function definition of PostOrder Traversal of the tree
    void postOrderTraversal(Node node){
        if(node==null){
            return;
        }

        //LRN     (Recursion concept)

        //1. traverse the left subtree
        postOrderTraversal(node.left);

        //2. traverse the right subtree
        postOrderTraversal(node.right);

        //3. visit the root node (print the data)
        System.out.print(node.data+" ");
    }
    

    public static void main(String[] args) {

        preAndPostOrderTrav tree = new preAndPostOrderTrav();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.left = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println("PreOrder traversal of given tree is :");
        
        tree.preOrderTraversal(tree.root);

        System.out.println();
        
        System.out.println("POSTOrder traversal of given tree is :");
        
        tree.postOrderTraversal(tree.root);
    }
    
}
