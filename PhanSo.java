package btvn;

public class PhanSo {
    private int tu;
    private int mau;

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.tu = tu;
        this.mau = mau;
        chuanHoaDau();
    }

    public int getTu() { return tu; }
    public void setTu(int tu) { this.tu = tu; }

    public int getMau() { return mau; }
    public void setMau(int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.mau = mau;
        chuanHoaDau();
    }

    private void chuanHoaDau() {
        if (mau < 0) {
            tu = -tu;
            mau = -mau;
        }
    }

    private static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public void rutGon() {
        int g = ucln(tu, mau);
        if (g > 1) {
            tu /= g;
            mau /= g;
        }
    }

    public PhanSo tong(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.mau + p.tu * this.mau, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    public PhanSo hieu(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.mau - p.tu * this.mau, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    public PhanSo tich(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.tu, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    public PhanSo thuong(PhanSo p) {
        if (p.tu == 0) {
            throw new ArithmeticException("Khong the chia cho phan so bang 0");
        }
        PhanSo kq = new PhanSo(this.tu * p.mau, this.mau * p.tu);
        kq.rutGon();
        return kq;
    }

    public int soSanh(PhanSo p) {
        long trai = (long) this.tu * p.mau;
        long phai = (long) p.tu * this.mau;
        return Long.compare(trai, phai);
    }

    // Phân số có phải số nguyên không
    public boolean laSoNguyen() {
        return tu % mau == 0;
    }

    @Override
    public String toString() {
        if (mau == 1) {
            return String.valueOf(tu);
        }
        return tu + "/" + mau;
    }
}
