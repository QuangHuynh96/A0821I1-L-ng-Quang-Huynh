package _12_javaCollectionFramework.exercise.e1_ArrayLisst;

public class Product {
    private int id;
    private String name;
    private int duration;
    private int price;

    public Product(int id, String name, int duration, int price) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }
    public Product() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int year) {
        this.duration = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String toString() {
        return "product: name= "+this.getName()+"," +
                " id= "+this.getId()+", year= "+this.getDuration()+", money= "+this.getPrice();
    }

}
