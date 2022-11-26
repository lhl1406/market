/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Statistical;

import BLL.CategoryBLL;
import BLL.StatisticalBLL;
import UI.MenuForm;
import hibernateMarket.DAL.Category;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class ForProductForm extends javax.swing.JFrame {

    StatisticalBLL sbll = new StatisticalBLL();
    CategoryBLL cbll = new CategoryBLL();
    MenuForm home;
    List<Object[][]> data = null;

    /**
     * Creates new form ForProductForm
     */
    public ForProductForm() throws SQLException {
        initComponents();
        init();
        initTable();
        LoadCbOrderID();
        this.setLocationRelativeTo(null);
        this.home = new MenuForm();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(home.DISPOSE_ON_CLOSE);
                home.setVisible(true);
            }
        });

    }

    public void initTable() throws SQLException {
        try {
            LoadStatisticalForProduct();
        } catch (Exception ex) {
            Logger.getLogger(ForProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void init() {
        data = sbll.statisticalForProduct("2021-08-15", "2022-08-16", -1);
        tbStatistical.fixTable(jScrollPane2);
    }

    public void LoadCbOrderID() {
        List<Category> ListO = cbll.loadCategory();
        for (int i = 0; i < ListO.size(); i++) {
            cbCategory.addItem(ListO.get(i).getCatagoryID());
        }
    }
     private void setTotal() {
        int length = tbStatistical.getRowCount();
        TableModel model = tbStatistical.getModel();
        float total = 0;
        for(int i = 0; i< length; i++) {
            total += Float.parseFloat(model.getValueAt(i, 4).toString());
        }
        txtSumTotal.setText(total + "vnd");
    }

    public void LoadStatisticalForProduct() throws Exception {
//        data = sbll.statisticalForProduct("2021-08-15", "2022-08-16", -1);
        DefaultTableModel model = convertSatistical(data);
        tbStatistical.setModel(model);
        setTotal();

    }



    private DefaultTableModel convertSatistical(List<Object[][]> dataStatistical) {
        String[] columnNames = {"OrderID", "Name", "Quantity", "Price", "Total", "CustomerID", "Date"};
        int lenght = dataStatistical.size();
        int i = 0;
        Object data[][];
        data = new Object[lenght][7];
        for (Object aRow[] : dataStatistical) {
            data[i][0] = aRow[0];
            data[i][1] = aRow[1];
            data[i][2] = aRow[2];
            data[i][3] = aRow[3];
            data[i][4] = aRow[4];
            data[i][5] = aRow[5];
            data[i][6] = aRow[6];
            if (i < lenght) {
                i = i + 1;
            } else {
                break;
            }
        }
        return new DefaultTableModel(data, columnNames);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new UI.UI_Item.button.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new UI.UI_Item.button.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbStatistical = new UI.UI_Item.table.TableDark();
        btnView = new UI.UI_Item.button.MyButton();
        cbCategory = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtSumTotal = new UI.UI_Item.textfield.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFromTime = new UI.UI_Item.textfield.TextField();
        jLabel8 = new javax.swing.JLabel();
        txtToTime = new UI.UI_Item.textfield.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(210, 224, 191));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 54, 66));
        jLabel1.setText("STATISTICAL FOR PRODUCT");

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

        tbStatistical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Name", "Quantity", "Price", "Total", "Customer ID", "Date"
            }
        ));
        tbStatistical.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(tbStatistical);

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/file.png"))); // NOI18N
        btnView.setText("VIEW");
        btnView.setBorderColor(new java.awt.Color(43, 147, 72));
        btnView.setColor(new java.awt.Color(43, 147, 72));
        btnView.setColorClick(new java.awt.Color(43, 147, 72));
        btnView.setColorOver(new java.awt.Color(128, 185, 24));
        btnView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewMouseClicked(evt);
            }
        });

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "all" }));
        cbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoryItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 54, 66));
        jLabel2.setText("Sum total:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(20, 54, 66));
        jLabel7.setText("Time:");

        txtFromTime.setText("yyyy-mm-dd");
        txtFromTime.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtFromTimeInputMethodTextChanged(evt);
            }
        });
        txtFromTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFromTimeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("-");

        txtToTime.setText("yyyy-mm-dd");
        txtToTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(txtToTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(88, 88, 88)
                                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addComponent(jScrollPane2)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1)
                                .addGap(0, 81, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(11, 11, 11)
                                .addComponent(txtSumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtToTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
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

    private void txtFromTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFromTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFromTimeActionPerformed

    private void txtToTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToTimeActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
   
    private void cbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoryItemStateChanged
        String txtFrom = "2021-08-15";
        String txtTo = "2022-08-16";
        String Regex = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        
        if (txtFromTime.getText().matches(Regex) && txtToTime.getText().matches(Regex)) {
            txtFrom = txtFromTime.getText();
            txtTo = txtToTime.getText();
        }
       
        if (cbCategory.getSelectedItem().toString().equals("all")) {
            try {
                data = sbll.statisticalForProduct(txtFrom, txtTo, -1);
            } catch (Exception ex) {
                Logger.getLogger(ForProductForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                data = sbll.statisticalForProduct(txtFrom, txtTo, Integer.parseInt(cbCategory.getSelectedItem().toString()));
            } catch (Exception ex) {
                Logger.getLogger(ForProductForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            LoadStatisticalForProduct();
        } catch (Exception ex) {
            Logger.getLogger(ForProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = convertSatistical(data);
        tbStatistical.setModel(model);
    }//GEN-LAST:event_cbCategoryItemStateChanged

    private void btnViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMouseClicked
        // xử lý k nhập hoặc sai
        String txtFrom = "2021-08-15";
        String txtTo = "2022-08-16";
        String Regex = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        
        if (txtFromTime.getText().matches(Regex) && txtToTime.getText().matches(Regex)) {
            
            txtFrom = txtFromTime.getText();
            txtTo = txtToTime.getText();
        } else {
             JOptionPane.showMessageDialog(this, "Error Format {yyyy/mm/dd}", "message", JOptionPane.ERROR_MESSAGE);
             return;
        }
        int CategoryID = -1;
        if (!cbCategory.getSelectedItem().toString().equals("all")) {
            CategoryID = Integer.parseInt(cbCategory.getSelectedItem().toString());
        }
        data = sbll.statisticalForProduct(txtFrom, txtTo, CategoryID);
        DefaultTableModel model = convertSatistical(data);
        tbStatistical.setModel(model);
        setTotal();
    }//GEN-LAST:event_btnViewMouseClicked

    private void txtFromTimeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtFromTimeInputMethodTextChanged

        
    }//GEN-LAST:event_txtFromTimeInputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(ForProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ForProductForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ForProductForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnBack;
    private UI.UI_Item.button.MyButton btnView;
    private UI.UI_Item.combobox.ComboBoxSuggestion cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private UI.UI_Item.button.Panel panel1;
    private UI.UI_Item.table.TableDark tbStatistical;
    private UI.UI_Item.textfield.TextField txtFromTime;
    private UI.UI_Item.textfield.TextField txtSumTotal;
    private UI.UI_Item.textfield.TextField txtToTime;
    // End of variables declaration//GEN-END:variables

    private void setTotal(List<Object[][]> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
