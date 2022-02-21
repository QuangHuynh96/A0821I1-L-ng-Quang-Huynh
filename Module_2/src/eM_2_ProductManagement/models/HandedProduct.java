package exerciseMore.models;

public class HandedProduct extends Product{
    private String country;
    private int Status;

    public HandedProduct() {

    }

    public HandedProduct(int id, String name, int price, String producer, String country, int status) {
        super(id, name, price, producer);
        this.country = country;
        Status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
    public String toString() {
        return  this.getId()+","+
                this.getName()+","+
                this.getPrice()+","+
                this.getProducer()+","+
                this.country+","+
                this.Status;
    }
}
