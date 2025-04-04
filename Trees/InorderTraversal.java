package Trees;

import java.util.Stack;

class  Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
    
}

public class InorderTraversal {
    Node root;

    InorderTraversal() {
        root = null;
    }

    //function definition of inorder Traversal of the tree
    void inorderTraversal(Node node){
        if(node==null){
            return;
        }

        //LNR     (Recursion concept)

        //1. traverse the left subtree
        inorderTraversal(node.left);

        //2. visit the root node (print the data)
        System.out.print(node.data+" ");

        //3. traverse the right subtree
        inorderTraversal(node.right);
    }

    void inorderTraversalIterative(Node node){
        Stack<Node> stack = new Stack<>();
        if(node==null){
            return;
        }
        while (true) {
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
        
    }

    public static void main(String[] args) {

        InorderTraversal tree = new InorderTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.left = new Node(7);
        tree.root.right.left.right = new Node(8);

        // System.out.println("Inorder traversal of given tree is :");
        
        // tree.inorderTraversal(tree.root);



        System.out.println();


        System.out.println("Inorder traversal of given tree is  using Iterative:");
        
        tree.inorderTraversalIterative(tree.root);
    }
    
    
}
