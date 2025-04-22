package L_trees;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(
                15,
                new BinaryTreeNode<>(
                        6,
                        new BinaryTreeNode<>(3),
                        new BinaryTreeNode<>(
                                10,
                                new BinaryTreeNode<>(13),
                                null)
                ),
                new BinaryTreeNode<>(
                        4,
                        new BinaryTreeNode<>(8),
                        new BinaryTreeNode<>(
                                2,
                                null,
                                new BinaryTreeNode<>(
                                        9,
                                        new BinaryTreeNode<>(12),
                                        null)
                        )
                )
        );

        /*
        root1:    15
                /    \
               6      4
             /  \    / \
            3   10  8   2
                /        \
               13        9
                        /
                       12
         */

        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(10);
        root2.left = new BinaryTreeNode<>(23);
        root2.right = new BinaryTreeNode<>(12);
        root2.left.left = new BinaryTreeNode<>(9);
        root2.left.left.right = new BinaryTreeNode<>(3);
        /*
            10
           /  \
          23  12
         /
        9
         \
          3
        */

        /*
        Ways to traverse (visit all nodes of) a binary tree:

        1. inorder(node)
                inorder(node.left)
                visit node, e.g., print its data
                inorder(node.right)

        2. preorder(node)
                visit node
                preorder(node.left)
                preorder(node.right)

        3. postorder(node)
                postorder(node.left)
                postorder(node.right)
                visit node

        4. level-order, aka breadth-first:
           level by level from top level to bottom level
           on each level, go left to right
         */
    }
}
