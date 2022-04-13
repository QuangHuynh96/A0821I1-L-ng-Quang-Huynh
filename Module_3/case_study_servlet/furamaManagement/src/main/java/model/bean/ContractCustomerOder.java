package model.bean;

public class ContractCustomerOder {
    int idDichVu;
    String ten;
    int soDienThoai;
    String tenDichVuDiKem;
    String ngayLamHopDong;

    public ContractCustomerOder(int idDichVu, String ten, int soDienThoai, String tenDichVuDiKem, String ngayLamHopDong) {
        this.idDichVu = idDichVu;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public String getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(String ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }
}
