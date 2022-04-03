package model.bean;

public class TrinhDo {
    int id;
    String tenl;

    public TrinhDo(int id, String tenl) {
        this.id = id;
        this.tenl = tenl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenl() {
        return tenl;
    }

    public void setTenl(String tenl) {
        this.tenl = tenl;
    }
}
