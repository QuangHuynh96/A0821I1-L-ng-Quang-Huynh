package model.bean;

public class Customer {
    int id;
    int idLoaikhach;
    String ten;
    String ngaySinh;
    boolean gioiTinh;
    int cmnd;
    int soDienThoai;
    String email;
    String diaChi;
    public Customer() {

    }
    public Customer(int idLoaikhach, String ten, String ngaySinh, boolean gioiTinh, int idCard, int soDienThoai, String email, String diaChi) {
        this.idLoaikhach = idLoaikhach;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = idCard;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Customer(int id, int idLoaikhach, String ten, String ngaySinh, boolean gioiTinh, int idCard, int soDienThoai, String email, String diaChi) {
        this.id = id;
        this.idLoaikhach = idLoaikhach;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = idCard;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoaikhach() {
        return idLoaikhach;
    }

    public void setIdLoaikhach(int idLoaikhach) {
        this.idLoaikhach = idLoaikhach;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
