package exerciseMore.models;

public class GenuineProduct extends Product{
    private int insurance;

    public GenuineProduct() {
    }

    public GenuineProduct(int id, String name, int price, String producer, int insurance) {
        super(id, name, price, producer);
        this.insurance = insurance;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }
    public String toString() {
        return  this.getId()+","+
                this.getName()+","+
                this.getPrice()+","+
                this.getProducer()+","+
                this.insurance;
    }
}
