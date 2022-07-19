package DataStructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
//    // 60/80 testcases solution using inorder traversal
//    private static Queue<Integer> queue = new LinkedList<>(); // used to hold and check against root value
//
//    public static boolean isValidBST(TreeNode root) {
//        queue.add(root.val);
//
//        if(root.left != null) {
//            if (root.val <= root.left.val || root.left.val > queue.peek()) { // check current node left child
//                return false; // not a valid tree
//            }
//
//            isValidBST(root.left); // go down to the left
//        }
//
//        if (root.right != null) {
//            if (root.val >= root.right.val || root.right.val < queue.peek()) {// check current node right child
//                return false; // not a valid tree
//            }
//
//            isValidBST(root.right);  // go down to the right
//        }
//
//        return true; // valid tree
//    }


    // Algorithm Using Inorder Traversal and storing the results in a List
    public static boolean isValidBST2(TreeNode root) {
        List<Integer> list = inOrder(root, new ArrayList<>());
        return isSorted(list);
    }

    public static List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
        return list;
    }

    private static boolean isSorted(List<Integer> list) {
        for (int x = 1; x < list.size(); x++) {
            if ( list.get(x) <= list.get(x - 1) ) {
                return false; // if current value is less the previous value, not valid BST
            }
        }
        return true;
    }


    // Algorithm Using Upper and Lower Limits // Most efficient
    public static boolean isValidBST3(TreeNode root) {
        return isValid(root, null, null);
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }


    public static void main(String[] args) {
//        [5,4,6,null,null,3,7] // not valid BST
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(isValidBST3(treeNode1));
    }
}
