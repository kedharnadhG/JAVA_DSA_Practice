package Trees.BST;

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class ValidateBST {
    Node root;
    ValidateBST(){
        root = null;
    }

    public static List<Integer> inorderTraversal(Node root, List<Integer> inorderEles) {
        if (root == null) {
            return inorderEles;
        }

        //LNR     (Recursion concept)

        //1. traverse the left subtree
        if(root.left != null){
            inorderTraversal(root.left, inorderEles);
        }

        //2. visit the root node (print the val)
        inorderEles.add(root.val);

        //3. traverse the right subtree
        if(root.right != null){
            inorderTraversal(root.right, inorderEles);
        }

        return inorderEles;
    }

    public static boolean isValidBST(List<Integer> inorderEles) {
        for (int i = 1; i < inorderEles.size(); i++) {
            if (inorderEles.get(i) <= inorderEles.get(i - 1)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();

        tree.root = new Node(40);
        tree.root.left = new Node(30);
        tree.root.right = new Node(50);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(35);
        tree.root.right.left = new Node(45);
        tree.root.right.right = new Node(60);

        List<Integer> inorderEles = new ArrayList<>();

        ValidateBST.inorderTraversal(tree.root, inorderEles);

        System.out.println(inorderEles);

        System.out.println("Is the tree a valid Binary Search Tree : "+isValidBST(inorderEles));

    }
}


// the Overall Time complexity is ( O(n) + O(n) => O(n) ): the space complexity is O(n)