package com.SIG.view;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Items extends JDialog {
    private JTextField itemNameTextField;
    private JTextField itemCountTextField;
    private JTextField itemPriceTextField;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okButton;
    private JButton cancelButton;

    public Items(main frame) {
        itemNameTextField = new JTextField(10);
        itemNameLabel = new JLabel("Item Name");

        itemCountTextField = new JTextField(10);
        itemCountLabel = new JLabel("Item Count");

        itemPriceTextField = new JTextField(10);
        itemPriceLabel = new JLabel("Item Price");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("createItemOK");
        cancelButton.setActionCommand("createItemCancel");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));

        add(itemNameLabel);
        add(itemNameTextField);
        add(itemCountLabel);
        add(itemCountTextField);
        add(itemPriceLabel);
        add(itemPriceTextField);
        add(okButton);
        add(cancelButton);

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameTextField;
    }

    public JTextField getItemCountField() {
        return itemCountTextField;
    }

    public JTextField getItemPriceField() {
        return itemPriceTextField;
    }
}
