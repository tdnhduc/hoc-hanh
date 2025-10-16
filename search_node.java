import java.util.HashMap;

public class search_node {
    public static void main(String[] args) {
        //System.out.println(7/2);
        Node root = null;
        root = addNode(root, 3);
        root = addNode(root, 4);
//        root = addNode(root, 5);
//        root = addNode(root, 6);
//        root = addNode(root, 7);
//        root = addNode(root, 8);
//        root = addNode(root, 9);

        root = deleteNode(root);

        traverseNode(root);

        // step 1
        int numberOfNode = countNumberOfNode(root);
        // step 2
        int mid = findMidNode(numberOfNode);
        // step 3
        System.out.println("\nNode mid: " + getNodeMid(root, mid));

//        int numberOfNode = countNumberOfNode(root);
//        int halfOfNode = numberOfNode / 2;

        String a = "ABCASDASDASD";
        System.out.println("\nB: " + numberOfAppear(a, "B"));
        System.out.println();

        String b = "ABCDCBA";
        String c = "ABCBA";
        String d = "ABCDE";
        checkSymmetry(b);
        checkSymmetry(c);
        checkSymmetry(d);
    }

    // dem so luong phan tu trong chuoi
    public static int numberOfAppear(String string, String character) {
        // ABCASDASDASD
        // numberOfAppear(a, "A") =>4
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            if (map.get(string.charAt(i)) == null) {
                map.put(string.charAt(i), 1);
            } else {
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            }
            //System.out.println("map = " + map);
        }

        // lay so luong ki tu
        Integer value = map.get(character.charAt(0));

        // tra ve -1 neu ko ton tai
        if (value == null) {
            return -1;
        }
        return value;
    }

    // kiem tra doi xưng
    public static void checkSymmetry(String string){
        // step 1: tao 2 con tro ( i ben trai, j ben phai) nguoc nhau
        int i = 0;
        int j = string.length() -1;
        boolean result = true;
        // step 2: so sanh 2 dau
        // i<j vi i dau, j cuoi
        while (i < j){
            // neu ki tu vi tri i khac j thi tra ve sai
            if (string.charAt(i) != string.charAt(j)){
                result = false;
                break;
            }
            // neu giong nhau thi tiep tuc i toi, j lui
            i++;
            j--;
        }
        if (result == true){
            System.out.println( string + " doi xung");
        } else {
            System.out.println( string + " ko doi xung");
        }
    }

    // tim node giua
    // step 1: dem so node
    // int numberOfNode = countNumberOfNode(root);
    // tinh ham countNumberOfNode
    // 6 node => count =6 ;7 node => count =7
    // int count = 0;
    // var tmp = root;
    // while (tmp != null) {
    //     count++;
    //     tmp = tmp.nextNode;
    // }
    public static int countNumberOfNode(Node root) {
        int count = 0;
        var tmp = root;
        while (tmp != null) {
            count++;
            tmp = tmp.nextNode;
        }
        return count;
    }

    // step 2: tim node giua tu numberOfNode
    // int mid = findMidNode(numberOfNode);
    // neu chan thi 6/2 = 3, le thi 7/2 + 1 = 4
    // int mid = 0;
    // if(count % 2 == 0){
    //      mid = count / 2;
    // } else {
    //      mid = (count / 2) + 1;
    // }
    public static int findMidNode(int count) {
        int mid;
        if (count % 2 == 0) {
            mid = count / 2;
        } else {
            mid = (count / 2) + 1;
        }
        return mid;
    }

    // step 3: duyet den vi tri giua
    // getNodeMid(root, mid);
    // var tmp = root;
    // for (int i = 1; i < mid ; i++){
    //      mid = 3 duyet den 2 xong nextnode = 3
    //      tmp = tmp.nextNode;
    // }
    public static Node getNodeMid(Node root, int mid) {
        if (root == null) {
            return null;
        }

        var tmp = root;
        for (int i = 1; i < mid; i++) {               // step 3
            tmp = tmp.nextNode;
        }

        return tmp;
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
        if (root == null) { // linkedlist empty
            return root;
        }
        // TODO : xoa thang cuoi cung trong linked list
        // 1 => 2 => 3
        // deleteNode() 1=>2
        // deleteNode() 1
        // deleteNode() null
        if (root.nextNode == null) {
            return null;
        }

        Node head = null;
        Node tmp = root;

        while (tmp.nextNode != null) {
            head = tmp;
            tmp = tmp.nextNode;
        }
        head.nextNode = null;

        return root;
    }

//    public static int countNumberOfNode(Node root) {
//        return 0;
//    }

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