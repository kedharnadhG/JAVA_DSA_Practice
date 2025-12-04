package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}


public class LevelOrderTraversalBFT {
    Node root;
    LevelOrderTraversalBFT(){
        root = null;
    }

    public List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if(root == null){
            return levels;
        }

        //using level order traversal using Queue dataStructure
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        int level = 0;

        while(!queue.isEmpty()){
            int level_len = queue.size();

            levels.add(new ArrayList<Integer>());

            //no.of elements in the current level (or at each level)
            for(int i=0; i<level_len; i++){

                Node node = queue.remove();

                //add the node data to the current level
                levels.get(level).add(node.data);

                //add the children of current node to the queue
                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }

            }

            level++;
        }

        return levels;
    }



    public static void main(String[] args) {
        
        LevelOrderTraversalBFT tree = new LevelOrderTraversalBFT();

        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        System.out.println("Level Order / Breadth First Traversal of given tree is :");
        List<List<Integer>> res = tree.levelOrderTraversal(tree.root);

        // while (res.iterator().hasNext()) {
        //     System.out.println(res.get(0));
        //     res.remove(0);
        // }

        System.out.println(res);
    }
}
