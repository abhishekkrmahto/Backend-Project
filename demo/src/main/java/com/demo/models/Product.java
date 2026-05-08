package com.demo.models;
import jakarta.persistence.*;

@Entity
public class Product {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    public Product(Long id, String pname, Integer qty, Double price) {
        this.id = id;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
    }
    public Product() {
    }

    //-------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false,length = 25) // isse null value nhi ho sakta
    String pname;
    @Column(nullable = false,length = 10)
    Integer qty;
    @Column(nullable = false)
    Double price;
}