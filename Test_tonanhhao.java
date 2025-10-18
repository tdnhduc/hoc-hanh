import java.util.Arrays;

public class Test_tonanhhao {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(findNumber(a, 5));

        deleteNumber(a, 4);
        for(int n: Arrays.asList(a))
            System.out.print(n + " ");

        int[] b = {1,2,3,4,5,6,7,8,9,10, -1};
        addNumber(b, 4);
        System.out.print("\n");
        for(int m: b )
            System.out.print(m + " ");
    }

    static Integer findNumber(Integer[] a, Integer number) {
        // neu ma tim thay tra ve so do
        // neu ma ko tim thay => tra ve -1
        return -1;
    }
    static Integer[] deleteNumber(Integer[] a, int index) {
        // tim vi tri index
        // {1,2,3,4,5,6,7,8,9,10} => a[index] = a[index + 1]
        // {1,2,3,4,6,7,8,9,10,-1}
        // step 1: tim vi tri index
        // step 2: dich may kia qua
        // step 2.1: for loop index => dich phan tu
        // for loop => vi tri dau = index & dkien ket thuc do dai` mang - 1
        // for loop ; i < a.length - 1; i++
        // a[index] = a[index + 1]
        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        // a[length - 1] = -1
        // {1, 2, 3} => length 3
        // index = 0, a[0] = a[0 + 1] => a[0] = a[1] => 1 = 2
        // index = 1, a[1] = a[1 + 1] => a[1] = a[2] => 2 = 3
        // index = 2 => break
        // a[length - 1] = -1
        a[a.length - 1] = -1;
        return a;
    }
    static void addNumber(int[] b, int index) {
        // input = {1,2,3,4,5,6,7,8,9,10,-1}
        // output ={1,2,3,4,100,5,6,7,8,9,10}
        // step 1: duyet tu cuoi mang
        // step 2: dich phan tu
        // for loop => i cuoi mang length -1 & dk ket thuc index +1
        // b[i] = b[i - 1]
        for(int i = b.length -1; i > index; i--){
            b[i] = b[i - 1];
        }
        // tao cho trong tai index va gan no vao
        b[index] = 100;
    }
}