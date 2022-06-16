package DataStructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class BST {

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(int value) {
        if(root == null) {
            root = new Node(value);
            return;
        }
        Node currentNode = root;
        while (true) {
            if (value < currentNode.getValue()) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node(value));
                    return;
                }
                currentNode = currentNode.getLeft(); // go down one level
            } else {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(new Node(value));
                    return;
                }
                currentNode = currentNode.getRight(); // go down one level
            }
        }
    }

    public Node lookup(int value) {
        if(root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode != null) {
            if(value < currentNode.getValue()) {
                currentNode = currentNode.getLeft(); // go down one level
            } else if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight(); // go down one level
            } else {
                return currentNode; // node == value
            }
        }
        return null;  // not found
    }


    ///////////////////////////////////
    // Adapted from: @author MightyPork
    public void print(Node root) {
        List<List<String>> lines = new ArrayList<>();

        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int depth = 1;

        int widest = 0;

        while (depth != 0) {
            List<String> line = new ArrayList<>();

            depth = 0;

            for (Node currentNode : level) {
                if (currentNode == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String nodeValue = currentNode.getText();
                    line.add(nodeValue);
                    if (nodeValue.length() > widest) widest = nodeValue.length();

                    next.add(currentNode.getLeft());
                    next.add(currentNode.getRight());

                    if (currentNode.getLeft() != null) depth++;
                    if (currentNode.getRight() != null) depth++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
    ///////////////////////////////////

    public void remove(int value) {
        if(root == null) {
            return;
        }

        // search for value
        Node parentNode = null;
        Node currentNode = root;

        while (currentNode.getValue() != value) {
            if (value < currentNode.getValue()) {
                parentNode = currentNode; // keep track of parent node
                currentNode = currentNode.getLeft(); // go down one level

            } else if (value > currentNode.getValue()) {
                parentNode = currentNode; // keep track of parent node
                currentNode = currentNode.getRight(); // go down one level
            }
        }


        while (currentNode != null) {
            // if the value is a leaf node, delete leaf value
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {
                if(parentNode.getLeft() == currentNode) {
                    parentNode.setLeft(null);
                } else {
                    parentNode.setRight(null);
                }

            // if the value has 1 child bypass the value
            } else if(currentNode.getLeft() != null || currentNode.getRight() != null ) {
                if (currentNode.getLeft() == null) {
//                    parentNode.
                }


            // else replace value with successor node
            } else {



            }



        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(3);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        tree.insert(14);
        tree.insert(16);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.print(tree.root);


    }
}
