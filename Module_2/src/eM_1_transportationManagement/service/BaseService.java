package transportationManagement.service;

import java.util.List;

public interface BaseService<T> {
    public void add();
    public void display();
    public void delete();
    public void writeFile(String path, T t);
    public List<String> readFile(String path);
}
