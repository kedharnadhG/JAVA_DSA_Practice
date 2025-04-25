package Trees;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class diameterOfBinTree {
    Node root;
    diameterOfBinTree(){
        root = null;
    }

    public static int height(Node root, int[] diameter) {
        if(root == null) return 0;

        //recursive function calls for left and right subtrees
        int lDepth = height(root.left, diameter);
        int rDepth = height(root.right, diameter);

        //update the diameter (if path through left subtree + path through right subtree is greater than current diameter)
        //important to understand this line
        diameter[0] = Math.max(diameter[0], lDepth + rDepth);

        return 1 + Math.max(lDepth, rDepth);
    }
    

    public static void main(String[] args) {
        diameterOfBinTree tree = new diameterOfBinTree();

        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);

        // int[] diameter = new int[1];
        // height(tree.root, diameter);

        tree.root = new Node(1);
        tree.root.left = new Node(2);

        int[] diameter = new int[1];
        // System.out.println(height(tree.root, diameter));

        //you need to understand this line
        // int depth =  height(tree.root, diameter);
        // System.out.println("The depth of the binary tree is : "+depth);

        height(tree.root, diameter);
        System.out.println("The diameter of the binary tree is : "+diameter[0]);
    }

}
