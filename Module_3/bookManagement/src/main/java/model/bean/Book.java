package model.bean;

public class Book {
    int id;
    String name;
    double price;
    int idAuther;

    public Book(int id, String name, double price, int idAuther) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idAuther = idAuther;
    }

    public Book(String name, double price, int idAuther) {
        this.name = name;
        this.price = price;
        this.idAuther = idAuther;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdAuther() {
        return idAuther;
    }

    public void setIdAuther(int idAuther) {
        this.idAuther = idAuther;
    }
}
