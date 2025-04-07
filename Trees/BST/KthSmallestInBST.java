package Trees.BST;

import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

public class KthSmallestInBST {

    TreeNode root;

    public KthSmallestInBST(){
        root = null;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> inorderEles){

        if(root == null){
            return inorderEles;
        }

        //LNR     (Recursion concept)
        if(root.left != null){
            inorderTraversal(root.left, inorderEles);
        }

        inorderEles.add(root.val);

        if(root.right != null){
            inorderTraversal(root.right, inorderEles);
        }

        return inorderEles;
    }

    public static void main(String[] args) {
        
        KthSmallestInBST tree = new KthSmallestInBST();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.left.left.left = new TreeNode(1);

        ArrayList<Integer> inorderEles = inorderTraversal(tree.root, new ArrayList<>());
        
        int k = 3;  //we want the 3rd smallest element in the array

        System.out.println(k + "th smallest element in the array is: " + inorderEles.get(k-1));

    }
    
}
