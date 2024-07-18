
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

public class AdminHome extends javax.swing.JFrame {
    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        show_userU();
        setIconImage();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");
            // fll table of admin_Sales
            Statement st = con.createStatement();
            String sql = "select * from admin_sales";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel orderTable = (DefaultTableModel) ordersTable.getModel();

            while (rs.next()) {
                // add data
                String id = String.valueOf(rs.getInt("ID"));
                String sr = rs.getString("srcode");
                String names = rs.getString("Name");
                String qua = rs.getString("Quantity");
                String date = String.valueOf(rs.getString("Date"));
                String bool = String.valueOf(rs.getString("Status"));

                boolean bol = Boolean.parseBoolean(bool);

                Object orderList[] = { id, sr, names, qua, date, bol };
                orderTable.addRow(orderList);
            }
            // fill table with sales
            Statement stS = con.createStatement();
            String sqlS = "select * from sales";
            ResultSet rsS = stS.executeQuery(sqlS);
            DefaultTableModel STable = (DefaultTableModel) salesTable.getModel();

            while (rsS.next()) {
                // add data
                String idS = String.valueOf(rsS.getInt("ID"));
                String srS = rsS.getString("srcode");
                String balS = rsS.getString("Balance");
                String dateS = rsS.getString("Date");

                String salesList[] = { idS, srS, balS, dateS };
                STable.addRow(salesList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");
            // fll table of admin_Sales

            int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();
            System.out.println(gradeLevelIndex);

            // fill table for college books
            Statement stB = con.createStatement();

            String sqlB = "select * from books_c_gencourse";
            ResultSet rsB = stB.executeQuery(sqlB);
            DefaultTableModel BTable = (DefaultTableModel) collegeBooks.getModel();
            BTable.setNumRows(0);

            while (rsB.next()) {
                // add data
                String idB = String.valueOf(rsB.getInt("ID"));
                String codeB = rsB.getString("code");
                String titleB = rsB.getString("name");
                String stockB = rsB.getString("stock");
                String priceB = rsB.getString("price");

                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                BTable.addRow(booksList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // code to ge the values of the database table and display it on the table
    // for uniform
    public ArrayList<UserU> userListU() {
        ArrayList<UserU> usersList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false",
                    "root", "");

            String c_uniform = "SELECT * FROM availability_C_uniform";
            Statement stmCU = con.createStatement();
            ResultSet resCU = stmCU.executeQuery(c_uniform);

            UserU userC;
            while (resCU.next()) {
                userC = new UserU(resCU.getInt("ID"), resCU.getString("Uniform"), resCU.getInt("Quantity"),
                        resCU.getDouble("Price"));
                usersList.add(userC);
            }
        } catch (Exception e) {

        }
        return usersList;
    }

    public void show_userU() {
        ArrayList<UserU> listCU = userListU();

        DefaultTableModel modelCU = (DefaultTableModel) collegeUniform.getModel();

        Object[] rowCU = new Object[4];
        for (int i = 0; i < listCU.size(); i++) {
            rowCU[0] = listCU.get(i).getidCU();
            rowCU[1] = listCU.get(i).getUniform();
            rowCU[2] = listCU.get(i).getQuantityU();
            rowCU[3] = listCU.get(i).getPriceCU();
            modelCU.addRow(rowCU);
        }
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

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        uniClear = new javax.swing.JButton();
        uniDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        uniformText = new javax.swing.JTextField();
        uniformQuantity = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        uniUpdate = new javax.swing.JButton();
        uniAdd = new javax.swing.JButton();
        uniformPrice = new javax.swing.JFormattedTextField();
        uniformID = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        collegeUniform = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bookAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bookTitle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bookID = new javax.swing.JFormattedTextField();
        bookDelete = new javax.swing.JButton();
        bookClear = new javax.swing.JButton();
        bookQuantity = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        bookPrice = new javax.swing.JFormattedTextField();
        bookUpdate = new javax.swing.JButton();
        codeBook = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        booksTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        collegeBooks = new javax.swing.JTable();
        collegeBookSwitch = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        shsBooks = new javax.swing.JTable();
        shsBooksSwitch = new javax.swing.JComboBox<>();
        shsSemSwitch = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        hsBookSwitch = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        hsBooks = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Controls");

        uniClear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        uniClear.setText("CLEAR");
        uniClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniClearActionPerformed(evt);
            }
        });

        uniDelete.setBackground(new java.awt.Color(255, 0, 0));
        uniDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        uniDelete.setForeground(new java.awt.Color(255, 255, 255));
        uniDelete.setText("DELETE");
        uniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniDeleteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Uniform");

        uniformText.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        uniformQuantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        uniformQuantity.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Stock");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("ID");

        uniUpdate.setBackground(new java.awt.Color(246, 215, 27));
        uniUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        uniUpdate.setText("UPDATE");
        uniUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniUpdateActionPerformed(evt);
            }
        });

        uniAdd.setBackground(new java.awt.Color(99, 207, 22));
        uniAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        uniAdd.setText("ADD");
        uniAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniAddActionPerformed(evt);
            }
        });

        uniformPrice.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        uniformPrice.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        uniformID.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        uniformID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        collegeUniform.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        collegeUniform.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Uniform", "Stock", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        collegeUniform.setToolTipText("");
        collegeUniform.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        collegeUniform.getTableHeader().setResizingAllowed(false);
        collegeUniform.getTableHeader().setReorderingAllowed(false);
        collegeUniform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collegeUniformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(collegeUniform);
        if (collegeUniform.getColumnModel().getColumnCount() > 0) {
            collegeUniform.getColumnModel().getColumn(0).setMinWidth(60);
            collegeUniform.getColumnModel().getColumn(0).setMaxWidth(60);
            collegeUniform.getColumnModel().getColumn(1).setResizable(false);
            collegeUniform.getColumnModel().getColumn(2).setMinWidth(60);
            collegeUniform.getColumnModel().getColumn(2).setMaxWidth(60);
            collegeUniform.getColumnModel().getColumn(3).setMinWidth(60);
            collegeUniform.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel10Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel6))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(uniformText,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                159,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(uniformQuantity,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                159,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(uniformPrice,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                159,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(uniformID,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                159,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(uniAdd,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(uniClear))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(uniUpdate,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(uniDelete,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uniformID, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(uniformText, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(uniformQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(uniformPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(uniAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addComponent(uniUpdate, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uniDelete)
                                        .addComponent(uniClear))
                                .addContainerGap()));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        jLabel1.setText("UNIFORMS");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        jLabel2.setText("BOOKS");

        bookAdd.setBackground(new java.awt.Color(99, 207, 22));
        bookAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bookAdd.setText("ADD");
        bookAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAddActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Book Title");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Code");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("ID");

        bookID.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        bookDelete.setBackground(new java.awt.Color(255, 0, 0));
        bookDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bookDelete.setText("DELETE");
        bookDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookDeleteActionPerformed(evt);
            }
        });

        bookClear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bookClear.setText("CLEAR");
        bookClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookClearActionPerformed(evt);
            }
        });

        bookQuantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Price");

        bookPrice.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        bookUpdate.setBackground(new java.awt.Color(246, 215, 27));
        bookUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bookUpdate.setText("UPDATE");
        bookUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookUpdateActionPerformed(evt);
            }
        });

        codeBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeBookActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Stock");

        booksTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTabMouseClicked(evt);
            }
        });

        collegeBooks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        collegeBooks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Code", "Book Title", "Stock", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        collegeBooks.setShowGrid(false);
        collegeBooks.getTableHeader().setResizingAllowed(false);
        collegeBooks.getTableHeader().setReorderingAllowed(false);
        collegeBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collegeBooksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(collegeBooks);
        if (collegeBooks.getColumnModel().getColumnCount() > 0) {
            collegeBooks.getColumnModel().getColumn(0).setMinWidth(30);
            collegeBooks.getColumnModel().getColumn(0).setMaxWidth(30);
            collegeBooks.getColumnModel().getColumn(1).setMinWidth(70);
            collegeBooks.getColumnModel().getColumn(1).setMaxWidth(70);
            collegeBooks.getColumnModel().getColumn(3).setMinWidth(50);
            collegeBooks.getColumnModel().getColumn(3).setMaxWidth(50);
            collegeBooks.getColumnModel().getColumn(4).setMinWidth(50);
            collegeBooks.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        collegeBookSwitch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Technical " }));
        collegeBookSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeBookSwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(collegeBookSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(collegeBookSwitch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        booksTab.addTab("College", jPanel1);

        shsBooks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        shsBooks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Code", "Book Title", "Stock", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        shsBooks.setShowGrid(false);
        shsBooks.getTableHeader().setResizingAllowed(false);
        shsBooks.getTableHeader().setReorderingAllowed(false);
        shsBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shsBooksMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(shsBooks);
        if (shsBooks.getColumnModel().getColumnCount() > 0) {
            shsBooks.getColumnModel().getColumn(0).setMinWidth(30);
            shsBooks.getColumnModel().getColumn(0).setMaxWidth(30);
            shsBooks.getColumnModel().getColumn(1).setMinWidth(70);
            shsBooks.getColumnModel().getColumn(1).setMaxWidth(70);
            shsBooks.getColumnModel().getColumn(3).setMinWidth(50);
            shsBooks.getColumnModel().getColumn(3).setMaxWidth(50);
            shsBooks.getColumnModel().getColumn(4).setMinWidth(50);
            shsBooks.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        shsBooksSwitch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G12", "G11" }));
        shsBooksSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shsBooksSwitchActionPerformed(evt);
            }
        });

        shsSemSwitch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Sem", "2nd Sem" }));
        shsSemSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shsSemSwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(shsBooksSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shsSemSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(shsBooksSwitch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(shsSemSwitch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        booksTab.addTab("Senior High", jPanel5);

        hsBookSwitch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G10", "G9", "G8", "G7" }));
        hsBookSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hsBookSwitchActionPerformed(evt);
            }
        });

        hsBooks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        hsBooks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Code", "Book Title", "Stock", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        hsBooks.setShowGrid(false);
        hsBooks.getTableHeader().setResizingAllowed(false);
        hsBooks.getTableHeader().setReorderingAllowed(false);
        hsBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hsBooksMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(hsBooks);
        if (hsBooks.getColumnModel().getColumnCount() > 0) {
            hsBooks.getColumnModel().getColumn(0).setMinWidth(30);
            hsBooks.getColumnModel().getColumn(0).setMaxWidth(30);
            hsBooks.getColumnModel().getColumn(1).setMinWidth(70);
            hsBooks.getColumnModel().getColumn(1).setMaxWidth(70);
            hsBooks.getColumnModel().getColumn(3).setMinWidth(50);
            hsBooks.getColumnModel().getColumn(3).setMaxWidth(50);
            hsBooks.getColumnModel().getColumn(4).setMinWidth(50);
            hsBooks.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(hsBookSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE));
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hsBookSwitch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        booksTab.addTab("High School", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel2Layout.createSequentialGroup()
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(booksTab, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(bookID,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bookPrice,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(bookQuantity,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(codeBook,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(bookTitle,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(bookAdd,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(bookClear))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(bookDelete,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(bookUpdate,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(booksTab, javax.swing.GroupLayout.PREFERRED_SIZE, 247,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(codeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bookID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bookPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookAdd)
                                        .addComponent(bookUpdate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookDelete)
                                        .addComponent(bookClear))
                                .addGap(22, 22, 22)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel9Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jLabel2))
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(21, Short.MAX_VALUE)));
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jScrollPane8.setViewportView(jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 0, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin_order-sale_red.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "SR Code", "Items", "Quantity", "Date", "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        ordersTable.setColumnSelectionAllowed(true);
        ordersTable.getTableHeader().setReorderingAllowed(false);
        ordersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ordersTable);
        ordersTable.getColumnModel().getSelectionModel()
                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (ordersTable.getColumnModel().getColumnCount() > 0) {
            ordersTable.getColumnModel().getColumn(0).setMinWidth(30);
            ordersTable.getColumnModel().getColumn(0).setMaxWidth(30);
            ordersTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            ordersTable.getColumnModel().getColumn(3).setPreferredWidth(35);
            ordersTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            ordersTable.getColumnModel().getColumn(5).setMinWidth(40);
            ordersTable.getColumnModel().getColumn(5).setMaxWidth(40);
        }

        jLabel111.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel111.setText("Orders");

        jLabel112.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel112.setText("Sales");

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "SR Code", "Balance", "Date"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        salesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(salesTable);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(0).setPreferredWidth(2);
            salesTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            salesTable.getColumnModel().getColumn(2).setPreferredWidth(65);
            salesTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel111)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel11Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 462,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 462,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel112))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header_admin.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin_manage.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        logoutBtn.setBackground(new java.awt.Color(0, 0, 0));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane8)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(179, 179, 179)
                                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 31, Short.MAX_VALUE)
                                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)))
                                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }// GEN-LAST:event_logoutBtnActionPerformed

    private void uniAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_uniAddActionPerformed
        // TODO add your handling code here:
        // to add values from text field to table to database
        DefaultTableModel model = (DefaultTableModel) collegeUniform.getModel();

        if (uniformText.getText().equals("") || uniformQuantity.getText().equals("")
                || uniformPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Complete empty fields");
        } else {
            try {
                String data[] = { uniformID.getText(), uniformText.getText(), uniformQuantity.getText(),
                        uniformPrice.getText() };

                String id = uniformID.getText();
                String unif = uniformText.getText();
                String qua = uniformQuantity.getText();
                String price = uniformPrice.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false",
                        "root", "");

                String check = "SELECT * from availability_c_uniform WHERE ID = ? OR Uniform = ?";
                final PreparedStatement ps = con.prepareStatement(check);
                ps.setString(1, id);
                ps.setString(2, unif);
                final ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                    uniformID.setText("");
                    uniformText.setText("");
                } else {
                    model.addRow(data);
                    String sql = "INSERT INTO availability_c_uniform (ID, Uniform, Quantity, Price) VALUES ('" + id
                            + "', '" + unif + "', '" + qua + "', '" + price + "')";
                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                    preparedStmt.execute();

                    con.close();

                    JOptionPane.showMessageDialog(this, "Data added");

                    uniformID.setText("");
                    uniformText.setText("");
                    uniformQuantity.setText("");
                    uniformPrice.setText("");
                }
            } catch (Exception e) {
            }
        }
    }// GEN-LAST:event_uniAddActionPerformed

    private void uniDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_uniDeleteActionPerformed
        // TODO add your handling code here:

        // to delete a selected row
        DefaultTableModel model = (DefaultTableModel) collegeUniform.getModel();
        if (collegeUniform.getSelectedRowCount() == 1) {
            try {
                String unif = uniformText.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false",
                        "root", "");

                String sql = "DELETE FROM availability_c_uniform WHERE Uniform = '" + unif + "' ";
                PreparedStatement preparedStmt = con.prepareStatement(sql);

                preparedStmt.execute();

                con.close();

                JOptionPane.showMessageDialog(this, "Row Deleted");
                uniformID.setText("");
                uniformText.setText("");
                uniformQuantity.setText("");
                uniformPrice.setText("");

                model.removeRow(collegeUniform.getSelectedRow());

            } catch (Exception e) {
            }
        } else {
            if (collegeUniform.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Select a Row");
            }
        }
    }// GEN-LAST:event_uniDeleteActionPerformed

    private void uniUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_uniUpdateActionPerformed
        // TODO add your handling code here:
        // to update data from a selected row
        DefaultTableModel model = (DefaultTableModel) collegeUniform.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false",
                    "root", "");

            String id = uniformID.getText();
            String unif = uniformText.getText();
            String qua = uniformQuantity.getText();
            String price = uniformPrice.getText();

            if (collegeUniform.getSelectedRowCount() == 1) {

                String check = "SELECT * from availability_c_uniform WHERE ID = ? OR Uniform = ?";
                final PreparedStatement ps = con.prepareStatement(check);
                ps.setString(1, id);
                ps.setString(2, unif);
                final ResultSet resultSet = ps.executeQuery();
                System.out.println(resultSet.next());

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "ID and Item already exists");
                    uniformID.setText("");
                    uniformText.setText("");

                } else {
                    try {
                        String sql = "UPDATE availability_c_uniform SET ID = '" + id + "', Uniform = '" + unif
                                + "', Quantity = '" + qua + "', Price = '" + price + "' WHERE ID = '" + id + "'";
                        PreparedStatement preparedStmt = con.prepareStatement(sql);
                        preparedStmt.execute();
                        con.close();

                        JOptionPane.showMessageDialog(this, "Stocks Updated");

                        model.setValueAt(id, collegeUniform.getSelectedRow(), 0);
                        model.setValueAt(unif, collegeUniform.getSelectedRow(), 1);
                        model.setValueAt(qua, collegeUniform.getSelectedRow(), 2);
                        model.setValueAt(price, collegeUniform.getSelectedRow(), 3);
                    } catch (Exception e) {
                    }
                }
            } else {

                if (collegeUniform.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table Empty");
                } else {
                    JOptionPane.showMessageDialog(this, "Select A row to Update");
                }
            }
        } catch (Exception e) {
        }
    }// GEN-LAST:event_uniUpdateActionPerformed

    private void uniClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_uniClearActionPerformed
        // TODO add your handling code here:
        uniformID.setText("");
        uniformText.setText("");
        uniformQuantity.setText("");
        uniformPrice.setText("");
        collegeUniform.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    }// GEN-LAST:event_uniClearActionPerformed

    private void bookAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookAddActionPerformed
        // TODO add your handling code here:
        // add data form text field to table

        int ndex = booksTab.getSelectedIndex();// upper tab
        int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();// college type
        int gradeLevelshsIndex = shsBooksSwitch.getSelectedIndex();// shs 12 or 11
        int semIndex = shsSemSwitch.getSelectedIndex(); // shs sem
        int gradeLevelhsIndex = hsBookSwitch.getSelectedIndex();// hs level

        switch (ndex) {
            case 0: // the college tab
                DefaultTableModel model = (DefaultTableModel) collegeBooks.getModel();

                if (codeBook.getText().equals("") || bookTitle.getText().equals("") || bookQuantity.getText().equals("")
                        || bookPrice.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Complete empty fields");
                } else {
                    try {
                        String data[] = { bookID.getText(), codeBook.getText(), bookTitle.getText(),
                                bookQuantity.getText(), bookPrice.getText() };

                        String id = bookID.getText();
                        String code = codeBook.getText();
                        String title = bookTitle.getText();
                        String stock = bookQuantity.getText();
                        String price = bookPrice.getText();

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelIndex) {// college type
                            case 0:
                                // General
                                String check = "SELECT * from books_c_gencourse WHERE id = ? OR code = ?";
                                final PreparedStatement ps = con.prepareStatement(check);
                                ps.setString(1, id);
                                ps.setString(2, code);
                                final ResultSet resultSet = ps.executeQuery();

                                if (resultSet.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    model.addRow(data);
                                    String sql = "INSERT INTO books_c_gencourse (id, code, name, stock, price) VALUES ('"
                                            + id + "', '" + code + "', '" + title + "', '" + stock + "', '" + price
                                            + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                            case 1:
                                // tech-course
                                String checkT = "SELECT * from books_c_techcourse WHERE id = ? OR code = ?";
                                final PreparedStatement psT = con.prepareStatement(checkT);
                                psT.setString(1, id);
                                psT.setString(2, code);
                                final ResultSet resultSetT = psT.executeQuery();

                                if (resultSetT.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    model.addRow(data);
                                    String sql = "INSERT INTO books_c_techcourse (id, code, name, stock, price) VALUES ('"
                                            + id + "', '" + code + "', '" + title + "', '" + stock + "', '" + price
                                            + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1: // the shs tab
                DefaultTableModel modelshs = (DefaultTableModel) shsBooks.getModel();

                if (codeBook.getText().equals("") || bookTitle.getText().equals("") || bookQuantity.getText().equals("")
                        || bookPrice.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Complete empty fields");
                } else {
                    try {
                        String data[] = { bookID.getText(), codeBook.getText(), bookTitle.getText(),
                                bookQuantity.getText(), bookPrice.getText() };

                        String id = bookID.getText();
                        String code = codeBook.getText();
                        String title = bookTitle.getText();
                        String stock = bookQuantity.getText();
                        String price = bookPrice.getText();

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelshsIndex) {// g 12 or l1
                            case 0:// g12
                                switch (semIndex) {// 1st or 2nd sem
                                    case 0:
                                        // G12 1st
                                        String check21 = "SELECT * from books_shs12a WHERE id = ? OR code = ?";
                                        final PreparedStatement ps21 = con.prepareStatement(check21);
                                        ps21.setString(1, id);
                                        ps21.setString(2, code);
                                        final ResultSet resultSet21 = ps21.executeQuery();

                                        if (resultSet21.next()) {
                                            JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                            uniformID.setText("");
                                            uniformText.setText("");
                                        } else {
                                            modelshs.addRow(data);
                                            String sql = "INSERT INTO books_shs12a (id, code, name, stock, price) VALUES ('"
                                                    + id + "', '" + code + "', '" + title + "', '" + stock + "', '"
                                                    + price + "')";
                                            PreparedStatement preparedStmt = con.prepareStatement(sql);

                                            preparedStmt.execute();

                                            con.close();

                                            JOptionPane.showMessageDialog(this, "Data added");

                                            bookID.setText("");
                                            codeBook.setText("");
                                            bookTitle.setText("");
                                            bookQuantity.setText("");
                                            bookPrice.setText("");
                                        }
                                        break;
                                    case 1:
                                        // G12 2nd
                                        String check22 = "SELECT * from books_shs12b WHERE id = ? OR code = ?";
                                        final PreparedStatement ps22 = con.prepareStatement(check22);
                                        ps22.setString(1, id);
                                        ps22.setString(2, code);
                                        final ResultSet resultSet22 = ps22.executeQuery();

                                        if (resultSet22.next()) {
                                            JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                            uniformID.setText("");
                                            uniformText.setText("");
                                        } else {
                                            modelshs.addRow(data);
                                            String sql = "INSERT INTO books_shs12a (id, code, name, stock, price) VALUES ('"
                                                    + id + "', '" + code + "', '" + title + "', '" + stock + "', '"
                                                    + price + "')";
                                            PreparedStatement preparedStmt = con.prepareStatement(sql);

                                            preparedStmt.execute();

                                            con.close();

                                            JOptionPane.showMessageDialog(this, "Data added");

                                            bookID.setText("");
                                            codeBook.setText("");
                                            bookTitle.setText("");
                                            bookQuantity.setText("");
                                            bookPrice.setText("");
                                        }
                                        break;
                                }

                                break;
                            case 1:// 11
                                switch (semIndex) {
                                    case 0:
                                        // G11 1st
                                        String check21 = "SELECT * from books_shs11a WHERE id = ? OR code = ?";
                                        final PreparedStatement ps21 = con.prepareStatement(check21);
                                        ps21.setString(1, id);
                                        ps21.setString(2, code);
                                        final ResultSet resultSet21 = ps21.executeQuery();

                                        if (resultSet21.next()) {
                                            JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                            uniformID.setText("");
                                            uniformText.setText("");
                                        } else {
                                            modelshs.addRow(data);
                                            String sql = "INSERT INTO books_shs11a (id, code, name, stock, price) VALUES ('"
                                                    + id + "', '" + code + "', '" + title + "', '" + stock + "', '"
                                                    + price + "')";
                                            PreparedStatement preparedStmt = con.prepareStatement(sql);

                                            preparedStmt.execute();

                                            con.close();

                                            JOptionPane.showMessageDialog(this, "Data added");

                                            bookID.setText("");
                                            codeBook.setText("");
                                            bookTitle.setText("");
                                            bookQuantity.setText("");
                                            bookPrice.setText("");
                                        }
                                        break;
                                    case 1:
                                        // G11 2nd
                                        String check22 = "SELECT * from books_shs11b WHERE id = ? OR code = ?";
                                        final PreparedStatement ps22 = con.prepareStatement(check22);
                                        ps22.setString(1, id);
                                        ps22.setString(2, code);
                                        final ResultSet resultSet22 = ps22.executeQuery();

                                        if (resultSet22.next()) {
                                            JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                            uniformID.setText("");
                                            uniformText.setText("");
                                        } else {
                                            modelshs.addRow(data);
                                            String sql = "INSERT INTO books_shs11a (id, code, name, stock, price) VALUES ('"
                                                    + id + "', '" + code + "', '" + title + "', '" + stock + "', '"
                                                    + price + "')";
                                            PreparedStatement preparedStmt = con.prepareStatement(sql);

                                            preparedStmt.execute();

                                            con.close();

                                            JOptionPane.showMessageDialog(this, "Data added");

                                            bookID.setText("");
                                            codeBook.setText("");
                                            bookTitle.setText("");
                                            bookQuantity.setText("");
                                            bookPrice.setText("");
                                        }
                                        break;
                                }
                                break;
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 2:// hs tab
                DefaultTableModel modelhs = (DefaultTableModel) hsBooks.getModel();

                if (codeBook.getText().equals("") || bookTitle.getText().equals("") || bookQuantity.getText().equals("")
                        || bookPrice.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Complete empty fields");
                } else {
                    try {
                        String data[] = { bookID.getText(), codeBook.getText(), bookTitle.getText(),
                                bookQuantity.getText(), bookPrice.getText() };

                        String id = bookID.getText();
                        String code = codeBook.getText();
                        String title = bookTitle.getText();
                        String stock = bookQuantity.getText();
                        String price = bookPrice.getText();

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelhsIndex) {// hslevel
                            case 0:
                                // G10
                                String check = "SELECT * from books_jhs10 WHERE id = ? OR code = ?";
                                final PreparedStatement ps = con.prepareStatement(check);
                                ps.setString(1, id);
                                ps.setString(2, code);
                                final ResultSet resultSet = ps.executeQuery();

                                if (resultSet.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    modelhs.addRow(data);
                                    String sql = "INSERT INTO books_jhs10 (id, code, name, stock, price) VALUES ('" + id
                                            + "', '" + code + "', '" + title + "', '" + stock + "', '" + price + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                            case 1:
                                // G9
                                String check9 = "SELECT * from books_jhs9 WHERE id = ? OR code = ?";
                                final PreparedStatement ps9 = con.prepareStatement(check9);
                                ps9.setString(1, id);
                                ps9.setString(2, code);
                                final ResultSet resultSet9 = ps9.executeQuery();

                                if (resultSet9.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    modelhs.addRow(data);
                                    String sql = "INSERT INTO books_jhs9 (id, code, name, stock, price) VALUES ('" + id
                                            + "', '" + code + "', '" + title + "', '" + stock + "', '" + price + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                            case 2:
                                // G8
                                String check8 = "SELECT * from books_jhs8 WHERE id = ? OR code = ?";
                                final PreparedStatement ps8 = con.prepareStatement(check8);
                                ps8.setString(1, id);
                                ps8.setString(2, code);
                                final ResultSet resultSet8 = ps8.executeQuery();

                                if (resultSet8.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    modelhs.addRow(data);
                                    String sql = "INSERT INTO books_jhs8 (id, code, name, stock, price) VALUES ('" + id
                                            + "', '" + code + "', '" + title + "', '" + stock + "', '" + price + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                            case 3:
                                // G7
                                String check7 = "SELECT * from books_jhs7 WHERE id = ? OR code = ?";
                                final PreparedStatement ps7 = con.prepareStatement(check7);
                                ps7.setString(1, id);
                                ps7.setString(2, code);
                                final ResultSet resultSet7 = ps7.executeQuery();

                                if (resultSet7.next()) {
                                    JOptionPane.showMessageDialog(this, " ID and Item already exists");
                                    uniformID.setText("");
                                    uniformText.setText("");
                                } else {
                                    modelhs.addRow(data);
                                    String sql = "INSERT INTO books_jhs9 (id, code, name, stock, price) VALUES ('" + id
                                            + "', '" + code + "', '" + title + "', '" + stock + "', '" + price + "')";
                                    PreparedStatement preparedStmt = con.prepareStatement(sql);

                                    preparedStmt.execute();

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Data added");

                                    bookID.setText("");
                                    codeBook.setText("");
                                    bookTitle.setText("");
                                    bookQuantity.setText("");
                                    bookPrice.setText("");
                                }
                                break;
                        }
                    } catch (Exception e) {
                    }
                }
                break;
        }
    }// GEN-LAST:event_bookAddActionPerformed

    private void bookClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookClearActionPerformed
        // TODO add your handling code here:
        bookID.setText("");
        bookTitle.setText("");
        codeBook.setText("");
        bookPrice.setText("");
        bookQuantity.setText("");
        collegeUniform.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    }// GEN-LAST:event_bookClearActionPerformed

    private void bookUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookUpdateActionPerformed
        // TODO add your handling code here:
        // update data form text field to table

        int ndex = booksTab.getSelectedIndex();// upper tab
        int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();// college type
        int gradeLevelshsIndex = shsBooksSwitch.getSelectedIndex();// shs 12 or 11
        int semIndex = shsSemSwitch.getSelectedIndex(); // shs sem
        int gradeLevelhsIndex = hsBookSwitch.getSelectedIndex();// hs level

        switch (ndex) {// college
            case 0: // the college tab
                DefaultTableModel model = (DefaultTableModel) collegeBooks.getModel();

                if (collegeBooks.getSelectedRowCount() == 1) {

                    String id = bookID.getText();
                    String code = codeBook.getText();
                    String title = bookTitle.getText();
                    String stock = bookQuantity.getText();
                    String price = bookPrice.getText();

                    model.setValueAt(id, collegeBooks.getSelectedRow(), 0);
                    model.setValueAt(code, collegeBooks.getSelectedRow(), 1);
                    model.setValueAt(title, collegeBooks.getSelectedRow(), 2);
                    model.setValueAt(stock, collegeBooks.getSelectedRow(), 3);
                    model.setValueAt(price, collegeBooks.getSelectedRow(), 4);

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelIndex) {
                            case 0:
                                // General
                                String sql = "UPDATE books_c_gencourse SET id = '" + id + "', code = '" + code
                                        + "', name = '" + title + "', stock = '" + stock + "' , price = '" + price
                                        + "'WHERE ID = '" + id + "'";

                                PreparedStatement preparedStmt = con.prepareStatement(sql);

                                preparedStmt.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");

                                break;
                            case 1:
                                // tech-course
                                String sql2 = "UPDATE books_c_techcourse SET id = '" + id + "', code = '" + code
                                        + "', name = '" + title + "', stock = '" + stock + "' , price = '" + price
                                        + "'WHERE ID = '" + id + "'";

                                PreparedStatement preparedStmt2 = con.prepareStatement(sql2);

                                preparedStmt2.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");
                                break;
                        }

                        // Statement stmt = con.createStatement();
                    } catch (Exception e) {
                    }
                } else {
                    if (collegeBooks.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Table Empty");

                    } else {
                        JOptionPane.showMessageDialog(this, "Select A row to Update");
                    }
                }
                break;
            case 1: // the shs tab
                DefaultTableModel modelshs = (DefaultTableModel) shsBooks.getModel();

                if (shsBooks.getSelectedRowCount() == 1) {

                    String id = bookID.getText();
                    String code = codeBook.getText();
                    String title = bookTitle.getText();
                    String stock = bookQuantity.getText();
                    String price = bookPrice.getText();

                    modelshs.setValueAt(id, shsBooks.getSelectedRow(), 0);
                    modelshs.setValueAt(code, shsBooks.getSelectedRow(), 1);
                    modelshs.setValueAt(title, shsBooks.getSelectedRow(), 2);
                    modelshs.setValueAt(stock, shsBooks.getSelectedRow(), 3);
                    modelshs.setValueAt(price, shsBooks.getSelectedRow(), 4);

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelshsIndex) {// grade level
                            case 0:
                                switch (semIndex) {
                                    case 0: // g12 1st

                                        String sql = "UPDATE books_shs12a SET id = '" + id + "', code = '" + code
                                                + "', name = '" + title + "', stock = '" + stock + "' , price = '"
                                                + price + "'WHERE ID = '" + id + "'";

                                        PreparedStatement preparedStmt = con.prepareStatement(sql);

                                        preparedStmt.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Stocks Updated");

                                        break;

                                    case 1: // g12 2nd
                                        String sql12b = "UPDATE books_shs12b SET id = '" + id + "', code = '" + code
                                                + "', name = '" + title + "', stock = '" + stock + "' , price = '"
                                                + price + "'WHERE ID = '" + id + "'";

                                        PreparedStatement preparedStmt12b = con.prepareStatement(sql12b);

                                        preparedStmt12b.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Stocks Updated");

                                        break;
                                }

                                break;
                            case 1:
                                switch (semIndex) {
                                    case 0: // g11 1st

                                        String sql = "UPDATE books_shs11a SET id = '" + id + "', code = '" + code
                                                + "', name = '" + title + "', stock = '" + stock + "' , price = '"
                                                + price + "'WHERE ID = '" + id + "'";

                                        PreparedStatement preparedStmt = con.prepareStatement(sql);

                                        preparedStmt.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Stocks Updated");

                                        break;

                                    case 1: // g12 2nd
                                        String sql11b = "UPDATE books_shs11b SET id = '" + id + "', code = '" + code
                                                + "', name = '" + title + "', stock = '" + stock + "' , price = '"
                                                + price + "'WHERE ID = '" + id + "'";

                                        PreparedStatement preparedStmt11b = con.prepareStatement(sql11b);

                                        preparedStmt11b.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Stocks Updated");

                                        break;
                                }
                                break;
                        }
                    } catch (Exception e) {
                    }
                } else {
                    if (collegeBooks.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Table Empty");

                    } else {
                        JOptionPane.showMessageDialog(this, "Select A row to Update");
                    }
                }
                break;
            case 2: // the hs tab
                DefaultTableModel modelhs = (DefaultTableModel) hsBooks.getModel();

                if (hsBooks.getSelectedRowCount() == 1) {

                    String id = bookID.getText();
                    String code = codeBook.getText();
                    String title = bookTitle.getText();
                    String stock = bookQuantity.getText();
                    String price = bookPrice.getText();

                    modelhs.setValueAt(id, hsBooks.getSelectedRow(), 0);
                    modelhs.setValueAt(code, hsBooks.getSelectedRow(), 1);
                    modelhs.setValueAt(title, hsBooks.getSelectedRow(), 2);
                    modelhs.setValueAt(stock, hsBooks.getSelectedRow(), 3);
                    modelhs.setValueAt(price, hsBooks.getSelectedRow(), 4);

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelhsIndex) {
                            case 0:
                                // G10
                                String sql = "UPDATE books_jhs10 SET id = '" + id + "', code = '" + code + "', name = '"
                                        + title + "', stock = '" + stock + "' , price = '" + price + "'WHERE ID = '"
                                        + id + "'";

                                PreparedStatement preparedStmt = con.prepareStatement(sql);

                                preparedStmt.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");

                                break;
                            case 1:
                                // G9
                                String sql9 = "UPDATE books_jhs9 SET id = '" + id + "', code = '" + code + "', name = '"
                                        + title + "', stock = '" + stock + "' , price = '" + price + "'WHERE ID = '"
                                        + id + "'";

                                PreparedStatement preparedStmt9 = con.prepareStatement(sql9);

                                preparedStmt9.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");
                                break;
                            case 2:
                                // G8
                                String sql8 = "UPDATE books_jhs8 SET id = '" + id + "', code = '" + code + "', name = '"
                                        + title + "', stock = '" + stock + "' , price = '" + price + "'WHERE ID = '"
                                        + id + "'";

                                PreparedStatement preparedStmt8 = con.prepareStatement(sql8);

                                preparedStmt8.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");
                                break;
                            case 3:
                                // G7
                                String sql7 = "UPDATE books_jhs7 SET id = '" + id + "', code = '" + code + "', name = '"
                                        + title + "', stock = '" + stock + "' , price = '" + price + "'WHERE ID = '"
                                        + id + "'";

                                PreparedStatement preparedStmt7 = con.prepareStatement(sql7);

                                preparedStmt7.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Stocks Updated");
                                break;
                        }
                    } catch (Exception e) {
                    }
                } else {
                    if (collegeBooks.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Table Empty");

                    } else {
                        JOptionPane.showMessageDialog(this, "Select A row to Update");
                    }
                }
                break;
        }
    }// GEN-LAST:event_bookUpdateActionPerformed

    private void bookDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookDeleteActionPerformed
        // TODO add your handling code here:
        int ndex = booksTab.getSelectedIndex();// upper tab
        int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();// college type
        int gradeLevelshsIndex = shsBooksSwitch.getSelectedIndex();// shs 12 or 11
        int semIndex = shsSemSwitch.getSelectedIndex(); // shs sem
        int gradeLevelhsIndex = hsBookSwitch.getSelectedIndex();// hs level

        switch (ndex) {// school level
            case 0: // college level
                DefaultTableModel model = (DefaultTableModel) collegeBooks.getModel();
                if (collegeBooks.getSelectedRowCount() == 1) {
                    try {
                        String code = codeBook.getText();

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelIndex) {
                            case 0:
                                // General

                                String sql = "DELETE FROM books_c_gencourse WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmt = con.prepareStatement(sql);

                                preparedStmt.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                model.removeRow(collegeBooks.getSelectedRow());

                                break;
                            case 1:
                                // tech-course
                                String sqlT = "DELETE FROM books_c_techcourse WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmtT = con.prepareStatement(sqlT);

                                preparedStmtT.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                model.removeRow(collegeBooks.getSelectedRow());
                                break;
                        }

                    } catch (Exception e) {
                    }
                } else {
                    if (collegeBooks.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Table is Empty");
                    } else {
                        JOptionPane.showMessageDialog(this, "Select a Row");
                    }
                }
                break;

            case 1:// shs level
                switch (gradeLevelshsIndex) {
                    case 0:// g12
                        DefaultTableModel modelshs12 = (DefaultTableModel) shsBooks.getModel();
                        if (shsBooks.getSelectedRowCount() == 1) {
                            try {
                                String code = codeBook.getText();

                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");
                                switch (semIndex) {
                                    case 0:
                                        // 12a

                                        String sql = "DELETE FROM books_shs12a WHERE code = '" + code + "' ";
                                        PreparedStatement preparedStmt = con.prepareStatement(sql);

                                        preparedStmt.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Row Deleted");
                                        bookID.setText("");
                                        bookTitle.setText("");
                                        bookQuantity.setText("");
                                        bookPrice.setText("");
                                        codeBook.setText("");

                                        modelshs12.removeRow(shsBooks.getSelectedRow());

                                        break;
                                    case 1:

                                        // 12b
                                        String sqlT = "DELETE FROM books_shs12b WHERE code = '" + code + "' ";
                                        PreparedStatement preparedStmtT = con.prepareStatement(sqlT);

                                        preparedStmtT.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Row Deleted");
                                        bookID.setText("");
                                        bookTitle.setText("");
                                        bookQuantity.setText("");
                                        bookPrice.setText("");
                                        codeBook.setText("");

                                        modelshs12.removeRow(collegeBooks.getSelectedRow());
                                        break;
                                }

                            } catch (Exception e) {
                            }
                        } else {
                            if (collegeBooks.getRowCount() == 0) {
                                JOptionPane.showMessageDialog(this, "Table is Empty");
                            } else {
                                JOptionPane.showMessageDialog(this, "Select a Row");
                            }
                        }
                        break;
                    case 1:// g11
                        DefaultTableModel modelshs11 = (DefaultTableModel) shsBooks.getModel();
                        if (shsBooks.getSelectedRowCount() == 1) {
                            try {
                                String code = codeBook.getText();

                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");
                                switch (semIndex) {
                                    case 0:
                                        // 12a

                                        String sql = "DELETE FROM books_shs11a WHERE code = '" + code + "' ";
                                        PreparedStatement preparedStmt = con.prepareStatement(sql);

                                        preparedStmt.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Row Deleted");
                                        bookID.setText("");
                                        bookTitle.setText("");
                                        bookQuantity.setText("");
                                        bookPrice.setText("");
                                        codeBook.setText("");

                                        modelshs11.removeRow(shsBooks.getSelectedRow());

                                        break;
                                    case 1:
                                        // 12b
                                        String sqlT = "DELETE FROM books_shs11b WHERE code = '" + code + "' ";
                                        PreparedStatement preparedStmtT = con.prepareStatement(sqlT);

                                        preparedStmtT.execute();

                                        con.close();

                                        JOptionPane.showMessageDialog(this, "Row Deleted");
                                        bookID.setText("");
                                        bookTitle.setText("");
                                        bookQuantity.setText("");
                                        bookPrice.setText("");
                                        codeBook.setText("");

                                        modelshs11.removeRow(collegeBooks.getSelectedRow());
                                        break;
                                }
                            } catch (Exception e) {
                            }
                        } else {
                            if (collegeBooks.getRowCount() == 0) {
                                JOptionPane.showMessageDialog(this, "Table is Empty");
                            } else {
                                JOptionPane.showMessageDialog(this, "Select a Row");
                            }
                        }
                        break;
                }
                break;
            case 2: // hs level
                DefaultTableModel modelhs = (DefaultTableModel) hsBooks.getModel();
                if (hsBooks.getSelectedRowCount() == 1) {
                    try {
                        String code = codeBook.getText();

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager
                                .getConnection("jdbc:mysql://localhost:3306/university_shop?useSSL=false", "root", "");

                        switch (gradeLevelhsIndex) {
                            case 0:
                                // G10

                                String sql10 = "DELETE FROM books_jhs10 WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmt10 = con.prepareStatement(sql10);

                                preparedStmt10.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                modelhs.removeRow(hsBooks.getSelectedRow());

                                break;
                            case 1:
                                // G9
                                String sql9 = "DELETE FROM books_jhs9 WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmt9 = con.prepareStatement(sql9);

                                preparedStmt9.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                modelhs.removeRow(hsBooks.getSelectedRow());
                                break;
                            case 2:
                                // G8
                                String sql8 = "DELETE FROM books_jhs8 WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmt8 = con.prepareStatement(sql8);

                                preparedStmt8.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                modelhs.removeRow(hsBooks.getSelectedRow());
                                break;
                            case 3:
                                // G7
                                String sql7 = "DELETE FROM books_jhs7 WHERE code = '" + code + "' ";
                                PreparedStatement preparedStmt7 = con.prepareStatement(sql7);

                                preparedStmt7.execute();

                                con.close();

                                JOptionPane.showMessageDialog(this, "Row Deleted");
                                bookID.setText("");
                                bookTitle.setText("");
                                bookQuantity.setText("");
                                bookPrice.setText("");
                                codeBook.setText("");

                                modelhs.removeRow(hsBooks.getSelectedRow());
                                break;
                        }
                    } catch (Exception e) {
                    }
                } else {
                    if (collegeBooks.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Table is Empty");
                    } else {
                        JOptionPane.showMessageDialog(this, "Select a Row");
                    }
                }
                break;
        }
    }// GEN-LAST:event_bookDeleteActionPerformed

    private void collegeUniformMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_collegeUniformMouseClicked
        // TODO add your handling code here:
        // get data from table and set it to text field
        DefaultTableModel model = (DefaultTableModel) collegeUniform.getModel();

        String idColumn = model.getValueAt(collegeUniform.getSelectedRow(), 0).toString();
        String unifColumn = model.getValueAt(collegeUniform.getSelectedRow(), 1).toString();
        String quantityColumn = model.getValueAt(collegeUniform.getSelectedRow(), 2).toString();
        String priceColumn = model.getValueAt(collegeUniform.getSelectedRow(), 3).toString();

        uniformID.setText(idColumn);
        uniformText.setText(unifColumn);
        uniformQuantity.setText(quantityColumn);
        uniformPrice.setText(priceColumn);
    }// GEN-LAST:event_collegeUniformMouseClicked

    private void codeBookActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_codeBookActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_codeBookActionPerformed

    private void booksTabMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_booksTabMouseClicked
        // TODO add your handling code here:
        int ndex = booksTab.getSelectedIndex();// upper tab
        int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();// college type
        int gradeLevelshsIndex = shsBooksSwitch.getSelectedIndex();// shs 12 or 11
        int semIndex = shsSemSwitch.getSelectedIndex(); // shs sem

        switch (ndex) {
            case 0:
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root",
                            "");
                    // fll table of admin_Sales

                    System.out.println(gradeLevelIndex);

                    // fill table for college books
                    Statement stB = con.createStatement();

                    switch (gradeLevelIndex) {
                        case 0:
                            // General
                            String sqlB = "select * from books_c_gencourse";
                            ResultSet rsB = stB.executeQuery(sqlB);
                            DefaultTableModel BTable = (DefaultTableModel) collegeBooks.getModel();
                            BTable.setNumRows(0);

                            while (rsB.next()) {
                                // add data
                                String idB = String.valueOf(rsB.getInt("ID"));
                                String codeB = rsB.getString("code");
                                String titleB = rsB.getString("name");
                                String stockB = rsB.getString("stock");
                                String priceB = rsB.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable.addRow(booksList);
                            }
                            break;
                        case 1:
                            // tech-course
                            String sqlB2 = "select * from books_c_techcourse";
                            ResultSet rsB2 = stB.executeQuery(sqlB2);
                            DefaultTableModel BTable2 = (DefaultTableModel) collegeBooks.getModel();
                            BTable2.setNumRows(0);

                            while (rsB2.next()) {
                                // add data
                                String idB = String.valueOf(rsB2.getInt("ID"));
                                String codeB = rsB2.getString("code");
                                String titleB = rsB2.getString("name");
                                String stockB = rsB2.getString("stock");
                                String priceB = rsB2.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable2.addRow(booksList);
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 1:
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root",
                            "");
                    Statement stB = con.createStatement();

                    switch (gradeLevelshsIndex) {
                        case 0:
                            switch (semIndex) {
                                case 0: // G12 1st
                                    String sqlB = "select * from books_shs12a";
                                    ResultSet rsB = stB.executeQuery(sqlB);
                                    DefaultTableModel BTable = (DefaultTableModel) shsBooks.getModel();
                                    BTable.setNumRows(0);

                                    while (rsB.next()) {
                                        // add data
                                        String idB = String.valueOf(rsB.getInt("ID"));
                                        String codeB = rsB.getString("code");
                                        String titleB = rsB.getString("name");
                                        String stockB = rsB.getString("stock");
                                        String priceB = rsB.getString("price");

                                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                        BTable.addRow(booksList);
                                    }
                                    break;

                                case 1: // G12 2nd
                                    String sqlB2 = "select * from books_shs12b";
                                    ResultSet rsB2 = stB.executeQuery(sqlB2);
                                    DefaultTableModel BTable2 = (DefaultTableModel) shsBooks.getModel();
                                    BTable2.setNumRows(0);

                                    while (rsB2.next()) {
                                        // add data
                                        String idB = String.valueOf(rsB2.getInt("ID"));
                                        String codeB = rsB2.getString("code");
                                        String titleB = rsB2.getString("name");
                                        String stockB = rsB2.getString("stock");
                                        String priceB = rsB2.getString("price");

                                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                        BTable2.addRow(booksList);
                                    }

                                    break;
                            }
                            break;
                        case 1:
                            switch (semIndex) {
                                case 0: // G11 1st
                                    String sqlBs1 = "select * from books_shs11a";
                                    ResultSet rsBs1 = stB.executeQuery(sqlBs1);
                                    DefaultTableModel BTables1 = (DefaultTableModel) shsBooks.getModel();
                                    BTables1.setNumRows(0);

                                    while (rsBs1.next()) {
                                        // add data
                                        String idB = String.valueOf(rsBs1.getInt("ID"));
                                        String codeB = rsBs1.getString("code");
                                        String titleB = rsBs1.getString("name");
                                        String stockB = rsBs1.getString("stock");
                                        String priceB = rsBs1.getString("price");

                                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                        BTables1.addRow(booksList);
                                    }
                                    break;

                                case 1: // G11 2nd
                                    String sqlBs2 = "select * from books_shs11b";
                                    ResultSet rsBs2 = stB.executeQuery(sqlBs2);
                                    DefaultTableModel BTables2 = (DefaultTableModel) shsBooks.getModel();
                                    BTables2.setNumRows(0);

                                    while (rsBs2.next()) {
                                        // add data
                                        String idB = String.valueOf(rsBs2.getInt("ID"));
                                        String codeB = rsBs2.getString("code");
                                        String titleB = rsBs2.getString("name");
                                        String stockB = rsBs2.getString("stock");
                                        String priceB = rsBs2.getString("price");

                                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                        BTables2.addRow(booksList);
                                    }
                                    break;
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root",
                            "");

                    int gradeLevelhsIndex = hsBookSwitch.getSelectedIndex();

                    // fill table for hs books
                    Statement stB = con.createStatement();

                    switch (gradeLevelhsIndex) {
                        case 0:
                            // G10
                            String sql10 = "select * from books_jhs10";
                            ResultSet rs10 = stB.executeQuery(sql10);
                            DefaultTableModel BTable10 = (DefaultTableModel) hsBooks.getModel();
                            BTable10.setNumRows(0);

                            while (rs10.next()) {
                                // add data
                                String idB = String.valueOf(rs10.getInt("ID"));
                                String codeB = rs10.getString("code");
                                String titleB = rs10.getString("name");
                                String stockB = rs10.getString("stock");
                                String priceB = rs10.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable10.addRow(booksList);
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }// GEN-LAST:event_booksTabMouseClicked

    private void shsSemSwitchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_shsSemSwitchActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");
            // fll table of admin_Sales

            int gradeLevelIndex = shsBooksSwitch.getSelectedIndex();
            int semIndex = shsSemSwitch.getSelectedIndex();

            // fill table for college books
            Statement stB = con.createStatement();

            switch (gradeLevelIndex) {
                case 0:
                    switch (semIndex) {
                        case 0: // G12 1st
                            String sqlB = "select * from books_shs12a";
                            ResultSet rsB = stB.executeQuery(sqlB);
                            DefaultTableModel BTable = (DefaultTableModel) shsBooks.getModel();
                            BTable.setNumRows(0);

                            while (rsB.next()) {
                                // add data
                                String idB = String.valueOf(rsB.getInt("ID"));
                                String codeB = rsB.getString("code");
                                String titleB = rsB.getString("name");
                                String stockB = rsB.getString("stock");
                                String priceB = rsB.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable.addRow(booksList);
                            }
                            break;

                        case 1: // G12 2nd
                            String sqlB2 = "select * from books_shs12b";
                            ResultSet rsB2 = stB.executeQuery(sqlB2);
                            DefaultTableModel BTable2 = (DefaultTableModel) shsBooks.getModel();
                            BTable2.setNumRows(0);

                            while (rsB2.next()) {
                                // add data
                                String idB = String.valueOf(rsB2.getInt("ID"));
                                String codeB = rsB2.getString("code");
                                String titleB = rsB2.getString("name");
                                String stockB = rsB2.getString("stock");
                                String priceB = rsB2.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable2.addRow(booksList);
                            }

                            break;
                    }
                    break;
                case 1:
                    switch (semIndex) {
                        case 0: // G11 1st
                            String sqlBs1 = "select * from books_shs11a";
                            ResultSet rsBs1 = stB.executeQuery(sqlBs1);
                            DefaultTableModel BTables1 = (DefaultTableModel) shsBooks.getModel();
                            BTables1.setNumRows(0);

                            while (rsBs1.next()) {
                                // add data
                                String idB = String.valueOf(rsBs1.getInt("ID"));
                                String codeB = rsBs1.getString("code");
                                String titleB = rsBs1.getString("name");
                                String stockB = rsBs1.getString("stock");
                                String priceB = rsBs1.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTables1.addRow(booksList);
                            }
                            break;

                        case 1: // G11 2nd
                            String sqlBs2 = "select * from books_shs11b";
                            ResultSet rsBs2 = stB.executeQuery(sqlBs2);
                            DefaultTableModel BTables2 = (DefaultTableModel) shsBooks.getModel();
                            BTables2.setNumRows(0);

                            while (rsBs2.next()) {
                                // add data
                                String idB = String.valueOf(rsBs2.getInt("ID"));
                                String codeB = rsBs2.getString("code");
                                String titleB = rsBs2.getString("name");
                                String stockB = rsBs2.getString("stock");
                                String priceB = rsBs2.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTables2.addRow(booksList);
                            }
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_shsSemSwitchActionPerformed

    private void shsBooksSwitchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_shsBooksSwitchActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");

            int gradeLevelIndex = shsBooksSwitch.getSelectedIndex();
            int semIndex = shsSemSwitch.getSelectedIndex();

            // fill table for shs books
            Statement stB = con.createStatement();

            switch (gradeLevelIndex) {
                case 0:
                    switch (semIndex) {
                        case 0: // G12 1st
                            String sqlB = "select * from books_shs12a";
                            ResultSet rsB = stB.executeQuery(sqlB);
                            DefaultTableModel BTable = (DefaultTableModel) shsBooks.getModel();
                            BTable.setNumRows(0);

                            while (rsB.next()) {
                                // add data
                                String idB = String.valueOf(rsB.getInt("ID"));
                                String codeB = rsB.getString("code");
                                String titleB = rsB.getString("name");
                                String stockB = rsB.getString("stock");
                                String priceB = rsB.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable.addRow(booksList);
                            }
                            break;

                        case 1: // G12 2nd
                            String sqlB2 = "select * from books_shs12b";
                            ResultSet rsB2 = stB.executeQuery(sqlB2);
                            DefaultTableModel BTable2 = (DefaultTableModel) shsBooks.getModel();
                            BTable2.setNumRows(0);

                            while (rsB2.next()) {
                                // add data
                                String idB = String.valueOf(rsB2.getInt("ID"));
                                String codeB = rsB2.getString("code");
                                String titleB = rsB2.getString("name");
                                String stockB = rsB2.getString("stock");
                                String priceB = rsB2.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTable2.addRow(booksList);
                            }

                            break;
                    }
                    break;
                case 1:
                    switch (semIndex) {
                        case 0: // G11 1st
                            String sqlBs1 = "select * from books_shs11a";
                            ResultSet rsBs1 = stB.executeQuery(sqlBs1);
                            DefaultTableModel BTables1 = (DefaultTableModel) shsBooks.getModel();
                            BTables1.setNumRows(0);

                            while (rsBs1.next()) {
                                // add data
                                String idB = String.valueOf(rsBs1.getInt("ID"));
                                String codeB = rsBs1.getString("code");
                                String titleB = rsBs1.getString("name");
                                String stockB = rsBs1.getString("stock");
                                String priceB = rsBs1.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTables1.addRow(booksList);
                            }
                            break;

                        case 1: // G11 2nd
                            String sqlBs2 = "select * from books_shs11b";
                            ResultSet rsBs2 = stB.executeQuery(sqlBs2);
                            DefaultTableModel BTables2 = (DefaultTableModel) shsBooks.getModel();
                            BTables2.setNumRows(0);

                            while (rsBs2.next()) {
                                // add data
                                String idB = String.valueOf(rsBs2.getInt("ID"));
                                String codeB = rsBs2.getString("code");
                                String titleB = rsBs2.getString("name");
                                String stockB = rsBs2.getString("stock");
                                String priceB = rsBs2.getString("price");

                                String booksList[] = { idB, codeB, titleB, stockB, priceB };
                                BTables2.addRow(booksList);
                            }
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_shsBooksSwitchActionPerformed

    private void shsBooksMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_shsBooksMouseClicked
        // TODO add your handling code here:
        // add data from books table to text box
        DefaultTableModel model = (DefaultTableModel) shsBooks.getModel();

        String idColumn = model.getValueAt(shsBooks.getSelectedRow(), 0).toString();
        String codeColumn = model.getValueAt(shsBooks.getSelectedRow(), 1).toString();
        String titleColumn = model.getValueAt(shsBooks.getSelectedRow(), 2).toString();
        String stockColumn = model.getValueAt(shsBooks.getSelectedRow(), 3).toString();
        String priceColumn = model.getValueAt(shsBooks.getSelectedRow(), 4).toString();

        bookID.setText(idColumn);
        codeBook.setText(codeColumn);
        bookTitle.setText(titleColumn);
        bookQuantity.setText(stockColumn);
        bookPrice.setText(priceColumn);
    }// GEN-LAST:event_shsBooksMouseClicked

    private void collegeBookSwitchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_collegeBookSwitchActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");
            // fll table of admin_Sales

            int gradeLevelIndex = collegeBookSwitch.getSelectedIndex();
            System.out.println(gradeLevelIndex);

            // fill table for college books
            Statement stB = con.createStatement();

            switch (gradeLevelIndex) {
                case 0:
                    // General
                    String sqlB = "select * from books_c_gencourse";
                    ResultSet rsB = stB.executeQuery(sqlB);
                    DefaultTableModel BTable = (DefaultTableModel) collegeBooks.getModel();
                    BTable.setNumRows(0);

                    while (rsB.next()) {
                        // add data
                        String idB = String.valueOf(rsB.getInt("ID"));
                        String codeB = rsB.getString("code");
                        String titleB = rsB.getString("name");
                        String stockB = rsB.getString("stock");
                        String priceB = rsB.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable.addRow(booksList);
                    }
                    break;
                case 1:
                    // tech-course
                    String sqlB2 = "select * from books_c_techcourse";
                    ResultSet rsB2 = stB.executeQuery(sqlB2);
                    DefaultTableModel BTable2 = (DefaultTableModel) collegeBooks.getModel();
                    BTable2.setNumRows(0);

                    while (rsB2.next()) {
                        // add data
                        String idB = String.valueOf(rsB2.getInt("ID"));
                        String codeB = rsB2.getString("code");
                        String titleB = rsB2.getString("name");
                        String stockB = rsB2.getString("stock");
                        String priceB = rsB2.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable2.addRow(booksList);
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_collegeBookSwitchActionPerformed

    private void collegeBooksMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_collegeBooksMouseClicked
        // TODO add your handling code here:
        // add data from books table to text box
        DefaultTableModel model = (DefaultTableModel) collegeBooks.getModel();

        String idColumn = model.getValueAt(collegeBooks.getSelectedRow(), 0).toString();
        String codeColumn = model.getValueAt(collegeBooks.getSelectedRow(), 1).toString();
        String titleColumn = model.getValueAt(collegeBooks.getSelectedRow(), 2).toString();
        String stockColumn = model.getValueAt(collegeBooks.getSelectedRow(), 3).toString();
        String priceColumn = model.getValueAt(collegeBooks.getSelectedRow(), 4).toString();

        bookID.setText(idColumn);
        codeBook.setText(codeColumn);
        bookTitle.setText(titleColumn);
        bookQuantity.setText(stockColumn);
        bookPrice.setText(priceColumn);
    }// GEN-LAST:event_collegeBooksMouseClicked

    private void hsBookSwitchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_hsBookSwitchActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");

            int gradeLevelhsIndex = hsBookSwitch.getSelectedIndex();

            // fill table for hs books
            Statement stB = con.createStatement();

            switch (gradeLevelhsIndex) {
                case 0:
                    // G10
                    String sql10 = "select * from books_jhs10";
                    ResultSet rs10 = stB.executeQuery(sql10);
                    DefaultTableModel BTable10 = (DefaultTableModel) hsBooks.getModel();
                    BTable10.setNumRows(0);

                    while (rs10.next()) {
                        // add data
                        String idB = String.valueOf(rs10.getInt("ID"));
                        String codeB = rs10.getString("code");
                        String titleB = rs10.getString("name");
                        String stockB = rs10.getString("stock");
                        String priceB = rs10.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable10.addRow(booksList);
                    }
                    break;
                case 1:
                    // G9
                    String sql9 = "select * from books_jhs9";
                    ResultSet rs9 = stB.executeQuery(sql9);
                    DefaultTableModel BTable9 = (DefaultTableModel) hsBooks.getModel();
                    BTable9.setNumRows(0);

                    while (rs9.next()) {
                        // add data
                        String idB = String.valueOf(rs9.getInt("ID"));
                        String codeB = rs9.getString("code");
                        String titleB = rs9.getString("name");
                        String stockB = rs9.getString("stock");
                        String priceB = rs9.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable9.addRow(booksList);
                    }
                    break;
                case 2:
                    // G8
                    String sql8 = "select * from books_jhs8";
                    ResultSet rs8 = stB.executeQuery(sql8);
                    DefaultTableModel BTable8 = (DefaultTableModel) hsBooks.getModel();
                    BTable8.setNumRows(0);

                    while (rs8.next()) {
                        // add data
                        String idB = String.valueOf(rs8.getInt("ID"));
                        String codeB = rs8.getString("code");
                        String titleB = rs8.getString("name");
                        String stockB = rs8.getString("stock");
                        String priceB = rs8.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable8.addRow(booksList);
                    }
                    break;
                case 3:
                    // G7
                    String sql7 = "select * from books_jhs7";
                    ResultSet rs7 = stB.executeQuery(sql7);
                    DefaultTableModel BTable7 = (DefaultTableModel) hsBooks.getModel();
                    BTable7.setNumRows(0);

                    while (rs7.next()) {
                        // add data
                        String idB = String.valueOf(rs7.getInt("ID"));
                        String codeB = rs7.getString("code");
                        String titleB = rs7.getString("name");
                        String stockB = rs7.getString("stock");
                        String priceB = rs7.getString("price");

                        String booksList[] = { idB, codeB, titleB, stockB, priceB };
                        BTable7.addRow(booksList);
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_hsBookSwitchActionPerformed

    private void hsBooksMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_hsBooksMouseClicked
        // TODO add your handling code here:
        // add data from books table to text box
        DefaultTableModel model = (DefaultTableModel) hsBooks.getModel();

        String idColumn = model.getValueAt(hsBooks.getSelectedRow(), 0).toString();
        String codeColumn = model.getValueAt(hsBooks.getSelectedRow(), 1).toString();
        String titleColumn = model.getValueAt(hsBooks.getSelectedRow(), 2).toString();
        String stockColumn = model.getValueAt(hsBooks.getSelectedRow(), 3).toString();
        String priceColumn = model.getValueAt(hsBooks.getSelectedRow(), 4).toString();

        bookID.setText(idColumn);
        codeBook.setText(codeColumn);
        bookTitle.setText(titleColumn);
        bookQuantity.setText(stockColumn);
        bookPrice.setText(priceColumn);
    }// GEN-LAST:event_hsBooksMouseClicked

    private void ordersTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ordersTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        String orderStatus = model.getValueAt(ordersTable.getSelectedRow(), 5).toString();
        System.out.println(orderStatus);

        try {
            String idSTAT = model.getValueAt(ordersTable.getSelectedRow(), 0).toString();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_shop", "root", "");

            String sqlSTA = "UPDATE admin_sales SET Status = '" + orderStatus + "' WHERE id = '" + idSTAT + "' ";

            PreparedStatement preparedSta = con.prepareStatement(sqlSTA);

            preparedSta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No data to show");
        }
    }// GEN-LAST:event_ordersTableMouseClicked

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Steel".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        try {
            FlatArcIJTheme.setup();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        URL iconUrl = this.getClass().getResource("images/univ_shop_icon.png");
        Toolkit tk = this.getToolkit();
        setIconImage(tk.getImage(iconUrl));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookAdd;
    private javax.swing.JButton bookClear;
    private javax.swing.JButton bookDelete;
    private javax.swing.JFormattedTextField bookID;
    private javax.swing.JFormattedTextField bookPrice;
    private javax.swing.JFormattedTextField bookQuantity;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JButton bookUpdate;
    private javax.swing.JTabbedPane booksTab;
    private javax.swing.JTextField codeBook;
    private javax.swing.JComboBox<String> collegeBookSwitch;
    private javax.swing.JTable collegeBooks;
    private javax.swing.JTable collegeUniform;
    private javax.swing.JPanel footer;
    private javax.swing.JComboBox<String> hsBookSwitch;
    private javax.swing.JTable hsBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTable ordersTable;
    private javax.swing.JTable salesTable;
    private javax.swing.JTable shsBooks;
    private javax.swing.JComboBox<String> shsBooksSwitch;
    private javax.swing.JComboBox<String> shsSemSwitch;
    private javax.swing.JButton uniAdd;
    private javax.swing.JButton uniClear;
    private javax.swing.JButton uniDelete;
    private javax.swing.JButton uniUpdate;
    private javax.swing.JFormattedTextField uniformID;
    private javax.swing.JFormattedTextField uniformPrice;
    private javax.swing.JFormattedTextField uniformQuantity;
    private javax.swing.JTextField uniformText;
    // End of variables declaration//GEN-END:variables
}
