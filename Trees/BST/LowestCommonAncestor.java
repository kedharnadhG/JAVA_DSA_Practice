package Trees.BST;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) { 
        val = x; 
        left = right = null;
    }
}
public class LowestCommonAncestor {

    TreeNode root;
    LowestCommonAncestor() {
        root = null;
    }

    public static TreeNode findLCA(TreeNode root, int n1, int n2) {
        int ParentVal = root.val;
        int n1Val = n1;
        int n2Val = n2;

        if(n1Val > ParentVal && n2Val > ParentVal){
            //Traverse right subtree
            return findLCA(root.right, n1, n2);
        }
        else if(n1Val < ParentVal && n2Val < ParentVal){
            //Traverse left subtree
            return findLCA(root.left, n1, n2);
        }
        return root;
    }
    

    public static void main(String[] args) {
     
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new TreeNode(6);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(0); 
        tree.root.left.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode(3);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(9);

        System.out.println("LCA of 0 and 5 is : "+findLCA(tree.root, 0,5).val);
    }

}
