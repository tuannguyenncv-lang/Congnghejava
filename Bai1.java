package btvn;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tu va mau phan so a: ");
        PhanSo a = new PhanSo(sc.nextInt(), sc.nextInt());
        System.out.print("Nhap tu va mau phan so b: ");
        PhanSo b = new PhanSo(sc.nextInt(), sc.nextInt());

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + a.tong(b));
        System.out.println("a - b = " + a.hieu(b));
        System.out.println("a * b = " + a.tich(b));
        if (b.getTu() != 0) {
            System.out.println("a / b = " + a.thuong(b));
        } else {
            System.out.println("a / b: khong chia duoc vi b = 0");
        }

        int kq = a.soSanh(b);
        if (kq > 0) System.out.println("a > b");
        else if (kq < 0) System.out.println("a < b");
        else System.out.println("a = b");

        a.rutGon();
        System.out.println("a sau khi rut gon = " + a);

        sc.close();
    }
}
