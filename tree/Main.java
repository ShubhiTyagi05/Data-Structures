package tree;

public class Main
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(20);
        bt.root.left = new Node(8);
        bt.root.right = new Node(22);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(12);
        bt.root.left.right.left = new Node(10);
        bt.root.left.right.right = new Node(14);
        bt.root.left.right.left.right=new Node(11);
        //  bt.root.right.left=new Node(6);
        //  bt.root.right.right=new Node(7);
        // bt.printBreadthFirst();
        bt.printInOrder();
        // bt.printPostOrder();
        // bt.printPreOrder();
        //System.out.println(bt.isBST());
        // System.out.println(bt.findMin());
        //System.out.println(bt.findMax());
        bt.searchKey(22);
        bt.insertKey(23);
        bt.deleteKey(8);
       bt.printInOrder();
    }
}
