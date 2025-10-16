import java.util.HashMap;
public class timnodex2 {
    public static void main(String[] args) {

        String a = "ABCASDASDASD";
        System.out.println("\nA: " + numberOfAppear(a, "A"));
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
            // System.out.println("map = " + map);
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
    public static void checkSymmetry(String string) {
        // step 1: tao 2 con tro ( i ben trai, j ben phai) nguoc nhau
        int i = 0;
        int j = string.length() - 1;
        boolean result = true;
        // step 2: so sanh 2 dau
        // i<j vi i dau, j cuoi
        while (i < j) {
            // neu ki tu vi tri i khac j thi tra ve sai
            if (string.charAt(i) != string.charAt(j)) {
                result = false;
                break;
            }
            // neu giong nhau thi tiep tuc i toi, j lui
            i++;
            j--;
        }
        if (result == true) {
            System.out.println(string + " doi xung");
        } else {
            System.out.println(string + " ko doi xung");
        }
    }
    }

