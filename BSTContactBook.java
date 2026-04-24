public class BSTContactBook {

    class Node {
        Contact data;
        Node left, right;

        Node(Contact data) {
            this.data = data;
        }
    }

    Node root;

    Node insert(Node root, Contact c) {
        if (root == null) return new Node(c);

        if (c.name.compareTo(root.data.name) < 0)
            root.left = insert(root.left, c);
        else
            root.right = insert(root.right, c);

        return root;
    }

    void add(Contact c) {
        root = insert(root, c);
    }

    Contact search(Node root, String name) {
        if (root == null) return null;

        if (name.equals(root.data.name)) return root.data;

        if (name.compareTo(root.data.name) < 0)
            return search(root.left, name);
        else
            return search(root.right, name);
    }

    Contact search(String name) {
        return search(root, name);
    }

    void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.data);
            display(root.right);
        }
    }

    void display() {
        display(root);
    }
}