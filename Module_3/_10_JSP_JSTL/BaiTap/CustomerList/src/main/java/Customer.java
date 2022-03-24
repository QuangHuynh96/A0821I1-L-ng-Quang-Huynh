public class Customer {
    String name;
    String birtday;
    String address;

    public Customer() {

    }
    public Customer(String name, String birtday, String address) {
        this.name = name;
        this.birtday = birtday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
