/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import hospitalsystem.Data;
import hospitalsystem.DatabaseConnection;
import java.awt.ComponentOrientation;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author m.amin
 */
public class Employees extends javax.swing.JFrame {

    int GENDERID = 0;
    int MARTIALID = 0;
    int NATIONALITYID = 0;
    int SPECIALISTID = 0;
    int EmpID = 0;
    DefaultComboBoxModel jobdata = new DefaultComboBoxModel();
    DefaultComboBoxModel jobdata2 = new DefaultComboBoxModel();
    DefaultComboBoxModel specidata = new DefaultComboBoxModel();
    DefaultComboBoxModel specidata2 = new DefaultComboBoxModel();
    DefaultComboBoxModel natidata = new DefaultComboBoxModel();
    String Query = "SELECT EMPLOYEES.ID as [الكود], EMPLOYEES.EMP_NAME as [اسم الموظف], EMPLOYEES.NATIONAL_ID as [رقم الهوية],"
            + " EMPLOYEES.DOF_BIRTH as [تاريخ الميلاد], EMPLOYEES.WORK_DATE as [تاريخ التعيين],"
            + " EMPLOYEES.EMP_JObID, JObS.JOb_NAME as [الوظيفة], EMPLOYEES.SPECIALIST_ID, Specialties.Special_name as [التخصص], \n"
            + " EMPLOYEES.NATIONALITY_ID, NATIONALITY.NATIONALITY_NAME as [الجنسية], EMPLOYEES.GENDER, gender.type_name as [الجنس], EMPLOYEES.MARTIAL_STATUS,\n"
            + "   marital_stats.marital_name as [الحالة الاجتماعية], EMPLOYEES.MOBILE as [رقم الهاتف], EMPLOYEES.BLOD_KIND as [فصيلة الدم],EMPLOYEES.adress as [العنوان] \n"
            + "FROM  EMPLOYEES INNER JOIN\n"
            + "gender ON EMPLOYEES.GENDER = gender.id INNER JOIN\n"
            + "JObS ON EMPLOYEES.EMP_JObID = JObS.ID INNER JOIN\n"
            + "marital_stats ON EMPLOYEES.MARTIAL_STATUS = marital_stats.id INNER JOIN\n"
            + "NATIONALITY ON EMPLOYEES.NATIONALITY_ID = NATIONALITY.ID left JOIN\n"
            + "Specialties ON EMPLOYEES.SPECIALIST_ID = Specialties.id WHERE EMPLOYEES.I=0";
    


    /**
     * Creates new form Employees
     */
    private static Employees obj = null;

    private Employees() {
        initComponents();
        this.setTitle("بيانات الموظفين");
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\src\\images\\icon.gif");
        this.setIconImage(icon);
        ((JLabel)cmbgender.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel)cmbjob.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel)cmbmarital.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel)cmbnati.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        ((JLabel)cmbspec.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel12.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel13.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jLabel9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtaddress.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtblod.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtdate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtdate2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtmobile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtnaid.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.jTable1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.txtsearch.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        filljobcombobox();
        fillnaticombobox();
        FillEmployeesData();
        btnedite.setEnabled(false);
        btndelete.setEnabled(false);
        cmbnati.setSelectedIndex(-1);
        cmbjob.setSelectedIndex(-1);
        cmbjob2.setSelectedIndex(-1);
        this.cmbjob2.show(false);
        this.cmbspec2.show(false);
        //AutoCompleteDecorator.decorate(cmbjob);

    }

    public static Employees getObj() {
        if (obj == null) {
            obj = new Employees();
        }
        return obj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtaddress = new javax.swing.JTextField();
        txtblod = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        cmbmarital = new javax.swing.JComboBox<>();
        cmbgender = new javax.swing.JComboBox<>();
        cmbnati = new javax.swing.JComboBox<>();
        cmbspec = new javax.swing.JComboBox<>();
        cmbjob = new javax.swing.JComboBox<>();
        txtdate2 = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtnaid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbjob2 = new javax.swing.JComboBox<>();
        cmbspec2 = new javax.swing.JComboBox<>();
        btnnew = new javax.swing.JButton();
        btnedite = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(51, 51, 255));
        txtaddress.setPreferredSize(new java.awt.Dimension(175, 30));

        txtblod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtblod.setForeground(new java.awt.Color(51, 51, 255));
        txtblod.setPreferredSize(new java.awt.Dimension(175, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmobile.setForeground(new java.awt.Color(51, 51, 255));
        txtmobile.setPreferredSize(new java.awt.Dimension(175, 30));

        cmbmarital.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbmarital.setForeground(new java.awt.Color(51, 51, 255));
        cmbmarital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اعزب", "متزوج", "مطلق", "ارمل" }));
        cmbmarital.setSelectedIndex(-1);
        cmbmarital.setPreferredSize(new java.awt.Dimension(175, 30));
        cmbmarital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmaritalActionPerformed(evt);
            }
        });

        cmbgender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbgender.setForeground(new java.awt.Color(51, 51, 255));
        cmbgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ذكر", "انثي" }));
        cmbgender.setSelectedIndex(-1);
        cmbgender.setPreferredSize(new java.awt.Dimension(175, 30));
        cmbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgenderActionPerformed(evt);
            }
        });

        cmbnati.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbnati.setForeground(new java.awt.Color(51, 51, 255));
        cmbnati.setPreferredSize(new java.awt.Dimension(175, 30));
        cmbnati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnatiActionPerformed(evt);
            }
        });

        cmbspec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbspec.setForeground(new java.awt.Color(51, 51, 255));
        cmbspec.setPreferredSize(new java.awt.Dimension(175, 30));
        cmbspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbspecActionPerformed(evt);
            }
        });

        cmbjob.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbjob.setForeground(new java.awt.Color(51, 51, 255));
        cmbjob.setPreferredSize(new java.awt.Dimension(175, 30));
        cmbjob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjobActionPerformed(evt);
            }
        });

        txtdate2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdate2.setForeground(new java.awt.Color(51, 51, 255));
        txtdate2.setPreferredSize(new java.awt.Dimension(175, 30));

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdate.setForeground(new java.awt.Color(51, 51, 255));
        txtdate.setPreferredSize(new java.awt.Dimension(175, 30));

        txtnaid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnaid.setForeground(new java.awt.Color(51, 51, 255));
        txtnaid.setPreferredSize(new java.awt.Dimension(175, 30));

        txtname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtname.setForeground(new java.awt.Color(51, 51, 255));
        txtname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtname.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("الاسم");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("رقم الهوية");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("تاريخ التعيين");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("تاريخ الميلاد");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("الوظيفة");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("التخصص");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("الجنسية");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("الجنس");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("الحالة الاجتماعية");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("رقم الهاتف");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("فصيلة الدم");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 255));
        jLabel13.setText("العنوان");

        cmbjob2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjob2ActionPerformed(evt);
            }
        });

        cmbspec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbspec2ActionPerformed(evt);
            }
        });

        btnnew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnew.setForeground(new java.awt.Color(0, 0, 255));
        btnnew.setText("جديد");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnedite.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnedite.setForeground(new java.awt.Color(0, 0, 255));
        btnedite.setText("تعديل");
        btnedite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnediteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 255));
        btnSave.setText("حفظ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(0, 0, 255));
        btndelete.setText("حذف");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("لتعديل او حذف موظف قم باختياره من الجدول");

        txtsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(51, 51, 255));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("بحث بالاسم");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(165, 165, 165)
                                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(139, 139, 139)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(9, 9, 9)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(103, 103, 103)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(11, 11, 11))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbmarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cmbnati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtblod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtnaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(466, 466, 466)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(cmbspec2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbjob2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(15, 15, 15))
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbjob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btndelete)
                                .addGap(27, 27, 27)
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(btnedite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnnew)
                                .addGap(59, 59, 59))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbnati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbmarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbjob2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbspec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtblod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedite, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbjobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjobActionPerformed
        // TODO add your handling code here:
        int index = cmbjob.getSelectedIndex();
        if (index != -1) {
            cmbjob2.setSelectedIndex(index);
            fillspecicombobox();
        }


    }//GEN-LAST:event_cmbjobActionPerformed

    private void cmbjob2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjob2ActionPerformed
        // TODO add your handling code here:
        int index = cmbjob2.getSelectedIndex();
        cmbjob.setSelectedIndex(index);

    }//GEN-LAST:event_cmbjob2ActionPerformed

    private void cmbspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbspecActionPerformed
        // TODO add your handling code here:
        int index = cmbspec.getSelectedIndex();
        fillspecicombobox2();
        cmbspec2.setSelectedIndex(index);
    }//GEN-LAST:event_cmbspecActionPerformed

    private void cmbspec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbspec2ActionPerformed
        // TODO add your handling code here:
        //int index = cmbspec2.getSelectedIndex();
        //cmbspec.setSelectedIndex(index);
    }//GEN-LAST:event_cmbspec2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        EmpID = Integer.parseInt(jTable1.getModel().getValueAt(row, 0).toString());
        txtname.setText(jTable1.getModel().getValueAt(row, 1).toString());
        this.txtnaid.setText(jTable1.getModel().getValueAt(row, 2).toString());
        this.txtdate.setText(jTable1.getModel().getValueAt(row, 3).toString());
        this.txtdate2.setText(jTable1.getModel().getValueAt(row, 4).toString());
        this.cmbjob2.setSelectedItem(jTable1.getModel().getValueAt(row, 5).toString());
        if (Integer.parseInt(jTable1.getModel().getValueAt(row, 7).toString()) == 0) {
            this.cmbspec.setSelectedIndex(-1);
            this.cmbspec2.setSelectedIndex(-1);
        } else {
            this.cmbspec2.setSelectedItem(jTable1.getModel().getValueAt(row, 7).toString());
            this.cmbspec.setSelectedIndex(cmbspec2.getSelectedIndex());
        }
        this.cmbnati.setSelectedIndex(Integer.parseInt(jTable1.getModel().getValueAt(row, 9).toString()) - 1);
        this.cmbgender.setSelectedIndex(Integer.parseInt(jTable1.getModel().getValueAt(row, 11).toString()) - 1);
        this.cmbmarital.setSelectedIndex(Integer.parseInt(jTable1.getModel().getValueAt(row, 13).toString()) - 1);
        this.txtmobile.setText(jTable1.getModel().getValueAt(row, 15).toString());
        this.txtblod.setText(jTable1.getModel().getValueAt(row, 16).toString());
        this.txtaddress.setText(jTable1.getModel().getValueAt(row, 17).toString());

//        jTextField1.setText(val);
//        data2.setSelectedItem(jobid);
//        Specialtiesid = (int) jTable1.getModel().getValueAt(row, 0);
        btnSave.setEnabled(false);
        btnedite.setEnabled(true);
        btndelete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Save_Data();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbnatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnatiActionPerformed
        // TODO add your handling code here:
        NATIONALITYID = cmbnati.getSelectedIndex() + 1;
    }//GEN-LAST:event_cmbnatiActionPerformed

    private void cmbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgenderActionPerformed
        // TODO add your handling code here:
        GENDERID = cmbgender.getSelectedIndex() + 1;
    }//GEN-LAST:event_cmbgenderActionPerformed

    private void cmbmaritalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmaritalActionPerformed
        // TODO add your handling code here:
        MARTIALID = cmbmarital.getSelectedIndex() + 1;
    }//GEN-LAST:event_cmbmaritalActionPerformed

    private void btnediteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnediteActionPerformed
        // TODO add your handling code here:
        Edite_Data();
    }//GEN-LAST:event_btnediteActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        Delete_Data();
        reset();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
                obj = null;
        Employees.getObj().dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped
        // TODO add your handling code here:
            String Query2 = "SELECT EMPLOYEES.ID as [الكود], EMPLOYEES.EMP_NAME as [اسم الموظف], EMPLOYEES.NATIONAL_ID as [رقم الهوية],"
            + " EMPLOYEES.DOF_BIRTH as [تاريخ الميلاد], EMPLOYEES.WORK_DATE as [تاريخ التعيين],"
            + " EMPLOYEES.EMP_JObID, JObS.JOb_NAME as [الوظيفة], EMPLOYEES.SPECIALIST_ID, Specialties.Special_name as [التخصص], \n"
            + " EMPLOYEES.NATIONALITY_ID, NATIONALITY.NATIONALITY_NAME as [الجنسية], EMPLOYEES.GENDER, gender.type_name as [الجنس], EMPLOYEES.MARTIAL_STATUS,\n"
            + "   marital_stats.marital_name as [الحالة الاجتماعية], EMPLOYEES.MOBILE as [رقم الهاتف], EMPLOYEES.BLOD_KIND as [فصيلة الدم],EMPLOYEES.adress as [العنوان] \n"
            + "FROM  EMPLOYEES INNER JOIN\n"
            + "gender ON EMPLOYEES.GENDER = gender.id INNER JOIN\n"
            + "JObS ON EMPLOYEES.EMP_JObID = JObS.ID INNER JOIN\n"
            + "marital_stats ON EMPLOYEES.MARTIAL_STATUS = marital_stats.id INNER JOIN\n"
            + "NATIONALITY ON EMPLOYEES.NATIONALITY_ID = NATIONALITY.ID left JOIN\n"
            + "Specialties ON EMPLOYEES.SPECIALIST_ID = Specialties.id WHERE EMPLOYEES.EMP_NAME like '"+ this.txtsearch.getText()+ "' + '%' and EMPLOYEES.I=0  ";
            
            SearchByName(Query2);
    }//GEN-LAST:event_txtsearchKeyTyped

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
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employees().setVisible(true);
            }
        });
    }

    private void reset() {
        this.txtaddress.setText("");
        this.txtblod.setText("");
        this.txtdate.setText("");
        this.txtdate2.setText("");
        this.txtmobile.setText("");
        this.txtnaid.setText("");
        this.txtname.setText("");
        btnSave.setEnabled(true);
        btnedite.setEnabled(false);
        btndelete.setEnabled(false);

        this.cmbgender.setSelectedIndex(-1);
        this.cmbmarital.setSelectedIndex(-1);
        this.cmbnati.setSelectedIndex(-1);
        this.cmbspec.setSelectedIndex(-1);
        cmbjob.setSelectedIndex(-1);
        cmbjob2.setSelectedIndex(-1);

        FillEmployeesData();

    }

    private void FillEmployeesData() {
        jTable1.setModel(DbUtils.resultSetToTableModel(Data.Get_Data(Query)));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(8));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(9));
    }
    
        private void SearchByName(String sql) {
        jTable1.setModel(DbUtils.resultSetToTableModel(Data.Get_Data(sql)));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(8));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(9));
    }

    private void filljobcombobox() {
        jobdata.removeAllElements();
        jobdata2.removeAllElements();
        String sql1 = "Select ID,JOB_NAME ,I from JOBS Where I=0";
        ResultSet rs = Data.Get_Data(sql1);

        try {

            while (rs.next()) {
                jobdata.addElement(rs.getString("JOB_NAME"));
                jobdata2.addElement(rs.getString("ID"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        cmbjob.setModel(jobdata);
        cmbjob2.setModel(jobdata2);
    }

    private void fillspecicombobox() {
        specidata.removeAllElements();

        String sql1 = "select ID,Special_name from Specialties where Job_id = '" + cmbjob2.getSelectedItem().toString() + "' and I=0";
        ResultSet rs = Data.Get_Data(sql1);

        try {

            while (rs.next()) {
                specidata.addElement(rs.getString("Special_name"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        cmbspec.setModel(specidata);

    }

    private void fillspecicombobox2() {
        specidata2.removeAllElements();

        String sql1 = "select ID,Special_name from Specialties where Job_id = '" + cmbjob2.getSelectedItem().toString() + "' and I=0";
        ResultSet rs = Data.Get_Data(sql1);

        try {

            while (rs.next()) {
                specidata2.addElement(rs.getString("ID"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        cmbspec2.setModel(specidata2);

    }

    private void fillnaticombobox() {
        specidata2.removeAllElements();

        String sql1 = "select ID,NATIONALITY_NAME from NATIONALITY where  I=0";
        ResultSet rs = Data.Get_Data(sql1);

        try {

            while (rs.next()) {
                natidata.addElement(rs.getString("NATIONALITY_NAME"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        cmbnati.setModel(natidata);

    }

    private boolean checkinput() {
        if (txtname.getText().trim().equals("")) {
            txtname.requestFocus();
            JOptionPane.showMessageDialog(this, "ادخل الاسم", "خطأ", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txtnaid.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ادخل رقم الهوية", "خطأ", JOptionPane.ERROR_MESSAGE);
            txtnaid.requestFocus();
            return false;
        } else if (txtdate.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ادخل تاريخ التعيين", "خطأ", JOptionPane.ERROR_MESSAGE);
            txtdate.requestFocus();
            return false;
        } else if (txtdate2.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ادخل تاريخ الميلاد", "خطأ", JOptionPane.ERROR_MESSAGE);
            txtdate2.requestFocus();
            return false;
        } else if (cmbjob2.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "اختر الوظيفة", "خطأ", JOptionPane.ERROR_MESSAGE);
            cmbjob2.requestFocus();
            return false;
        } else if (cmbnati.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "اختر الجنسية", "خطأ", JOptionPane.ERROR_MESSAGE);
            cmbnati.requestFocus();
            return false;
        } else if (cmbgender.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "اختر الجنس", "خطأ", JOptionPane.ERROR_MESSAGE);
            cmbgender.requestFocus();
            return false;
        } else if (cmbmarital.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "اختر الحالة الاجتماعية", "خطأ", JOptionPane.ERROR_MESSAGE);
            cmbmarital.requestFocus();
            return false;
        } else if (txtmobile.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ادخل رقم الهاتف", "خطأ", JOptionPane.ERROR_MESSAGE);
            txtmobile.requestFocus();
            return false;
        } else if (txtaddress.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ادخل العنوان", "خطأ", JOptionPane.ERROR_MESSAGE);
            txtaddress.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void Save_Data() {
        if (cmbspec2.getSelectedItem() == null) {
            SPECIALISTID = 0;
        } else {
            SPECIALISTID = Integer.parseInt(cmbspec2.getSelectedItem().toString());
        }
        if (checkinput()) {

            try {
                String sql1 = "Select ID,EMP_NAME ,I from Employees "
                        + "where EMP_NAME= '" + txtname.getText() + "' or NATIONAL_ID = '" + txtnaid.getText() + "'";

                ResultSet rs = Data.Get_Data(sql1);

                if (rs.next()) {
                    if (rs.getInt("I") == 0) {
                        JOptionPane.showMessageDialog(this, "يوجد موظف بنفس البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
                        txtname.requestFocus();
                    } else {
                        try {
                            int P = JOptionPane.showConfirmDialog(this, "الموظف محذوف هل تريد استعادته", "تأكيد", JOptionPane.YES_NO_OPTION);
                            if (P == 0) {
                                String sql = "update Employees set I='" + 0 + "' where ID='" + rs.getInt("ID") + "'";
                                int i = Data.Save_Data(sql);
                                if (i == 0) {
                                    JOptionPane.showMessageDialog(this, "تم استعادة الموظف", "استعادة موظف", JOptionPane.INFORMATION_MESSAGE);
                                    btnSave.setEnabled(true);
                                    btnedite.setEnabled(false);
                                    btndelete.setEnabled(false);
                                    FillEmployeesData();
                                }

                            }

                        } catch (HeadlessException | SQLException ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }

                    }

                } else {
                    String sql = "INSERT INTO EMPLOYEES (EMP_NAME,NATIONAL_ID,DOF_BIRTH,WORK_DATE,EMP_JObID,SPECIALIST_ID,\n"
                            + "NATIONALITY_ID,GENDER,MARTIAL_STATUS,MOBILE,BLOD_KIND,adress,i) VALUES \n"
                            + "('" + txtname.getText() + "','" + txtnaid.getText() + "','" + txtdate2.getText() + "','" + txtdate.getText() + "','" + cmbjob2.getSelectedItem() + "',\n"
                            + "'" + SPECIALISTID + "','" + NATIONALITYID + "','" + GENDERID + "','" + MARTIALID + "',"
                            + "'" + txtmobile.getText() + "','" + txtblod.getText() + "','" + txtaddress.getText() + "',0)";
                    int i = Data.Save_Data(sql);
                    if (i == 0) {
                        JOptionPane.showMessageDialog(this, "تم الحفظ بنجاح", "اضافة موظف", JOptionPane.INFORMATION_MESSAGE);
                        FillEmployeesData();
                        btnSave.setEnabled(false);
                    }

                }

            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        }

    }

    public void Edite_Data() {
                if (cmbspec2.getSelectedItem() == null) {
            SPECIALISTID = 0;
        } else {
            SPECIALISTID = Integer.parseInt(cmbspec2.getSelectedItem().toString());
        }

        if (checkinput()){
                    try {

            String sql1 = "Select ID,EMP_NAME ,I from Employees "
                    + "where ID != '" + EmpID + "' and (EMP_NAME= '" + txtname.getText() + "' or NATIONAL_ID = '" + txtnaid.getText() + "' ) ";

            ResultSet rs = Data.Get_Data(sql1);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "يوجد موظف بنفس البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
                txtname.requestFocus();

            } else {

                int P = JOptionPane.showConfirmDialog(this, "هل تريد تعديل بيانات الموظف", "تأكيد", JOptionPane.YES_NO_OPTION);
                if (P == 0) {
                    String sql = "update EMPLOYEES set EMP_NAME='"+txtname.getText()+"',NATIONAL_ID='"+txtnaid.getText()+"',DOF_BIRTH='"+txtdate2.getText()+"',\n"
                            + "WORK_DATE='"+txtdate.getText()+"',EMP_JObID='"+cmbjob2.getSelectedItem()+"',SPECIALIST_ID='"+SPECIALISTID+"',\n"
                            + "NATIONALITY_ID='"+NATIONALITYID+"',GENDER='"+GENDERID+"',MARTIAL_STATUS='"+MARTIALID+"',\n"
                            + "MOBILE='"+ txtmobile.getText()+"',BLOD_KIND='"+txtblod.getText()+"',adress='"+txtaddress.getText()+"' \n"
                            + "where ID='"+EmpID+"' ";
                    int i = Data.Save_Data(sql);
                    if (i == 0) {
                        JOptionPane.showMessageDialog(this, "تم التعديل بنجاح", "تعديل موظف", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                }
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
            
        }


    }
    
        public void Delete_Data() {
        try {
            int P = JOptionPane.showConfirmDialog(this, "سيتم حذف الموظف ولن تتمكن من استعادته", "تأكيد", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                Connection con = DatabaseConnection.con();
                PreparedStatement pst = null;

                String sql = "update EMPLOYEES set I='" + 1 + "' where ID='" + EmpID + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "تم الحذف بنجاح", "حذف موظف", JOptionPane.INFORMATION_MESSAGE);
                btnSave.setEnabled(true);
                btnedite.setEnabled(false);
                btndelete.setEnabled(false);
                FillEmployeesData();
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedite;
    private javax.swing.JButton btnnew;
    private javax.swing.JComboBox<String> cmbgender;
    private javax.swing.JComboBox<String> cmbjob;
    private javax.swing.JComboBox<String> cmbjob2;
    private javax.swing.JComboBox<String> cmbmarital;
    private javax.swing.JComboBox<String> cmbnati;
    private javax.swing.JComboBox<String> cmbspec;
    private javax.swing.JComboBox<String> cmbspec2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtblod;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdate2;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtnaid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
