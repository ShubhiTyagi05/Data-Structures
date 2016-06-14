package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree
{
    Node root;

    void printPreOrder()
    {
        printPreOrder(root);
    }

    void printPostOrder()
    {
        printPostOrder(root);
    }

    void printInOrder()
    {
        printInOrder(root);
        System.out.println();
    }

    void printPreOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    void printInOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    void printBreadthFirst()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null)
            {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null)
            {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

    /* returns true if given search tree is binary
    search tree (efficient version) */
    boolean isBST()
    {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null) return true;
        /* false if this node violates the min/max constraints */
        if (node.value < min || node.value > max) return false;
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.value - 1) && isBSTUtil(
                node.right, node.value + 1, max));
    }

    int findMin()
    {
        if (root == null)
        {
            return -1;
        }
        return findMin(root);
    }

    private int findMin(Node node)
    {
        int n = node.value;
        if (node.left != null)
        {
            n = findMin(node.left);
        }
        return n;
    }

    int findMax()
    {
        if (root == null)
        {
            return -1;
        }
        return findMax(root);
    }

    private int findMax(Node node)
    {
        int max = node.value;
        if (node.right != null)
        {
            max = findMax(node.right);
        }
        return max;
    }

    void searchKey(int key)
    {
        boolean flag = searchKey(key, root);
        if (flag == false)
        {
            System.out.println("Not Found");
        }
    }

    private boolean searchKey(int key, Node node)
    {
        if (node == null)
        {
            return false;
        }
        int data = node.value;
        System.out.println(data);
        boolean flag = false;
        if (key == data)
        {
            flag = true;
            System.out.println("Found");
        }
        else if (key < data)
        {
            flag = searchKey(key, node.left);
        }
        else
        {
            flag = searchKey(key, node.right);
        }
        return flag;
    }

    void insertKey(int key)
    {
        insertKey(key, root);
    }

    private void insertKey(int key, Node node)
    {
        if (node != null)
        {
            int data = node.value;
            if (key < data)
            {
                if (node.left != null)
                {
                    insertKey(key, node.left);
                }
                else
                {
                    node.left = new Node(key);
                }
            }
            else if (key > data)
            {
                if (node.right != null)
                {
                    insertKey(key, node.right);
                }
                else
                {
                    node.right = new Node(key);
                }
            }
            else
            {
                System.out.println("Key already exists.");
            }
        }
        else
        {
            node = new Node(key);
        }
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null) return root;
        /* Otherwise, recur down the tree */
        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null) return root.left;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.value = this.findMin(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }
}
