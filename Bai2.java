package btvn;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan so: ");
        int n = sc.nextInt();
        ArrayList<PhanSo> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Phan so " + i + " - nhap tu va mau: ");
            int tu = sc.nextInt();
            int mau = sc.nextInt();
            ds.add(new PhanSo(tu, mau));
        }

        if (ds.isEmpty()) {
            System.out.println("Tap phan so rong");
            sc.close();
            return;
        }

        System.out.println("Tap phan so: " + ds);

        PhanSo max = ds.get(0);
        for (PhanSo p : ds) {
            if (p.soSanh(max) > 0) {
                max = p;
            }
        }
        System.out.println("Phan so lon nhat: " + max);

        // Tổng các phân số
        PhanSo tong = new PhanSo();
        for (PhanSo p : ds) {
            tong = tong.tong(p);
        }
        System.out.println("Tong cac phan so: " + tong);

        int dem = 0;
        for (PhanSo p : ds) {
            if (!p.laSoNguyen()) {
                dem++;
            }
        }
        System.out.println("So phan so khong phai so nguyen: " + dem);

        sc.close();
    }
}
