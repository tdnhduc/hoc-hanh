import java.util.Scanner;

public class tinhdientichhinhtron {
    public static void main(String[] args) {
        double r,dientich,chuvi ;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ban kinh r");
        r = sc.nextDouble();
        //tinh chu vi
        chuvi = 2*Math.PI*r;
        System.out.println("chu vi = "+ chuvi );
        System.out.println("chu vi = "+ Math.round(chuvi) );
        //dien tich
        dientich = Math.PI*Math.pow(r,2);
        System.out.println("dien tich ="+dientich);
        System.out.println("dien tich ="+Math.round(dientich));
    }
}
