package model.bean;

public class DichVuDiKem {
    int id;
    String name;
    double gia;
    String donVi;
    String trangThai;

    public DichVuDiKem(int id, String name, double gia, String donVi, String trangThai) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.donVi = donVi;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
