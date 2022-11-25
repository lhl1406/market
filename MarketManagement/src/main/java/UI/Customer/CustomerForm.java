/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Customer;

import BLL.CustomerBLL;
import hibernateMarket.DAL.Customers;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 84378
 */
public class CustomerForm extends javax.swing.JFrame {

    private CustomerBLL cusBLL;
    public CustomerForm() {
        this.setTitle("Customer");
        initComponents();
        cusBLL = new CustomerBLL();
        try {
            initTable();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void listCustomer() throws SQLException {
//        List list = cusBLL.loadCustomer();
//        DefaultTableModel model = convertCustomer(list);
//        tbCustomer.setModel(model);
//    }
//    
    public void initTable()throws SQLException {
        List list = cusBLL.loadCustomer();
        DefaultTableModel model = convertCustomer(list);
        tbCustomer.setModel(model);
    }
    private DefaultTableModel convertCustomer(List list) {
        String[] columnNames = {"Customer ID", "Full Name", "Password", "Address", "City"};
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Customers t = (Customers) list.get(i);
            data[i][0] = t.getCustomerID();
            data[i][1] = t.getFullName();
            data[i][2] = t.getPassword();
            data[i][3] = t.getAddress();
            data[i][4] = t.getCity();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new UI.UI_Item.button.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCustomer = new UI.UI_Item.table.TableDark();
        txtSeach = new UI.UI_Item.textfield.SearchField();
        btnSearch = new UI.UI_Item.button.MyButton();
        btnAdd = new UI.UI_Item.button.MyButton();
        btnEdit = new UI.UI_Item.button.MyButton();
        btnDelete = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("CUSTOMER");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/Backicon.png"))); // NOI18N
        btnBack.setBorderColor(new java.awt.Color(210, 224, 191));
        btnBack.setColor(new java.awt.Color(210, 224, 191));
        btnBack.setColorClick(new java.awt.Color(210, 224, 191));
        btnBack.setColorOver(new java.awt.Color(210, 224, 191));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "pass123", "Thinh", "district 5", "HCM"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Password", "Full Name", "Address", "City"
            }
        ));
        tbCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(tbCustomer);

        txtSeach.setText("ENTER Full Name");
        txtSeach.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.setBorderColor(new java.awt.Color(0, 95, 115));
        btnSearch.setColor(new java.awt.Color(0, 95, 115));
        btnSearch.setColorClick(new java.awt.Color(0, 95, 115));
        btnSearch.setColorOver(new java.awt.Color(10, 147, 150));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/plus.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setBorderColor(new java.awt.Color(43, 147, 72));
        btnAdd.setColor(new java.awt.Color(43, 147, 72));
        btnAdd.setColorClick(new java.awt.Color(43, 147, 72));
        btnAdd.setColorOver(new java.awt.Color(128, 185, 24));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/edit.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorderColor(new java.awt.Color(42, 111, 151));
        btnEdit.setColor(new java.awt.Color(42, 111, 151));
        btnEdit.setColorClick(new java.awt.Color(42, 111, 151));
        btnEdit.setColorOver(new java.awt.Color(97, 165, 194));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorderColor(new java.awt.Color(208, 0, 0));
        btnDelete.setColor(new java.awt.Color(208, 0, 0));
        btnDelete.setColorClick(new java.awt.Color(208, 0, 0));
        btnDelete.setColorOver(new java.awt.Color(249, 65, 68));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(txtSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
         this.setVisible(false);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        CustomerAddForm cusAdd = new CustomerAddForm();
        cusAdd.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
//        CustomerEditForm cusEdit = new CustomerEditForm();
//        cusEdit.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        try {
            initTable();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        String inputSearch =txtSeach.getText();
        if (inputSearch.isBlank() == false) {
                List list=null;
            try {
                list = cusBLL.searchCustomerName(inputSearch);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
                DefaultTableModel model = convertCustomer(list);
                tbCustomer.setModel(model);
            }
        if (inputSearch.isBlank() == true) {
            //initTable();
            List list = cusBLL.loadCustomer();
            DefaultTableModel model = convertCustomer(list);
            tbCustomer.setModel(model);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int row = tbCustomer.getSelectedRow();
        TableModel model = tbCustomer.getModel();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
        } else {
            int CustomerID = Integer.parseInt(model.getValueAt(row, 0).toString());
            CustomerEditForm editform = new CustomerEditForm(CustomerID, this, rootPaneCheckingEnabled);
            editform.setVisible(true);
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        try {
            int row = tbCustomer.getSelectedRow();
            TableModel model = tbCustomer.getModel();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                int cusID = Integer.parseInt(model.getValueAt(row, 0).toString());

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this Customer?", "MESSAGE!", JOptionPane.YES_NO_OPTION);
                if (input == JOptionPane.YES_OPTION) {
                    if (cusBLL.deleteCustomer(cusID) > 0) {
                        JOptionPane.showMessageDialog(this, "You have completed to delete Customer successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                        List list = cusBLL.loadCustomer();
                        model = convertCustomer(list);
                        tbCustomer.setModel(model);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error!!! The Customer is used!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnAdd;
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnDelete;
    private UI.UI_Item.button.MyButton btnEdit;
    private UI.UI_Item.button.MyButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.table.TableDark tbCustomer;
    private UI.UI_Item.textfield.SearchField txtSeach;
    // End of variables declaration//GEN-END:variables
}
