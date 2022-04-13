package model.bean;

public class Auther {
    int id;
    String name;
    String nickName;
    String address;

    public Auther(int id, String name, String nickName, String address) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.address = address;
    }

    public Auther(String name, String nickName, String address) {
        this.name = name;
        this.nickName = nickName;
        this.address = address;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
