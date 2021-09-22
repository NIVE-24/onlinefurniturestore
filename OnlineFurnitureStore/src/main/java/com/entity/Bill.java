package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "bill_no")
	private long billNo;
	private String customerName;
	@ManyToOne
	@JoinColumn(name = "furniture")
    private Furniture furniture;
	private int quanity;
    private double price;
    private double amount;

    public Bill() {
    }

    public Bill(long billNo, String customerName, Furniture furniture, int quanity, double price, double amount) {
        this.billNo = billNo;
        this.customerName = customerName;
        this.furniture = furniture;
        this.quanity = quanity;
        this.price = price;
        this.amount = amount;
    }

    public long getBillNo() {
        return billNo;
    }

    public void setBillNo(long billNo) {
        this.billNo = billNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
