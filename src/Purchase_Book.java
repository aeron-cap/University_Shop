import com.formdev.flatlaf.intellijthemes.*;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.*;

public class Purchase_Book extends javax.swing.JFrame {

    /**
     * Creates new form Purchase_Book
     */

    public Purchase_Book() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    String SR, NAME, LASTNAME, MIDDLENAME;

    public void sales() {
        int lastid = 0;

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");

            String total = amountToPayLbl.getText();
            String srcode = srOfUser.getText();

            String querys = "insert into sales(srcode, Balance, Date)values(?,?,?)";
            PreparedStatement pstsales = con.prepareStatement(querys, Statement.RETURN_GENERATED_KEYS);
            pstsales.setString(1, srcode);
            pstsales.setString(2, total);
            pstsales.setString(3, dtf.format(now));
            pstsales.executeUpdate();
            ResultSet rss = pstsales.getGeneratedKeys();

            if (rss.next()) {
                lastid = rss.getInt(1);
            }
            DefaultTableModel model = (DefaultTableModel) bookDisplayBuy.getModel();

            String query = "insert into admin_sales(srcode, Name, Quantity, Date, Status)values(?,?,?,?,?)";

            String usersrcode = srOfUser.getText();
            System.out.println(usersrcode);

            for (int i = 0; i < model.getRowCount(); i++) {
                String prodname = (String) model.getValueAt(i, 1);
                // int qty = (int) model.getValueAt(i, 2);
                PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, usersrcode);
                pst.setString(2, prodname);
                pst.setInt(3, 1);
                pst.setString(4, dtf.format(now));
                pst.setString(5, "false");
                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Order has been placed. Please print the invoice as proof of order.");

        } catch (SQLException ex) {
            Logger.getLogger(uniform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(uniform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Purchase_Book(ArrayList<String> purchasedSubjCode, ArrayList<String> purchasedBookTitle,
            ArrayList<Integer> purchaseInfoPrice, ArrayList<Integer> bookStock, String str, String name, String lName) {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage();

        this.SR = str;
        this.NAME = name;
        this.LASTNAME = lName;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        nameLabel.setText(LASTNAME + ", " + NAME + " " + " | ");
        srOfUser.setText(SR);
        subheadTime.setText(String.valueOf(dtf.format(now)));

        headerConfOrder.setText(NAME.toUpperCase() + "'S BOOK ORDER FORM");

        int totalAmountToPay = 0;

        DefaultTableModel displayBook = (DefaultTableModel) bookDisplayBuy.getModel();
        try {
            for (int row = 0; row < purchaseInfoPrice.size(); row++) {
                String code = purchasedSubjCode.get(row);
                String bookTitle = purchasedBookTitle.get(row);

                int bookPrice = purchaseInfoPrice.get(row);
                Object[] data = { row + 1, code, bookTitle, bookPrice };
                displayBook.addRow(data);
            }
            for (int amount = 0; amount < purchaseInfoPrice.size(); amount++) {
                totalAmountToPay += purchaseInfoPrice.get(amount);
            }
            amountToPayLbl.setText(String.valueOf(totalAmountToPay));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bookReceipt() {
        String totalAmountToPay = amountToPayLbl.getText();
        DefaultTableModel displayBook = (DefaultTableModel) bookDisplayBuy.getModel();
        int rowCount = displayBook.getRowCount();

        bookReceipt.setText(
                bookReceipt.getText() + "**********************************************************************\n");
        bookReceipt.setText(bookReceipt.getText()
                + "                                   Republic of the Philippines                 \n");
        bookReceipt.setText(
                bookReceipt.getText() + "                                BATANGAS STATE UNIVERSITY                 \n");
        bookReceipt.setText(
                bookReceipt.getText() + "                           The National Engineering University            \n");
        bookReceipt.setText(bookReceipt.getText()
                + "                                Rizal Ave, Extension, Batangas               \n");
        bookReceipt.setText(bookReceipt.getText()
                + "                                       UNIVERSITY SHOP                      \n");
        bookReceipt.setText(
                bookReceipt.getText() + "**********************************************************************\n");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        bookReceipt.setText(bookReceipt.getText() + "SR-CODE:              |  " + SR + "\n");
        bookReceipt.setText(
                bookReceipt.getText() + "**********************************************************************\n");
        bookReceipt.setText(bookReceipt.getText() + "Date and Time of order:                                    "
                + dtf.format(now) + "\n\n");

        bookReceipt.setText(bookReceipt.getText()
                + "               --------------------- BOOKS -------------------              \n");
        bookReceipt.setText(bookReceipt.getText() + "SUBJECT CODE" + "\t\t" + "QUANTITY " + "\t" + "PRICE" + "\n");

        for (int i = 0; i < rowCount; i++) {

            String subjCode = displayBook.getValueAt(i, 1).toString();
            int quantity = 1;
            int bookPrice = Integer.valueOf(displayBook.getValueAt(i, 3).toString());
            bookReceipt
                    .setText(bookReceipt.getText() + subjCode + "\t\t" + quantity + "\t" + "Php " + bookPrice + "\n");
        }

        bookReceipt.setText(bookReceipt.getText()
                + "               ----------------- End of List -----------------              \n\n");
        bookReceipt.setText(bookReceipt.getText() + "TOTAL" + "\t\t\t" + "Php " + totalAmountToPay + "\n\n");
        bookReceipt.setText(bookReceipt.getText()
                + "************************* END OF RECEIPT *************************             \n\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bookDisplayBuy = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        confirmOrderBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        amountToPayLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookReceipt = new javax.swing.JTextArea();
        invoiceBtn = new javax.swing.JButton();
        orderAgainBtn = new javax.swing.JButton();
        headerConfOrder = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        subhead = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        srOfUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subheadTime = new javax.swing.JLabel();
        backToBookBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Checkout for Books");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }

            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        bookDisplayBuy.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Subject Code", "Book Title", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        bookDisplayBuy.setRowHeight(25);
        jScrollPane1.setViewportView(bookDisplayBuy);
        if (bookDisplayBuy.getColumnModel().getColumnCount() > 0) {
            bookDisplayBuy.getColumnModel().getColumn(0).setResizable(false);
            bookDisplayBuy.getColumnModel().getColumn(0).setPreferredWidth(3);
            bookDisplayBuy.getColumnModel().getColumn(1).setResizable(false);
            bookDisplayBuy.getColumnModel().getColumn(1).setPreferredWidth(75);
            bookDisplayBuy.getColumnModel().getColumn(2).setResizable(false);
            bookDisplayBuy.getColumnModel().getColumn(2).setPreferredWidth(425);
            bookDisplayBuy.getColumnModel().getColumn(3).setResizable(false);
            bookDisplayBuy.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book_confirm.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        confirmOrderBtn.setBackground(new java.awt.Color(204, 11, 11));
        confirmOrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmOrderBtn.setText("PLACE ORDER");
        confirmOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmOrderBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("TOTAL AMOUNT TO PAY:     Php");

        amountToPayLbl.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        amountToPayLbl.setText("0");

        bookReceipt.setEditable(false);
        bookReceipt.setColumns(20);
        bookReceipt.setRows(5);
        jScrollPane2.setViewportView(bookReceipt);

        invoiceBtn.setBackground(new java.awt.Color(51, 51, 51));
        invoiceBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        invoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        invoiceBtn.setText("PRINT INVOICE");
        invoiceBtn.setEnabled(false);
        invoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBtnActionPerformed(evt);
            }
        });

        orderAgainBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderAgainBtn.setText("Order Again");
        orderAgainBtn.setEnabled(false);
        orderAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderAgainBtnActionPerformed(evt);
            }
        });

        headerConfOrder.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        headerConfOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerConfOrder.setText("[NAME]'S BOOK ORDER FORM");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Your Receipt");

        footer.setBackground(new java.awt.Color(9, 9, 9));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("BATANGAS STATE UNIVERSITY, THE NATIONAL ENGINEERING UNIVERSITY © 2022 ");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
                footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        footerLayout.setVerticalGroup(
                footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));

        subhead.setBackground(new java.awt.Color(153, 153, 153));

        nameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("LASTNAME, FIRSTNAME | ");

        srOfUser.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        srOfUser.setForeground(new java.awt.Color(255, 255, 255));
        srOfUser.setText("SR-CODES");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ACCOUNT LOGGED IN:");

        subheadTime.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        subheadTime.setForeground(new java.awt.Color(255, 255, 255));
        subheadTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subheadTime.setText("HR:MINUTE");

        javax.swing.GroupLayout subheadLayout = new javax.swing.GroupLayout(subhead);
        subhead.setLayout(subheadLayout);
        subheadLayout.setHorizontalGroup(
                subheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subheadLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(srOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subheadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)));
        subheadLayout.setVerticalGroup(
                subheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subheadLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(subheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(srOfUser)
                                        .addComponent(subheadTime))
                                .addContainerGap()));

        backToBookBtn.setText("Back");
        backToBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToBookBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subhead, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(headerConfOrder, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(jLabel2)
                                                .addGap(17, 17, 17)
                                                .addComponent(amountToPayLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addComponent(backToBookBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(confirmOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(invoiceBtn,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 149,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(orderAgainBtn,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 149,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(footer, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(subhead, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(headerConfOrder, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(amountToPayLbl))
                                                .addGap(22, 22, 22)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(confirmOrderBtn,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 53,
                                                                Short.MAX_VALUE)
                                                        .addComponent(backToBookBtn,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(8, 8, 8)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(invoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(orderAgainBtn)))
                                .addGap(26, 26, 26)
                                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_orderAgainBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Books(LASTNAME, NAME, MIDDLENAME, SR).setVisible(true);
    }// GEN-LAST:event_orderAgainBtnActionPerformed

    private void confirmOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_confirmOrderBtnActionPerformed
        // TODO add your handling code here:
        bookReceipt.setText("");
        bookReceipt();
        sales();
        invoiceBtn.setEnabled(true);
        orderAgainBtn.setEnabled(true);
    }// GEN-LAST:event_confirmOrderBtnActionPerformed

    private void invoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_invoiceBtnActionPerformed
        // TODO add your handling code here:
        try {
            bookReceipt.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_invoiceBtnActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        srOfUser.setText(SR);
    }// GEN-LAST:event_formWindowGainedFocus

    private void backToBookBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backToBookBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Books(LASTNAME, NAME, MIDDLENAME, SR).setVisible(true);
    }// GEN-LAST:event_backToBookBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        // </editor-fold>

        try {
            FlatArcIJTheme.setup();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase_Book().setVisible(true);
            }
        });
    }

    private void setIconImage() { // Setting the icon of the program
        URL iconUrl = this.getClass().getResource("images/univ_shop_icon.png");
        Toolkit tk = this.getToolkit();
        setIconImage(tk.getImage(iconUrl));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountToPayLbl;
    private javax.swing.JButton backToBookBtn;
    private javax.swing.JTable bookDisplayBuy;
    private javax.swing.JTextArea bookReceipt;
    private javax.swing.JButton confirmOrderBtn;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel headerConfOrder;
    private javax.swing.JButton invoiceBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton orderAgainBtn;
    private javax.swing.JLabel srOfUser;
    private javax.swing.JPanel subhead;
    private javax.swing.JLabel subheadTime;
    // End of variables declaration//GEN-END:variables
}
