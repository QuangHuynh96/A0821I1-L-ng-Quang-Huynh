package model.bean;

public class HopDongChiTiet {
    int id;
    int idHopDong;
    int idDichVuDiKem;
    int soLuong;

    public HopDongChiTiet(int id, int idHopDong, int idDichVuDiKem, int soLuong) {
        this.id = id;
        this.idHopDong = idHopDong;
        this.idDichVuDiKem = idDichVuDiKem;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdDichVuDiKem() {
        return idDichVuDiKem;
    }

    public void setIdDichVuDiKem(int idDichVuDiKem) {
        this.idDichVuDiKem = idDichVuDiKem;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
