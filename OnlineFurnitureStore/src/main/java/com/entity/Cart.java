package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int orderNum;
	@OneToOne
	@JoinColumn(name = "customer")
    private Customer customer;
	@ManyToOne
	@JoinColumn(name = "furniture")
    private Furniture furniture;
    private int quantity;

    public Cart() {
    }

    public Cart(int cartId, int orderNum, Customer customer, Furniture furniture, int quantity) {
        this.cartId = cartId;
        this.orderNum = orderNum;
        this.customer = customer;
        this.furniture = furniture;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
