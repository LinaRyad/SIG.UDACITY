package com.SIG.model.fileOperations;


import java.util.ArrayList;


public class InvoiceHeader {
    private int num;
    private String date;
    private String customer;

    private ArrayList<InvoiceLine> items;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int num, String date, String customer) {
        this.num = num;
        this.date = date;
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNum() {
        return num;
    }

    public void setNom(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        double total = 0.0;
        for (InvoiceLine line : getItems()) {
            total += line.getTotal();
        }
        return total;
    }

    public String getAsCSV() {
        return num + "," + date + "," + customer;
    }
}
