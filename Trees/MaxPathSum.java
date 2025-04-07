package Trees;

class Node {
    int data;

    Node left, right;
    
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class MaxPathSum {
    Node root;
    MaxPathSum(){
        root = null;
    }

    public static int maxPathSum(Node root, int[] maxSumValue) {
        if(root==null){
            return 0;
        }
        
        //get the max path sum from the left subtree
        int leftMaxSum =   Math.max(0, maxPathSum(root.left, maxSumValue));

        //get the max path sum from the right subtree
        int rightMaxSum =  Math.max(0, maxPathSum(root.right, maxSumValue));

        //update the maxSumValue if the current path sum is greater than the current maxSumValue
        maxSumValue[0] = Math.max(maxSumValue[0], root.data + leftMaxSum + rightMaxSum);

        
        //return the max path sum from the current node (which is getting moreSum with the leftMaxSum and rightMaxSum)
        return root.data + Math.max(leftMaxSum, rightMaxSum);
    }

    public static void main(String[] args) {

        MaxPathSum tree = new MaxPathSum();

        // tree.root = new Node(-10);
        // tree.root.left = new Node(9);
        // tree.root.right = new Node(20);
        // tree.root.right.left = new Node(15);
        // tree.root.right.right = new Node(7);

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        int[] maxSumValue = new int[1];
        maxSumValue[0] = Integer.MIN_VALUE;
        maxPathSum(tree.root, maxSumValue);
        System.out.println("Maximum path sum is : "+maxSumValue[0]);
    }
}
