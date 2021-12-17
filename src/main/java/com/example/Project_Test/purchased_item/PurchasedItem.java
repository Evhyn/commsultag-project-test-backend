package com.example.Project_Test.purchased_item;

import com.example.Project_Test.stock.Stock;
import com.example.Project_Test.user_authentication.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="purchased_item")
public class PurchasedItem {

    @Id
    @SequenceGenerator(name = "Purchased_Item_sequence", sequenceName = "Purchased_Item_sequence", allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Purchased_Item_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Stock stock;

    private Long quantity;
    private Date date;

    public PurchasedItem() {
    }

    public PurchasedItem(Long id, User user, Stock stock, Long quantity, Date date) {
        this.id = id;
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.date = date;
    }

    public PurchasedItem(User user, Stock stock, Long quantity, Date date) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PurchasedItem{" +
                "id=" + id +
                ", user=" + user +
                ", stock=" + stock +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }

}
