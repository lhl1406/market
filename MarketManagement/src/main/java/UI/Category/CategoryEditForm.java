
package UI.Category;

import javax.swing.JOptionPane;
import BLL.CategoryBLL;
import hibernateMarket.DAL.Category;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoryEditForm extends javax.swing.JFrame {

    private CategoryBLL cateBLL = new CategoryBLL();
    private CategoryForm home = new CategoryForm();
    private  Category cate = new Category();
    public CategoryEditForm() {
        this.setTitle("Edit Category");
        initComponents();
    }
    public CategoryEditForm(int categoryID, CategoryForm parent, boolean modal) throws SQLException {
        this.setTitle("Edit Category");
        initComponents();
        this.setLocationRelativeTo(null);
        cate = cateBLL.getCategory(categoryID);
        home = parent;
        getInfor();
    }
    public void getInfor() {
        txtName.setText(cate.getName());
        txtDescription.setText(cate.getDescription());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new UI.UI_Item.textfield.TextField();
        txtDescription = new UI.UI_Item.textfield.TextField();
        btnUpdate = new UI.UI_Item.button.MyButton();
        btnBack = new UI.UI_Item.button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("EDIT CATEGORY");

        txtName.setText("Name ...");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtDescription.setText("Description ...");
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/diskette (1).png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorderColor(new java.awt.Color(43, 147, 72));
        btnUpdate.setColor(new java.awt.Color(43, 147, 72));
        btnUpdate.setColorClick(new java.awt.Color(43, 147, 72));
        btnUpdate.setColorOver(new java.awt.Color(128, 185, 24));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/Backicon.png"))); // NOI18N
        btnBack.setBorderColor(new java.awt.Color(210, 224, 191));
        btnBack.setColor(new java.awt.Color(210, 224, 191));
        btnBack.setColorClick(new java.awt.Color(210, 224, 191));
        btnBack.setColorOver(new java.awt.Color(210, 224, 191));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(232, 232, 232)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(txtDescription.getText().equals("") || txtName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Fields must not empty",
               "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        else{
            cate.setName(txtName.getText());
        cate.setDescription(txtDescription.getText());
        
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to update this Category?", "Warning!", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            } else {
                if (cateBLL.updateCategory(cate) > 0) {
                    JOptionPane.showMessageDialog(this, "You have completed to update Category successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                    home.loadCategoryTable();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryEditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.textfield.TextField txtDescription;
    private UI.UI_Item.textfield.TextField txtName;
    // End of variables declaration//GEN-END:variables
}
