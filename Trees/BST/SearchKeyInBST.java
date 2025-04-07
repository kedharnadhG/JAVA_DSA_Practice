package Trees.BST;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class SearchKeyInBST {
     Node root;
     SearchKeyInBST(){
         root = null;
     }


     // O(h) time complexity where h is the height of the tree, to find the key in the tree
     public static Node searchKey(Node root, int key){
         if(root == null || root.val == key){
             return root;
         }
         
         else if(root.val > key){
             return searchKey(root.left, key);
         }
         else{
             return searchKey(root.right, key);
         }
     }

     public static void printSubtree(Node node) {
        if (node == null) return;
        
        System.out.print(node.val + " ");
        printSubtree(node.left);
        printSubtree(node.right);
    }
    

    public static void main(String[] args) {

        SearchKeyInBST tree = new SearchKeyInBST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // int key = 4;
        int key = 2;

        Node result = searchKey(tree.root, key);
        if (result != null) {
            // System.out.println(result.val);
            System.out.println("The key " + key + " is present in the tree.");
            System.out.print("And its subtree is : ");
            printSubtree(result);
        } else {
            System.out.println("The key " + key + " is NOT present in the tree.");
        }

        
    }
    
}
