package Trees.BST;

public class InsertionAndDelInBST {
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public InsertionAndDelInBST() {
        root = null;
    }

    /*Do we need a constructor like:
            BST(int data) { root = new Node(data); }

        👉 NO, not unless you want to FORCE the tree to start with that value.

        Why?
        - insert() already creates the root when root == null.
        - Using BST() (empty constructor) + insert(x) is cleaner and flexible.

        Conclusion:
        - For normal BST usage: keep only the empty constructor.
        - The constructor with data is unnecessary.
*/

    // InsertionAndDelInBST(int data){
    //     root = new Node(data);
    // }

    

    //function to insert the element in the BST

            void insert(int data){
                //here root remains same, but the left or right of the root changes, we are not modifying the root
                root = insertRec(root, data);
            }

            Node insertRec(Node root, int data){

                //the bst is empty
                if(root == null){
                    root = new Node(data);
                    return root;
                }

                else if (data < root.data){
                    root.left = insertRec(root.left, data);
                }
                else{
                    root.right = insertRec(root.right, data);
                }

                // we are not modifying the root (the root remains same) , but the left or right of the root changes
                return root;
            }



    //function to display the inorder traversal of the tree

            void inorder(){
                inorderRec(root);
            }

            void inorderRec(Node root) {
                if (root != null) {
                    inorderRec(root.left);
                    System.out.print(root.data + " ");
                    inorderRec(root.right);
                }
            }

            
    // funtion to search the element in the BST

            Node search(Node root, int key){
                if(root == null || root.data == key){
                    return root;
                }
                else if(root.data > key){
                    //search in the left subtree recursively
                    return search(root.left, key);
                }
                else{
                    return search(root.right, key);
                }
            }

    
    // function to delete the element in the BST
    
            void delete(int data){
                root = deleteNode(root, data);
            }

            Node deleteNode(Node root, int data){
                if(root == null){
                    return root;
                }

                if(root.data > data){
                    root.left = deleteNode(root.left, data);
                }

                else if(root.data < data){
                    root.right = deleteNode(root.right, data);
                }
                //if the root is the key to be deleted
                else{
                    // CASE 1 : if the node has only one child or no child
                    if(root.left == null){
                        return root.right;
                    }
                    else if(root.right == null){
                        return root.left;
                    }
                    
                    // CASE 2 : if the node has two children

                    /* 
                    // find the inorder successor (smallest element in the right subtree)                    
                    Node inorderSucc = minValNode(root.right);

                    // Copy the inorder successor's content to the root node
                    root.data = inorderSucc.data;

                    // Delete the inorder successor
                    root.right = deleteNode(root.right, inorderSucc.data);

                    */

                    //find the inorder predessor (largest element in the left subtree)
                    Node inorderPredecessor = maXValNode(root.left);

                    // Copy the inorder predecessor's content to the root node
                    root.data = inorderPredecessor.data;

                    // Delete the inorder predecessor
                    root.left = deleteNode(root.left, inorderPredecessor.data);

                }

                return root;

            }

            // function to find the smallest element in the right subtree
            Node minValNode(Node node){
                Node curr = node;

                while(curr.left != null){
                    curr = curr.left;
                }
                
                return curr;
            }


            // function to find the largest element in the left subtree
            Node maXValNode(Node node){
                Node curr = node;
                while(curr.right != null){
                    curr = curr.right;
                }
                return curr;
            }



    public static void main(String[] args) {
        InsertionAndDelInBST tree = new InsertionAndDelInBST();

        tree.insert(45);
        tree.insert(15);
        tree.insert(79);
        tree.insert(90);
        tree.insert(10);
        tree.insert(55);
        tree.insert(12);
        tree.insert(20);
        tree.insert(50);

        tree.inorder();
        System.out.println(" ");


        int data = 40;
        Node result = tree.search(tree.root, data);

        if(result != null){
            System.out.println("The key " + data + " is Found.");
        }else {
            System.out.println("The key " + data + " is NOT Found.");
        }


        tree.delete(45);
        tree.delete(20);

        tree.inorder();
        System.out.println(" ");

    }

}



/* Why must we 'return root' in recursive BST insertion?

    ✔ Reason:
    Recursion modifies a subtree and must return the updated subtree
    so the parent can correctly update its LEFT or RIGHT pointer.

    ✔ What happens:
    insertRec(root.left, data) returns the updated left subtree.
    Parent must assign it:
            root.left = (updated_subtree)

    ✔ If you remove 'return root':
        - Recursive call returns nothing → parent receives NULL
        - Parent does: root.left = NULL   (tree becomes corrupted)

    ✔ Important:
        The root node reference itself rarely changes,
        but the subtree BELOW it changes → must be returned upward.

    Rule:
        ALWAYS return root in recursive insert/delete of BST.
*/
