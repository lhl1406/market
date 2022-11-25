package UI.Import;

import BLL.CategoryBLL;
import BLL.VegetableBLL;
import hibernateMarket.DAL.Category;
import hibernateMarket.DAL.Vegetable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ImportForm extends javax.swing.JFrame {

    private VegetableBLL vegBLL = new VegetableBLL();
    private CategoryBLL cateBLL = new CategoryBLL();

    public ImportForm() {
        this.setTitle("Import");
        initComponents();
        loadCategory();
    }

    private void loadCombobox() {
        List<Category> listCategory;
        listCategory = cateBLL.loadCategory();
        for (int i = 0; i < listCategory.size(); i++) {
            cbCategory.addItem(listCategory.get(i).getCatagoryID()); //load combobox CateID
        }
    }

    private void loadTableImport(int cateID) {
        List listVeg = cateBLL.getCategory(cateID).getListVegetable();
        Object[][] data = vegBLL.converImport(listVeg);
        String[] title = {"VegID", "Name", "Unit", "Price", "Amount"};
        DefaultTableModel model = new DefaultTableModel(data, title);
        tbProduct.setModel(model);
    }

    private void loadCategory() {
        loadCombobox();
        int ID = (int) cbCategory.getSelectedItem();
        loadTableImport(ID);
        cbCategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                Category cate = (Category ) e.getItem();
//                int cateid = cate.getCatagoryID();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int item = (int) e.getItem();
                    loadTableImport(item);
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new UI.UI_Item.button.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProduct = new UI.UI_Item.table.TableDark();
        btnImport = new UI.UI_Item.button.MyButton();
        cbCategory = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new UI.UI_Item.textfield.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("IMPORT");

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

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "1", "kg", "75000", "12"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Image", "Name", "Unit", "Price", "Amount"
            }
        ));
        tbProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(tbProduct);

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/import.png"))); // NOI18N
        btnImport.setText("IMPORT");
        btnImport.setBorderColor(new java.awt.Color(43, 147, 72));
        btnImport.setColor(new java.awt.Color(43, 147, 72));
        btnImport.setColorClick(new java.awt.Color(43, 147, 72));
        btnImport.setColorOver(new java.awt.Color(128, 185, 24));
        btnImport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 54, 66));
        jLabel2.setText("Amount:");

        txtAmount.setText("Enter Amount ...");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1)
                        .addGap(0, 267, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
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
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panel1MouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
        Category categorySelect = cateBLL.getCategory(cbCategory.getSelectedIndex() + 1);
        TableModel model = tbProduct.getModel();
        int row = tbProduct.getSelectedRow();
        Vegetable v = vegBLL.getVegetable(Integer.parseInt(model.getValueAt(row, 0).toString()));
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please choose one row in table!", "WARNING!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int VegetableID = Integer.parseInt(model.getValueAt(row, 0).toString());
                String Name = model.getValueAt(row, 1).toString();
                String Unit = model.getValueAt(row, 2).toString();
                Double Price = Double.parseDouble(model.getValueAt(row, 3).toString());
                int amountOld = Integer.parseInt(model.getValueAt(row, 4).toString());
                int amountAdd = Integer.parseInt(txtAmount.getText());

                v.setCatagory(categorySelect);
                v.setVegetableID(VegetableID);
                v.setVegetableName(Name);
                v.setUnit(Unit);
                v.setPrice(Price);
                v.setAmount(amountOld + amountAdd);
                v.setImage(v.getImage());
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to add the amount of this Vegetable?", "Warning!", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    if (vegBLL.updateVegetable(v) > 0) {
                        JOptionPane.showMessageDialog(this, "You have completed importing successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                        loadCategory();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ImportForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImportMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnImport;
    private UI.UI_Item.combobox.ComboBoxSuggestion cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.table.TableDark tbProduct;
    private UI.UI_Item.textfield.TextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
