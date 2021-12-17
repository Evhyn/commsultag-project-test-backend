package com.example.Project_Test.stock;

import com.example.Project_Test.purchased_item.PurchasedItem;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="stock")
public class Stock {



    @Id
    @SequenceGenerator(name = "stock_sequence", sequenceName = "stock_sequence", allocationSize = 1

    )

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "stock_sequence")
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer price;

    @OneToMany
    @JoinColumn(name = "stock_id")
    private Set<PurchasedItem> purchasedItems = new HashSet<>();

    public Stock() {
    }

    public Stock(Long id, String name, Integer quantity, Integer price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Stock(String name, Integer quantity, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
