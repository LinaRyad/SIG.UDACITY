package com.SIG.view;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceTable extends JDialog {
    private JTextField customerName;
    private JTextField invoiceDate;
    private JLabel cusNameLabel;
    private JLabel invDateLabel;
    private JButton okButton;
    private JButton cancelButton;

    public JTextField getCustomerName() {
        return customerName;
    }

    public void setCustomerName(JTextField customerName) {
        this.customerName = customerName;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(JTextField invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public JLabel getInvDateLabel() {
        return invDateLabel;
    }

    public void setInvDateLabel(JLabel invDateLabel) {
        this.invDateLabel = invDateLabel;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public InvoiceTable(main frame) {
        cusNameLabel = new JLabel("Customer Name:");
        customerName = new JTextField(10);
        invDateLabel = new JLabel("Invoice Date:");
        invoiceDate = new JTextField(10);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("createInvoiceOK");
        cancelButton.setActionCommand("createInvoiceCancel");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));

        add(invDateLabel);
        add(invoiceDate);
        add(cusNameLabel);
        add(customerName);
        add(okButton);
        add(cancelButton);

        pack();

    }

}
