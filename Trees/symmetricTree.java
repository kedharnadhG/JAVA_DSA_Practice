package Trees;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class symmetricTree {
    Node root;
    symmetricTree(){
        root = null;
    }

    public static boolean isSymmetric(Node t1, Node t2){ 
        if(t1==null && t2==null){
            return true;
        }
        // if one of the nodes is null (mismatch) or data of the nodes is not equal (mismatch), return false
        if(t1==null || t2==null){
            return false;
        }

        return (t1.data==t2.data) && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


    public static void main(String[] args) {

        symmetricTree tree = new symmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        System.out.println("The tree is symmetric : "+isSymmetric(tree.root, tree.root));

        
    }
    
}
