import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        // test

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

        List<Integer> e = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> f = Arrays.asList(1,1,2,3,4,5,6,7,8,9);
        List<Integer> g = Arrays.asList(1,1,2,3,4,4,5,6,7,8,9);
        List<Integer> h = Arrays.asList(1,2,3,4,4,5,6,7,8,9);
        int target = 5;
        twoSum(e, target);
        System.out.println();
        twoSum(f, target);
        System.out.println();
        twoSum(g, target);
        System.out.println();
        twoSum(h, target);

    }

    public static void twoSum(List<Integer> numbers, int target) {
        // a = [1,2,3,4,5,6,7,8,9];
        // a = [1,1,2,3,4,4,5,6,7,8,9]
        // tong no la 5 => (1,4) (1,4), (2,3)
        // print 1 - 4 ; 4 - 1

        //step 1: for loop duyet phan tu trong list
        for (int i = 0; i < numbers.size(); i++){
            // cho a = i la phan tu dau tien
            int a = numbers.get(i);
            // dem a co bao nhieu lan xuat hiẹn
            int counta = 0;
            for (int k = 0; k < numbers.size(); k++) {
                if (numbers.get(k) == a) {
                    counta++;
                }
            }
            // step 2: for loop tu i + 1 den cuoi list
            for (int j = i + 1; j < numbers.size(); j++){
                // cho j la phan tu sau i den het list
                int b = numbers.get(j);
                // dem so lan b xuat hiẹn
                int countb = 0;
                for (int k = 0; k < numbers.size(); k++) {
                    if (numbers.get(k) == b) {
                        countb++;
                    }
                }
                // neu a + b = target va lay lan dau tien no xuat hien
                if (a + b == target && i == numbers.indexOf(a)){
                    // neu chi cuat hien 1 lan thi in ra
                    if (counta == 1 || countb == 1) {
                        System.out.print(a + "-" + b + ";");
                        break;
                    }
                    // cả 2 deu xuat hien nhieu lan thi in ra het
                    else {
                        System.out.print(a + "-" + b + ";");
                    }
                }
            }
        }
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

    public int tinhGiaiThua(int n) {
        // print n!
        if (n != 0 && n != 1)
            return n * tinhGiaiThua(n-1);
        return 1;
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