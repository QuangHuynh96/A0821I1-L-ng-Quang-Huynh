package model.bean;

public class BenhNhan {
    int idBenhNhan;
    String ten;

    public BenhNhan(int idBenhNhan, String ten) {
        this.idBenhNhan = idBenhNhan;
        this.ten = ten;
    }

    public int getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
