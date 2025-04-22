package L_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeMethods {
    // returns the size of the binary tree that is rooted at the given node
    public static int size(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    // Returns the height of the binary tree that is rooted at the given node.
    // We consider the height of an empty (null) tree to be -1.
    public static int height(BinaryTreeNode<?> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    // prints the inorder traversal of the binary tree that is rooted at the given node
    public static <E> void printInorderTraversal(BinaryTreeNode<E> root) {
        if (root != null) {
            printInorderTraversal(root.left);
            System.out.print(root.data + " ");
            printInorderTraversal(root.right);
        }
    }

    // prints the postorder traversal of the binary tree that is rooted at the given node
    public static <E> void printPostorderTraversal(BinaryTreeNode<E> root) {
        if (root != null) {
            printPostorderTraversal(root.left);
            printPostorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // returns a list of all elements in the tree that is rooted at the given node.
    // the list's elements follow the preorder traversal of the tree.
    public static <E> List<E> preorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        preorderListHelper(root, list);
        return list;
    }

    private static <E> void preorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            list.add(root.data);
            preorderListHelper(root.left, list);
            preorderListHelper(root.right, list);
        }
    }

    // this method is optional
    // aka breadth-first traversal
    public static <E> List<List<E>> levelOrderList(BinaryTreeNode<E> root) {
        List<List<E>> result = new ArrayList<>();
        Queue<BinaryTreeNode<E>> queue = new ArrayDeque<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<E> level = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<E> current = queue.remove();
                level.add(current.data);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            result.add(level);
        }

        return result;
    }
}
