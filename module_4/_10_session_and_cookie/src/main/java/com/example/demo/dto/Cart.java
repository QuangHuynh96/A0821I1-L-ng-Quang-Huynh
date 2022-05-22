package com.example.demo.dto;

import com.example.demo.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }

    //để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    //tăng số lượng sản phẩm 1 đơn vị.
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            products.replace(itemEntry.getKey(), itemEntry.getValue() + 1);
        }
    }

    //giảm số lượng snar phẩm 1 đơn vị.
    public void deleteProduct(Product product){
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            products.replace(itemEntry.getKey(),itemEntry.getValue() -1);
    }

    //dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //để đếm số lượng sản phẩm có trong giỏ hàng
    public Integer countItemQuantity(){
        return products.size();
    }

    // dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            payment += product.getKey().getNewPrice() * (float) product.getValue();
        }
        return payment;
    }
    //xóa sản phẩm.
    public void deleteOneProductType(Product product) {
        products.remove(product);
    }
}
