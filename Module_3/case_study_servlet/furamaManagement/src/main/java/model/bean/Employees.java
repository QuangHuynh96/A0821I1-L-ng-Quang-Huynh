package model.bean;

public class Employees {
    int id;
    String ten;
    String ngaySinh;
    int cmnd;
    int luong;
    int soDienThoai;
    String email;
    String diaChi;
    int idViTri;
    int idTrinhDo;
    int idBoPhan;

    public Employees(){}

    public Employees(String ten, String ngaySinh, int cmnd, int luong, int soDienThoai, String email, String diaChi, int idViTri, int idTrinhDo, int idBoPhan) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.idViTri = idViTri;
        this.idTrinhDo = idTrinhDo;
        this.idBoPhan = idBoPhan;
    }

    public Employees(int id, String ten, String ngaySinh, int cmnd, int luong, int soDienThoai, String email, String diaChi, int idViTri, int idTrinhDo, int idBoPhan) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.idViTri = idViTri;
        this.idTrinhDo = idTrinhDo;
        this.idBoPhan = idBoPhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
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

    public int getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(int idViTri) {
        this.idViTri = idViTri;
    }

    public int getIdTrinhDo() {
        return idTrinhDo;
    }

    public void setIdTrinhDo(int idTrinhDo) {
        this.idTrinhDo = idTrinhDo;
    }

    public int getIdBoPhan() {
        return idBoPhan;
    }

    public void setIdBoPhan(int idBoPhan) {
        this.idBoPhan = idBoPhan;
    }

    @Override
    public String toString() {
        return  "ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", cmnd=" + cmnd +
                ", luong=" + luong +
                ", soDienThoai=" + soDienThoai +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", idViTri=" + idViTri +
                ", idTrinhDo=" + idTrinhDo +
                ", idBoPhan=" + idBoPhan +
                '}';
    }
}
