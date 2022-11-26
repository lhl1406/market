package UI.Vegetable;

import UI.Category.CategoryAddForm;
import BLL.VegetableBLL;
import UI.Category.CategoryForm;
import hibernateMarket.DAL.Vegetable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VegetableForm extends javax.swing.JFrame {

    private VegetableBLL vegBLL;
    public VegetableForm() {
        this.setTitle("Vegetable");
        initComponents();
        vegBLL = new VegetableBLL();
        
        try {
            listVegetable();
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listVegetable() throws SQLException {
        List list = vegBLL.loadVegetable();
        DefaultTableModel model = convertVegetable(list);
        tbVegetable.setModel(model);
        tbVegetable.fixTable(jScrollPane2);
    }
    private DefaultTableModel convertVegetable(List list) {
        String[] columnNames = {"VegetableID", "CategoryID", "VegetableName","Unit","Amount","Image","Price"};
        Object[][] data = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            Vegetable t = (Vegetable) list.get(i);
            data[i][0] = t.getVegetableID();
            data[i][1] = t.getCatagory().CatagoryID;
            data[i][2] = t.getVegetableName();
            data[i][3] = t.getUnit();
            data[i][4] = t.getAmount();
            data[i][5] = t.getImage();
            data[i][6] = t.getPrice();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }
    public void initTable()throws SQLException {
        try {
            listVegetable();
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new UI.UI_Item.button.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVegetable = new UI.UI_Item.table.TableDark();
        txtSeach = new UI.UI_Item.textfield.SearchField();
        btnSearch = new UI.UI_Item.button.MyButton();
        btnAdd = new UI.UI_Item.button.MyButton();
        btnEdit = new UI.UI_Item.button.MyButton();
        btnDelete = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("VEGETABLE");

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
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tbVegetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "1", "Lemon", "kg", "10", "", "75000"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vegetable ID", "Category ID", "Vegetable Name", "Unit", "Amount", "Image", "Price"
            }
        ));
        tbVegetable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(tbVegetable);

        txtSeach.setText("ENTER VEGETABLE ID");
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
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
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
       
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
//        VegetableEditForm vetEdit = new VegetableEditForm();
//        vetEdit.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
       VegetableAddForm addForm = new VegetableAddForm();
        addForm.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        try {
            int row = tbVegetable.getSelectedRow();
            TableModel model = tbVegetable.getModel();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                int VegetableID = Integer.parseInt(model.getValueAt(row, 0).toString());
                VegetableEditForm editform = new VegetableEditForm(VegetableID, this, rootPaneCheckingEnabled);
                editform.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        try {
            int row = tbVegetable.getSelectedRow();
            TableModel model = tbVegetable.getModel();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                int vegID = Integer.parseInt(model.getValueAt(row, 0).toString());

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this Vegetable?", "MESSAGE!", JOptionPane.YES_NO_OPTION);
                if (input == JOptionPane.YES_OPTION) {
                    if (vegBLL.deleteVegetable(vegID) > 0) {
                        JOptionPane.showMessageDialog(this, "You have completed to delete Vegetable successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                        List list = vegBLL.loadVegetable();
                        model = convertVegetable(list);
                        tbVegetable.setModel(model);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error because the information is binding!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        try {
           listVegetable();
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            String inputSearch = txtSeach.getText();
            //int ID = Integer.parseInt(inputSearch);
            if (inputSearch.isBlank() == false) {
                List list = vegBLL.searchVegetableName(inputSearch);
                DefaultTableModel model = convertVegetable(list);
                tbVegetable.setModel(model);
            } else {
                List list = vegBLL.loadVegetable();
                DefaultTableModel model = convertVegetable(list);
                tbVegetable.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VegetableForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VegetableForm().setVisible(true);
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
    private UI.UI_Item.table.TableDark tbVegetable;
    private UI.UI_Item.textfield.SearchField txtSeach;
    // End of variables declaration//GEN-END:variables
}
