package exerciseMore.service;

public interface ProductService<Product> {
    void add();
    void delete( int id);
    void display();
    void search(String name);
}
