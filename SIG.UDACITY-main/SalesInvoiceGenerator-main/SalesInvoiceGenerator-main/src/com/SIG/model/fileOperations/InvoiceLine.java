package com.SIG.model.fileOperations;


public class InvoiceLine {


    private String itemName;
    private double itemPrice;
    private int count;
    private InvoiceHeader invoice;

    public InvoiceLine() {
    }

    public InvoiceLine(String itemName, double itemPrice, int count, InvoiceHeader invoice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoice = invoice;
    }

    public double getTotal() {
        return itemPrice * count;
    }

    public int getCount() {
        return count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getAsCSV() {
        return invoice.getNum() + "," + itemName + "," + itemPrice + "," + count;
    }

    @Override
    public String toString() {
        return "invLine{" + "num=" + invoice.getNum() + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + '}';

    }

}
