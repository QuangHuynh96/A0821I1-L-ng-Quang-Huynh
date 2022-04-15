package model.bean;

public class BenhAn {
    int idBenhAn;
    int idBenhNhan;
    String NgayNhapVien;
    String NgayRaVien;
    String lyDoNhapVien;

    public BenhAn(int idBenhAn, int idBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.idBenhAn = idBenhAn;
        this.idBenhNhan = idBenhNhan;
        NgayNhapVien = ngayNhapVien;
        NgayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public BenhAn(int idBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.idBenhNhan = idBenhNhan;
        NgayNhapVien = ngayNhapVien;
        NgayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public int getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getNgayNhapVien() {
        return NgayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        NgayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return NgayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        NgayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
