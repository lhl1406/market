package UI.Vegetable;

import javax.swing.JOptionPane;
import BLL.CategoryBLL;
import BLL.VegetableBLL;
import hibernateMarket.DAL.Category;
import hibernateMarket.DAL.Vegetable;
import java.io.File;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class VegetableAddForm extends javax.swing.JFrame {

    private VegetableBLL vegBLL;
    private VegetableForm home = new VegetableForm();
    private CategoryBLL cateBLL = new CategoryBLL();
    public VegetableAddForm() {
        this.setTitle("Add Vegetable");
        initComponents();
        loadCombobox();
        vegBLL = new VegetableBLL();
        //home = new VegetableForm();
        
    }
    private void loadCombobox() {
        List<Category> listCategory;
            listCategory = cateBLL.loadCategory();           
            for (int i = 0; i < listCategory.size(); i++) {
                cbCateID.addItem(listCategory.get(i).getCatagoryID()); //load combobox CategoryName
            }              
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        txtVegetableName = new UI.UI_Item.textfield.TextField();
        btnSave = new UI.UI_Item.button.MyButton();
        btnBack = new UI.UI_Item.button.MyButton();
        txtUnit = new UI.UI_Item.textfield.TextField();
        txtAmount = new UI.UI_Item.textfield.TextField();
        txtPrice = new UI.UI_Item.textfield.TextField();
        btnFile = new UI.UI_Item.button.MyButton();
        txtLinkImage = new UI.UI_Item.textfield.TextField();
        cbCateID = new UI.UI_Item.combobox.ComboBoxSuggestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("ADD VEGETABLE");

        txtVegetableName.setText("Vegetable Name ...");
        txtVegetableName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVegetableNameActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/diskette (1).png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setBorderColor(new java.awt.Color(43, 147, 72));
        btnSave.setColor(new java.awt.Color(43, 147, 72));
        btnSave.setColorClick(new java.awt.Color(43, 147, 72));
        btnSave.setColorOver(new java.awt.Color(128, 185, 24));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        txtUnit.setText("Unit ...");
        txtUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitActionPerformed(evt);
            }
        });

        txtAmount.setText("0");
        txtAmount.setEnabled(false);
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        txtPrice.setText("Price ...");
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnFile.setBackground(new java.awt.Color(255, 255, 255));
        btnFile.setForeground(new java.awt.Color(0, 0, 0));
        btnFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/chooseImage.png"))); // NOI18N
        btnFile.setText("File");
        btnFile.setColor(new java.awt.Color(255, 255, 255));
        btnFile.setColorClick(new java.awt.Color(255, 255, 255));
        btnFile.setColorOver(new java.awt.Color(255, 255, 255));
        btnFile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFileMouseClicked(evt);
            }
        });

        txtLinkImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLinkImageActionPerformed(evt);
            }
        });

        cbCateID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CateID", " " }));

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
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVegetableName, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(txtUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtLinkImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cbCateID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbCateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVegetableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLinkImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void txtVegetableNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVegetableNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVegetableNameActionPerformed

    private void txtUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtLinkImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLinkImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLinkImageActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtAmount.getText().equals("") 
                || txtLinkImage.getText().equals("") 
                || txtPrice.getText().equals("") 
                || txtUnit.getText().equals("") 
                || txtVegetableName.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Fields must not empty",
                       "WARNING", JOptionPane.WARNING_MESSAGE);
        }else{
            Vegetable v = new Vegetable(); 
        int lastID = vegBLL.getLastID();
        int newID = lastID+1;
        //int VegID = Integer.parseInt(txtVegetableID.getText());
        v.setVegetableID(newID);
        
        Category cate = new Category();
        String CateID = String.valueOf(cbCateID.getSelectedItem());
        cate.CatagoryID= Integer.parseInt(CateID);
        v.setCatagory(cate);
        
        v.setVegetableName(txtVegetableName.getText());
        v.setUnit(txtUnit.getText());
        v.setAmount(0);
        v.setImage(txtLinkImage.getText());
        Double price = Double.parseDouble(txtPrice.getText());
        v.setPrice(price);
           
        try {
            if (vegBLL.addVegetable(v)>0) {
                JOptionPane.showMessageDialog(this, "You have completed to add Vegetable successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                home.initTable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VegetableAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileMouseClicked
       JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);// chỉ hiển thị file
        int res = file.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION ){
            File f = file.getSelectedFile();
            
            String pathFile = f.getAbsolutePath();
            String name = f.getName();
            //txtLinkImage.setText(getPath(pathFile)+"\\"+ name);
            txtLinkImage.setText("images/"+ name);
        }
    }//GEN-LAST:event_btnFileMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VegetableAddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnFile;
    private UI.UI_Item.button.MyButton btnSave;
    private UI.UI_Item.combobox.ComboBoxSuggestion cbCateID;
    private javax.swing.JLabel jLabel1;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.textfield.TextField txtAmount;
    private UI.UI_Item.textfield.TextField txtLinkImage;
    private UI.UI_Item.textfield.TextField txtPrice;
    private UI.UI_Item.textfield.TextField txtUnit;
    private UI.UI_Item.textfield.TextField txtVegetableName;
    // End of variables declaration//GEN-END:variables
}
