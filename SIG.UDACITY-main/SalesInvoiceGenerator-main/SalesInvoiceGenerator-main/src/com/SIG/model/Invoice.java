package com.SIG.model;


import com.SIG.model.fileOperations.InvoiceHeader;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Invoice extends AbstractTableModel {

    private ArrayList<InvoiceHeader> InvoiceHeader;
    private String Columns[] = {"No.", "Date", "Customer", "Total"};

    public Invoice(ArrayList<InvoiceHeader> InvoiceHeader) {
        this.InvoiceHeader = InvoiceHeader;
    }

    @Override
    public int getRowCount() {
        return InvoiceHeader.size();
    }

    @Override
    public int getColumnCount() {
        return Columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return Columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoice = this.InvoiceHeader.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return invoice.getNum();
            case 1:
                return invoice.getDate();
            case 2:
                return invoice.getCustomer();
            case 3:
                return invoice.getTotal();
            default:
                return "";
        }
    }

   

}
