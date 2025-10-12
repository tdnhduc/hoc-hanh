public class main {
    public static void main(String[] args) {
        //System.out.println(7/2);
        Node root = null;
        root = addNode(root, 3);
        root = addNode(root, 4);
        root = addNode(root, 5);
        root = addNode(root, 6);
        root = addNode(root, 7);
        root = addNode(root, 8);
        root = addNode(root, 9);
        deleteNode(root);

        traverseNode(root);
    }

    public static void traverseNode(Node root) {
        var tmp = root;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.nextNode;
        }
    }

    public static Node addNode(Node root, int value) {
        if (root == null) { // linkedlist empty
            root = new Node(value);
            return root;
        }

        var tmp = root;
        while (tmp.nextNode != null) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = new Node(value);
        return root;
    }

    public static Node deleteNode(Node root) {
        if (root == null) {
            return root;
        }
        // TODO : xoa thang cuoi cung trong linked list
        // 1 => 2 => 3
        // deleteNode() 1=>2
        // deleteNode() 1
        var tmp = root;
        while (tmp.nextNode.nextNode != null) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = null;
        // deleteNode() null
        if (root.nextNode == null) {
            return null;
        }
        return root;
    }

    public static int countNumberOfNode(Node root) {
        return 0;
    }

    static class Node {
        private int value;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    "} => ";
        }
    }
}