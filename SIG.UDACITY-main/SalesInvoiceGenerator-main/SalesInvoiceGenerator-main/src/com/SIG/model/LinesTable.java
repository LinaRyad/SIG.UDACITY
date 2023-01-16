/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.model;


import com.SIG.model.fileOperations.InvoiceLine;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



public class LinesTable extends AbstractTableModel {
    private ArrayList<InvoiceLine> lines;
    private String Columns[] = {"No.", "Item Name", "Item Price", "Count", "Item Total"};

    public LinesTable(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    @Override
    public int getRowCount() {
        return lines.size();
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
        InvoiceLine Line = lines.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Line.getInvoice().getNum();
            case 1:
                return Line.getItemName();
            case 2:
                return Line.getItemPrice();
            case 3:
                return Line.getCount();
            case 4:
                return Line.getTotal();
            default:
                return "";

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
