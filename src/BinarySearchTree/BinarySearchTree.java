package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
     Node root;
    BinarySearchTree() {
        root = null;
    }


    void insert(int key) {
        root = insertRec(root, key);
    }


    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()  {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) throws IOException{
        BinarySearchTree tree = new BinarySearchTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int temp = n;
        while(temp-->0){
            tree.insert(Integer.parseInt(st.nextToken().trim()));
        }

        System.out.println((heightOfTree(tree.root)-1)+"\n"+(count));
    }
    static int count = 0;

    public static int heightOfTree(Node root) {
        if (null == root)
            return 0;
        int hLeftSub = heightOfTree(root.left);
        int hRightSub = heightOfTree(root.right);
        int myheight = Math.max(hLeftSub, hRightSub) + 1;
        count+=(myheight-1);
        return myheight;
    }
}