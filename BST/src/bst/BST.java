/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author nemesis
 */
class BST_class {

    //node class that defines BST node
    class Node {

        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    // BST root node 
    Node root;

    // Constructor for BST =>initial empty tree
    BST_class() {
        root = null;
    }

    boolean search(int key) {
        root = search_Recursive(root, key);
        if (root == null) {
            System.out.println("\nNot Found: "+ key);
            return false;
        } else {
            System.out.println("\n\nFound: "+key);
            return true;
        }
    }

    //recursive insert function
    Node search_Recursive(Node root, int key) {
        // Base Cases: root is null or key is present at root 
        if (root == null || root.key == key) {
            return root;
        }
        // val is greater than root's key 
        if (root.key > key) {
            return search_Recursive(root.left, key);
        }
        // val is less than root's key 
        return search_Recursive(root.right, key);
    }

    //delete a node from BST
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    Node delete_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            return root;
        }

        //traverse the tree
        if (key < root.key) //traverse left subtree 
        {
//            System.out.println("left leaf: " + root.key);
            //          point the left node at
            root.left = delete_Recursive(root.left, key);
        } else if (key > root.key) //traverse right subtree
        {
//            System.out.println("right leaf: " + root.key);
//          point the right node at
            root.right = delete_Recursive(root.right, key);
        } else {
            // node contains only one child
            if (root.left == null) {
//                System.out.println("one child left: " + root.key);
                return root.right; //null or value
            } else if (root.right == null) {
//                System.out.println("one child right: " + root.key);
                return root.left; //null or value
            }

            // node has two children; 
            //get inorder successor (min value in the right subtree)
//            System.out.println("two child: " + root.key);
            root.key = minValue(root.right); // pick small from right subtree

            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.key); //delete/null the minimum value
        }
//        System.out.println("Returing root: "+root.key);
        return root;
    }

    int minValue(Node root) {
        //initially minval = root
        int minval = root.key;
        //find minval
//        System.out.println("initial min value: " + minval);
        while (root.left != null) {
            
            minval = root.left.key; //left side always has small value untill null
            root = root.left; //next left sub tree
//            System.out.println("min value: " + minval);
        }
        return minval;
    }

    // insert a node in BST 
    void insert(int key) {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
//        System.out.println("");
        //tree is empty
        if (root == null) {
            root = new Node(key);
//            System.out.println("insert: " + root.key + "\n");
            return root;
        }
        //traverse the tree
        if (key < root.key) //insert in the left subtree
        {
//            System.out.println("left of " + root.key);
            root.left = insert_Recursive(root.left, key);
        } else if (key > root.key) //insert in the right subtree
        {
//            System.out.println("right of " + root.key);
            root.right = insert_Recursive(root.right, key);
        }
        // return pointer
        return root;
    }

// method for inorder traversal of BST 
    void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST  
    void inorder_Recursive(Node root) {
        if (root != null) {
//            System.out.println("root left: "+root.key);
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
//            System.out.println("");
            inorder_Recursive(root.right);
        }
    }
}

public class BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a BST object
        BST_class bst = new BST_class();
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   */
        //insert data into BST
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        //print the BST
        System.out.println("Create Binary Search Tree(Left-root-right):");
        bst.inorder();

//        delete leaf node  
        System.out.println("\n\nThe BST after Delete 12(leaf node):");
        bst.deleteKey(12);
        bst.inorder();
//        delete the node with one child
        System.out.println("\n\nThe BST after Delete 90 (node with 1 child):");
        bst.deleteKey(90);
        bst.inorder();
        //delete node with two children  
        System.out.println("\n\nThe BST after Delete 45 (Node with two children):");
        bst.deleteKey(45);
        bst.inorder();
        
        //search a key in the BST
        boolean ret_val = bst.search(50);
        ret_val = bst.search(12);

    }

}
