/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.view;

import com.SIG.controller.InvoiceController;
import com.SIG.model.Invoice;
import com.SIG.model.fileOperations.InvoiceHeader;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class main extends javax.swing.JFrame {
    public main() {
        initComponents();
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LinesTable = new JTable();
        createNewInvoice = new javax.swing.JButton();
        createNewInvoice.addActionListener(invoiceController);
        deleteInvoice = new javax.swing.JButton();
        deleteInvoice.addActionListener(invoiceController);

        jLabel1 = new JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoicesTable = new JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(invoiceController);
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        createNewItem = new javax.swing.JButton();
        createNewItem.addActionListener(invoiceController);
        deleteItem = new javax.swing.JButton();
        deleteItem.addActionListener(invoiceController);
        invNLabel = new JLabel();
        invTLabel = new JLabel();
        invoiceItems = new JLabel();
        invDate = new JTextField();
        customerName = new JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lFile = new javax.swing.JMenuItem();
        sFile = new javax.swing.JMenuItem();
        lFile.addActionListener(invoiceController);
        sFile.addActionListener(invoiceController);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LinesTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        LinesTable.setToolTipText("");
        jScrollPane1.setViewportView(LinesTable);

        createNewInvoice.setText("Create New Invoice");
        createNewInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceActionPerformed(evt);
            }
        });

        deleteInvoice.setText("Delete Invoice");

        jLabel1.setText("Invoices Table");

        invoicesTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoicesTable.setToolTipText("");
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(invoicesTable);

        jLabel2.setText("Invoice Number");

        jLabel3.setText("Invoices Date");

        jLabel4.setText("Customer Name");

        jLabel5.setText("Invoice Total");

        createNewItem.setText("Create New Item");
        createNewItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewItemActionPerformed(evt);
            }
        });

        deleteItem.setText("Delete Item");

        invoiceItems.setText("Invoice Items");

        customerName.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });

        jMenuBar1.setToolTipText("");

        jMenu1.setText("File");

        lFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        lFile.setText("Load File");
        lFile.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lFileActionPerformed(evt);
            }
        });
        jMenu1.add(lFile);

        sFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        sFile.setMnemonic('c');
        sFile.setText("Save File");
        jMenu1.add(sFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(invTLabel)
                                    .addComponent(invNLabel)
                                    .addComponent(invDate, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(customerName)))
                            .addComponent(invoiceItems))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(createNewInvoice)
                .addGap(37, 37, 37)
                .addComponent(deleteInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(createNewItem)
                .addGap(117, 117, 117)
                .addComponent(deleteItem)
                .addGap(114, 114, 114))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(494, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(invNLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(invDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(invTLabel))
                .addGap(36, 36, 36)
                .addComponent(invoiceItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoice)
                    .addComponent(createNewInvoice)
                    .addComponent(createNewItem)
                    .addComponent(deleteItem))
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGap(98, 98, 98)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewItemActionPerformed

    }//GEN-LAST:event_createNewItemActionPerformed

    private void createNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceActionPerformed

    private void lFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lFileActionPerformed

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicesTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_invoicesTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTable LinesTable;
    private javax.swing.JButton createNewInvoice;
    private javax.swing.JButton createNewItem;
    private JTextField customerName;
    private javax.swing.JButton deleteInvoice;
    private javax.swing.JButton deleteItem;
    private JTextField invDate;
    private JLabel invNLabel;
    private JLabel invTLabel;
    private JLabel invoiceItems;
    private JTable invoicesTable;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem lFile;
    private javax.swing.JMenuItem sFile;
    // End of variables declaration//GEN-END:variables

    private ArrayList<InvoiceHeader> InvoiceHeader;
    private InvoiceController invoiceController = new InvoiceController(this);
    private Invoice invoice;

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JTable getLinesTable() {
        return LinesTable;
    }

    public ArrayList<InvoiceHeader> getinvHeader() {
        return InvoiceHeader;
    }

    public Invoice getInvTableModel() {
        return invoice;
    }

    public void setInvTableModel(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setinvHeader(ArrayList<InvoiceHeader> ListInv) {
        this.InvoiceHeader = ListInv;
    }

    public InvoiceController getListener() {
        return invoiceController;
    }

    public void setCustomerName(JTextField customerName) {
        this.customerName = customerName;
    }

    public void setInvDate(JTextField invDate) {
        this.invDate = invDate;
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvDate() {
        return invDate;
    }

    public JLabel getInvNLabel() {
        return invNLabel;
    }

    public JLabel getInvTLabel() {
        return invTLabel;
    }

    public int getInvoiceNum() {
        int num = 0;

        for (InvoiceHeader inv : getinvHeader()) {
            if (inv.getNum() > num) {
                num = inv.getNum();
            }
        }

        return num += 1;
    }
}
