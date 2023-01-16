package com.SIG.controller;

import com.SIG.model.Invoice;
import com.SIG.model.LinesTable;
import com.SIG.model.fileOperations.InvoiceHeader;
import com.SIG.model.fileOperations.InvoiceLine;
import com.SIG.view.InvoiceTable;
import com.SIG.view.Items;
import com.SIG.view.main;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InvoiceController implements ActionListener, ListSelectionListener {

    private main frame;
    private InvoiceTable InvoiceTable;
    private Items linesDialog;

    public InvoiceController(main aThis) {
        this.frame = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "Create New Invoice":
                Create_New_Invoice();
                break;
            case "Delete Invoice":
                Delete_Invoice();
                break;
            case "Create New Item":
                CreateNewItem();
                break;
            case "Delete Item":
                DeleteItem();
                break;
            case "createInvoiceCancel":
                createCancel();
                break;
            case "createInvoiceOK":
                createOK();
                break;
            case "createItemCancel":
                createItemCancel();
                break;
            case "createItemOK":
                createItemOK();
                break;

        }
    }

    private void loadFile() {
        JFileChooser ODialog = new JFileChooser();
        try {
            int result = ODialog.showOpenDialog(frame);
            //LOAD FILE1//////////////////////////////////////////////////////
            if (result == JFileChooser.APPROVE_OPTION) {
                File invHeader = ODialog.getSelectedFile();
                Path invHeaderPath = Paths.get(invHeader.getAbsolutePath());
                List<String> invHeaderLines = Files.readAllLines(invHeaderPath);

                ArrayList<InvoiceHeader> ListInv = new ArrayList<>();

                for (String invHeaderLine : invHeaderLines) {
                    String[] invHeaderElements = invHeaderLine.split(",");
                    int invHeaderNum = Integer.parseInt(invHeaderElements[0]);
                    String invHeaderDate = invHeaderElements[1];
                    String invHeaderCustomer = invHeaderElements[2];
                    InvoiceHeader invoice = new InvoiceHeader(invHeaderNum, invHeaderDate, invHeaderCustomer);
                    ListInv.add(invoice);
                }

                //LOAD FILE2//////////////////////////////////////////////////////
                result = ODialog.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File invLine = ODialog.getSelectedFile();
                    Path invLinePath = Paths.get(invLine.getAbsolutePath());
                    //You are likely importing java.awt.List.You should instead import java.util.List, which is a parameterized type.
                    List<String> invLineLines = Files.readAllLines(invLinePath);

                    for (String invLineLine : invLineLines) {
                        String[] invLineElements = invLineLine.split(",");

                        int invLineNum = Integer.parseInt(invLineElements[0]);
                        String invLineName = invLineElements[1];
                        double invLinePrice = Double.parseDouble(invLineElements[2]);
                        int invLineCount = Integer.parseInt(invLineElements[3]);
                        InvoiceHeader inv = null;

                        for (InvoiceHeader invoice : ListInv) {
                            if (invoice.getNum() == invLineNum) {
                                inv = invoice;
                                break;
                            }
                        }
                        InvoiceLine line = new InvoiceLine(invLineName, invLinePrice, invLineCount, inv);
                        inv.getItems().add(line);
                    }

                }

                frame.setinvHeader(ListInv);
                Invoice invoice = new Invoice(ListInv);
                frame.setInvTableModel(invoice);
                frame.getInvoicesTable().setModel(invoice);
                frame.getInvTableModel().fireTableDataChanged();

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "File Format is wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        ArrayList<InvoiceHeader> invoices = frame.getinvHeader();

        String headers = "";
        String lines = "";
        for (InvoiceHeader invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (InvoiceLine line : invoice.getItems()) {
                String lineCSV = line.getAsCSV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fc.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(linesFile);
                    lineFileWriter.write(lines);
                    lineFileWriter.flush();
                    lineFileWriter.close();
                }
            }

        } catch (IOException ex) {

        }

    }

    private void Create_New_Invoice() {
        InvoiceTable = new InvoiceTable(frame);
        InvoiceTable.setVisible(true);
    }

//    // Remove the specified element 
//       arrayList.remove(index); 
    private void Delete_Invoice() {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        if (selectedRow != -1) {
            frame.getinvHeader().remove(selectedRow);
            frame.getInvTableModel().fireTableDataChanged();
        }
    }

    private void CreateNewItem() {
        linesDialog = new Items(frame);
        linesDialog.setVisible(true);
    }

    private void DeleteItem() {
        int selectedRow = frame.getLinesTable().getSelectedRow();

        if (selectedRow != -1) {
            LinesTable linesTable = (LinesTable) frame.getLinesTable().getModel();
            linesTable.getLines().remove(selectedRow);
            linesTable.fireTableDataChanged();
            frame.getInvTableModel().fireTableDataChanged();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        if (selectedRow != -1) {
            InvoiceHeader currentInvoice = frame.getinvHeader().get(selectedRow);
            frame.getInvNLabel().setText("" + currentInvoice.getNum());
            frame.getInvDate().setText(currentInvoice.getDate());
            frame.getCustomerName().setText(currentInvoice.getCustomer());
            frame.getInvTLabel().setText("" + currentInvoice.getTotal());
            LinesTable linesTable = new LinesTable(currentInvoice.getItems());
            frame.getLinesTable().setModel(linesTable);
            linesTable.fireTableDataChanged();
        }
    }

    private void createCancel() {
        InvoiceTable.dispose();
    }

    private void createOK() {
        String date = InvoiceTable.getInvoiceDate().getText();
        String customer = InvoiceTable.getCustomerName().getText();
        int num = frame.getInvoiceNum();
        try {
            String[] dateInfo = date.split("-");  // "22-05-2013" -> {"22", "05", "2013"}  xy-qw-20ij
            if (dateInfo.length < 3) {
                JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int day = Integer.parseInt(dateInfo[0]);
                int month = Integer.parseInt(dateInfo[1]);
                int year = Integer.parseInt(dateInfo[2]);
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(frame, "Try this format:" + day + "-" + month + "-" + year, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    InvoiceHeader invoice = new InvoiceHeader(num, date, customer);
                    frame.getinvHeader().add(invoice);
                    frame.getInvTableModel().fireTableDataChanged();
                    InvoiceTable.dispose();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void createItemCancel() {
        InvoiceTable.dispose();
    }

    private void createItemOK() {
        String item = linesDialog.getItemNameField().getText();
        String countStr = linesDialog.getItemCountField().getText();
        String priceStr = linesDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);

        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();

        if (selectedInvoice != -1) {
            InvoiceHeader invoice = frame.getinvHeader().get(selectedInvoice);
            InvoiceLine line = new InvoiceLine(item, price, count, invoice);
            invoice.getItems().add(line);
            LinesTable linesTable = (LinesTable) frame.getLinesTable().getModel();
            linesTable.fireTableDataChanged();
            frame.getInvTableModel().fireTableDataChanged();
        }
        linesDialog.dispose();
    }


}
