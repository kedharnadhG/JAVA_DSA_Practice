package Trees;
//Height of a binary tree
class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class MaxDepthOfBT {
    Node root;
    MaxDepthOfBT(){
        root=null;
    }

    public static int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        else{
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);
            if(lDepth>rDepth){
                return lDepth+1;
            }
            else{
                return rDepth+1;
            }
        }
    }

    public static void main(String[] args) {
        
        MaxDepthOfBT tree = new MaxDepthOfBT();

        // [3, 9,20, null, null, 15, 7,null, null, null, null, 8, null, null, null]
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.left.left = new Node(8);
        tree.root.right.right = new Node(7);

        System.out.println("The maximum depth/height of the binary tree is : "+maxDepth(tree.root));
    
    }
}
