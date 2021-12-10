package _17_binaryFile_Serialization.exercise.product_Management;

import java.io.Serializable;

class Product implements Serializable {
    enum Status {
        COHANG,HETHANG;
    }
    private int id;
    private String name;
    private String manufacturer;
    private Double price;
    private Status status;

     Status getStatus() {
        return status;
    }

     void setStatus(int number) {
         switch(number) {
             case 1 :
                 this.status= Status.COHANG;
                 break;
             case 2 :
                 this.status= Status.HETHANG;
                 break;
         }
    }

    Product() {
     }

     Product(int id, String name, String manufacturer, Double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.status = Status.COHANG;
    }

     int getId() {
        return id;
    }

     void setId(int id) {
        this.id = id;
    }

     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

     String getManufacturer() {
        return manufacturer;
    }

     void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

     Double getPrice() {
        return price;
    }

     void setPrice(Double price) {
        this.price = price;
    }

     public String toString() {
        return name+" "+manufacturer+" "+id+" "+price+" "+status;
    }
}
