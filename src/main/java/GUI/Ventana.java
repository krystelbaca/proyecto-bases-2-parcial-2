/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entidades.ViewEmployee;
import entidades.ViewLocation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Interfaces.DepartmentInterface;
import Interfaces.EmployeeInterface;
import entidades.Country;
import entidades.Job;
import entidades.ViewDepartment;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author kryst
 */
public class Ventana extends javax.swing.JFrame {

    EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("proyectoPU");
    EntityManager em = emf.createEntityManager();    
    
    Query querySelectEmp = em.createNamedQuery("ViewEmployee.findAll");
    List<ViewEmployee> employees = querySelectEmp.getResultList();     
    
    Query querySelectLoc = em.createNamedQuery("ViewLocation.findAll");
    List<ViewLocation> locations = querySelectLoc.getResultList(); 
    
    Query querySelectDep = em.createNamedQuery("ViewDepartment.findAll");
    ArrayList<ViewDepartment> departments = (ArrayList<ViewDepartment>) 
            querySelectDep.getResultList(); 
        
    Query querySelectJob = em.createNamedQuery("Job.findAll");
    List<Job> jobs = querySelectJob.getResultList();   
    
    Query querySelectCou = em.createNamedQuery("Country.findAll");
    List<Country> countries = querySelectCou.getResultList();        
    
    ViewEmployee currentEmployee = new ViewEmployee();
    public Ventana() {
        initComponents();
        
        em.getTransaction();       
        for (ViewEmployee employee : employees) {
            String employeeItem = String.format("%s %s (%s)", 
                    employee.getFirstName(), 
                    employee.getLastName(),
                    employee.getEmployeeId());
            managercmb.addItem(employeeItem);
            managerempcmb.addItem(employeeItem);
            empladoscmb.addItem(employeeItem);
        }

        for (ViewLocation location : locations) {
            String locationItem = String.format("%s, %s",
                    location.getCity(), 
                    location.getCountryId());
            locationcmb.addItem(locationItem);
        }        
        
        for (ViewDepartment department : departments) {
            String departmentItem = String.format("%s (%s)",
                    department.getDepartmentName(), 
                    department.getDepartmentId());
            deptoempcmb.addItem(departmentItem);
        }       
        
        for (Job job : jobs) {
            String jobItem = String.format("%s (%s)",
                    job.getJobTitle(), 
                    job.getJobId());
            puestocmb.addItem(jobItem);
        }
        
        for (Country country : countries) {
            String jobItem = String.format("%s (%s)",
                    country.getCountryName(), 
                    country.getCountryId());
            paiscmb.addItem(jobItem);
        }
        em.close();
    }
    
    public Integer getEmployeeId(){
        Integer indexSelected = empladoscmb.getSelectedIndex();
        Integer employeeId = employees.get(indexSelected).getEmployeeId();
        return employeeId;
    }
    
    public Integer getManagerId(){
        Integer indexSelected = managercmb.getSelectedIndex();
        Integer managerId = employees.get(indexSelected).getEmployeeId();
        return managerId;
    }
    
    public Integer getManagerEmpId(){
        Integer indexSelected = managerempcmb.getSelectedIndex();
        Integer managerEmpId = employees.get(indexSelected).getEmployeeId();
        return managerEmpId;
    } 
    
    public Short getLocationId(){
        Integer indexSelected = locationcmb.getSelectedIndex();
        Short employeeId = locations.get(indexSelected).getLocationId();
        return employeeId;
    } 
    
    public Short getDepartmentId(){
        Integer indexSelected = deptoempcmb.getSelectedIndex();
        Short departmentId = departments.get(indexSelected).getDepartmentId();
        return departmentId;
    } 
    
    public String getJobId(){
        Integer indexSelected = puestocmb.getSelectedIndex();
        String jobId = jobs.get(indexSelected).getJobId();
        return jobId;
    } 
    
    public String getContryId(){
        Integer indexSelected = puestocmb.getSelectedIndex();
        String countryId = countries.get(indexSelected).getCountryId();
        return countryId;
    } 
    
    public Integer findDepartmentIndex(Short departmentId){
        for(Integer x=0; x<departments.size(); x++) {
            if (Objects.equals(departmentId, departments.get(x)
                    .getDepartmentId())) {
                return x;
            }
        }
        return -1;
    }
    
    public Integer findManagerEmpIndex(Integer managerId){
        for(Integer x=0; x<employees.size(); x++) {
            if (Objects.equals(managerId, employees.get(x).getEmployeeId())) {
                return x;
            }
        }
        return -1;
    }  
    
    public Integer findJobIndex(String JobId){
        for(Integer x=0; x<jobs.size(); x++) {
            if (Objects.equals(JobId, jobs.get(x).getJobId())) {
                return x;
            }
        }
        return -1;
    }        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        employeespnl = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        deptoempcmb = new javax.swing.JComboBox<String>();
        managerempcmb = new javax.swing.JComboBox<String>();
        puestocmb = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comlbl = new javax.swing.JTextField();
        slrlbl = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        phonelbl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emaillbl = new javax.swing.JTextField();
        lastNamelbl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empNamelbl = new javax.swing.JTextField();
        employeeIDlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dchcontratacion = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        eliminarcmdemp = new javax.swing.JButton();
        insertarcmdemp = new javax.swing.JButton();
        actualizarcmdemp = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        buscarcmdemp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        empladoscmb = new javax.swing.JComboBox<String>();
        deptospnl = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        locationcmb = new javax.swing.JComboBox<String>();
        managercmb = new javax.swing.JComboBox<String>();
        deptoNametxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        deptoIDlbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        insertarcmddep = new javax.swing.JButton();
        actualizarcmddep = new javax.swing.JButton();
        eliminarcmddep = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        buscardeptxt = new javax.swing.JTextField();
        buscarcmddep = new javax.swing.JButton();
        locacionespnl = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ciudadtxt = new javax.swing.JTextField();
        cpostaltxt = new javax.swing.JTextField();
        direcciontxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        locationIDlbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        paiscmb = new javax.swing.JComboBox<String>();
        estadotxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        eliminarcmddep1 = new javax.swing.JButton();
        actualizarcmddep1 = new javax.swing.JButton();
        insertarcmddep1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deptoempcmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-selecionar departamento-" }));
        deptoempcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptoempcmbActionPerformed(evt);
            }
        });

        managerempcmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-selecionar jefe-" }));
        managerempcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerempcmbActionPerformed(evt);
            }
        });

        puestocmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-selecionar puesto-" }));

        jLabel8.setText("Puesto:");

        jLabel10.setText("Jefe:");

        jLabel11.setText("Departamento:");

        comlbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comlblActionPerformed(evt);
            }
        });

        jLabel22.setText("Comision:");

        jLabel23.setText("Salario:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(managerempcmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puestocmb, 0, 235, Short.MAX_VALUE)
                            .addComponent(deptoempcmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slrlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slrlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(puestocmb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(managerempcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptoempcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setText("Telefono:");

        jLabel6.setText("Email:");

        lastNamelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNamelblActionPerformed(evt);
            }
        });

        jLabel5.setText("Apellidos:");

        jLabel4.setText("Nombre:");

        empNamelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNamelblActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        jLabel24.setText("Contratacion:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employeeIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 231, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(empNamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(emaillbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phonelbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lastNamelbl)
                            .addComponent(dchcontratacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empNamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dchcontratacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(19, 19, 19))))
        );

        eliminarcmdemp.setText("Eliminar");
        eliminarcmdemp.setEnabled(false);

        insertarcmdemp.setText("Insertar");
        insertarcmdemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarcmdempActionPerformed(evt);
            }
        });

        actualizarcmdemp.setText("Actualizar");
        actualizarcmdemp.setEnabled(false);
        actualizarcmdemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarcmdempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertarcmdemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actualizarcmdemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarcmdemp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertarcmdemp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualizarcmdemp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarcmdemp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        buscarcmdemp.setText("Consultar");
        buscarcmdemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarcmdempActionPerformed(evt);
            }
        });

        jLabel2.setText("Registro:");

        empladoscmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-selecionar empleado-" }));
        empladoscmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empladoscmbItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(empladoscmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(buscarcmdemp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarcmdemp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empladoscmb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout employeespnlLayout = new javax.swing.GroupLayout(employeespnl);
        employeespnl.setLayout(employeespnlLayout);
        employeespnlLayout.setHorizontalGroup(
            employeespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeespnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(employeespnlLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        employeespnlLayout.setVerticalGroup(
            employeespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeespnlLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(employeespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Empleados", employeespnl);

        managercmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managercmbActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre:");

        jLabel14.setText("Manager:");

        jLabel15.setText("Locacion:");

        jLabel12.setText("ID:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(managercmb, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deptoIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deptoNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptoIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptoNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managercmb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        insertarcmddep.setText("Insertar");
        insertarcmddep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarcmddepActionPerformed(evt);
            }
        });

        actualizarcmddep.setText("Actualizar");
        actualizarcmddep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarcmddepActionPerformed(evt);
            }
        });

        eliminarcmddep.setText("Eliminar");
        eliminarcmddep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarcmddepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertarcmddep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actualizarcmddep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(insertarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualizarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jLabel9.setText("Buscar:");

        buscarcmddep.setText("Buscar");
        buscarcmddep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarcmddepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscardeptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscardeptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(buscarcmddep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout deptospnlLayout = new javax.swing.GroupLayout(deptospnl);
        deptospnl.setLayout(deptospnlLayout);
        deptospnlLayout.setHorizontalGroup(
            deptospnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deptospnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deptospnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(deptospnlLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        deptospnlLayout.setVerticalGroup(
            deptospnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deptospnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(deptospnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Departamentos", deptospnl);

        jLabel17.setText("Direccion:");

        locationIDlbl.setText("jLabel17");

        jLabel16.setText("ID:");

        jLabel18.setText("Codigo Postal:");

        jLabel19.setText("Ciudad:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(direcciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpostaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ciudadtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direcciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpostaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setText("Pais:");

        paiscmb.setToolTipText("");
        paiscmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paiscmbActionPerformed(evt);
            }
        });

        estadotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadotxtActionPerformed(evt);
            }
        });

        jLabel20.setText("Estado:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paiscmb, 0, 173, Short.MAX_VALUE)
                    .addComponent(estadotxt))
                .addGap(126, 126, 126))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paiscmb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eliminarcmddep1.setText("Eliminar");
        eliminarcmddep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarcmddep1ActionPerformed(evt);
            }
        });

        actualizarcmddep1.setText("Actualizar");
        actualizarcmddep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarcmddep1ActionPerformed(evt);
            }
        });

        insertarcmddep1.setText("Insertar");
        insertarcmddep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarcmddep1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertarcmddep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actualizarcmddep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarcmddep1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(insertarcmddep1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualizarcmddep1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarcmddep1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout locacionespnlLayout = new javax.swing.GroupLayout(locacionespnl);
        locacionespnl.setLayout(locacionespnlLayout);
        locacionespnlLayout.setHorizontalGroup(
            locacionespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locacionespnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        locacionespnlLayout.setVerticalGroup(
            locacionespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locacionespnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(locacionespnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Locaciones", locacionespnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastNamelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNamelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNamelblActionPerformed

    private void insertarcmdempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarcmdempActionPerformed
            EmployeeInterface employee = new EmployeeInterface();
        try {
            java.util.Date fecha = dchcontratacion.getDate();
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
            employee.addEmployee(empNamelbl.getText(), lastNamelbl.getText(),
                                emaillbl.getText(), phonelbl.getText(), 
                                sqlFecha, getJobId(),
                                Float.parseFloat(slrlbl.getText()),
                                Float.parseFloat(comlbl.getText()),
                                getManagerEmpId(), getDepartmentId());           
            
            employees = querySelectEmp.getResultList();     
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level
                    .SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertarcmdempActionPerformed

    private void actualizarcmdempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarcmdempActionPerformed
            EmployeeInterface employee = new EmployeeInterface();
        try {
            java.util.Date fecha = dchcontratacion.getDate();
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
            employee.updateEmployee(currentEmployee.getEmployeeId(), empNamelbl.getText(),
                                lastNamelbl.getText(), emaillbl.getText(),
                                phonelbl.getText(), sqlFecha, getJobId(),
                                Float.parseFloat(slrlbl.getText()),
                                Float.parseFloat(comlbl.getText()),
                                getManagerEmpId(), getDepartmentId());           
            
            employees = querySelectEmp.getResultList();     
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_actualizarcmdempActionPerformed

    private void insertarcmddepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarcmddepActionPerformed
            DepartmentInterface department = new DepartmentInterface();
        try {
            department.addDepartment(deptoNametxt.getText(),
                                     getManagerId(),
                                     getLocationId());
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_insertarcmddepActionPerformed

    private void actualizarcmddepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarcmddepActionPerformed

    }//GEN-LAST:event_actualizarcmddepActionPerformed

    private void eliminarcmddepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarcmddepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarcmddepActionPerformed

    private void eliminarcmddep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarcmddep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarcmddep1ActionPerformed

    private void insertarcmddep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarcmddep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertarcmddep1ActionPerformed

    private void actualizarcmddep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarcmddep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarcmddep1ActionPerformed

    private void managercmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managercmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managercmbActionPerformed

    private void managerempcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerempcmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerempcmbActionPerformed

    private void deptoempcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptoempcmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptoempcmbActionPerformed

    private void empNamelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNamelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNamelblActionPerformed

    private void paiscmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paiscmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paiscmbActionPerformed

    private void estadotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadotxtActionPerformed

    private void buscarcmdempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarcmdempActionPerformed
        EntityManager em = emf.createEntityManager();    
        try {
            Query queryEmp = em
                    .createNamedQuery("ViewEmployee.findByEmployeeId")
                    .setParameter("employeeId", getEmployeeId());
            currentEmployee = (ViewEmployee) queryEmp.getSingleResult();
            employeeIDlbl.setText(currentEmployee.getEmployeeId().toString());
            empNamelbl.setText(currentEmployee.getFirstName());
            lastNamelbl.setText(currentEmployee.getLastName());
            emaillbl.setText(currentEmployee.getEmail());
            phonelbl.setText(currentEmployee.getPhoneNumber());
            slrlbl.setText(currentEmployee.getSalary()
                            .toString());
            dchcontratacion.setDate(currentEmployee
                            .getHireDate());
            deptoempcmb.setSelectedIndex(findDepartmentIndex(currentEmployee
                            .getDepartmentId()));
            managerempcmb.setSelectedIndex(findManagerEmpIndex(currentEmployee
                            .getManagerId()));
            puestocmb.setSelectedIndex(findJobIndex(currentEmployee
                            .getJobId()));
            
            actualizarcmdemp.setEnabled(true);
            eliminarcmdemp.setEnabled(true);
            insertarcmdemp.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el empleado");
        }
        if(!(currentEmployee.getCommissionPct() == null)) {
                comlbl.setText(currentEmployee.getCommissionPct().toString());
            } else {
                comlbl.setText("");
            }

    }//GEN-LAST:event_buscarcmdempActionPerformed

    private void comlblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comlblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comlblActionPerformed

    private void buscarcmddepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarcmddepActionPerformed
        EntityManager em = emf.createEntityManager();    
        ViewDepartment department = new ViewDepartment();
        Query queryDep = em
                .createNamedQuery("ViewDepartment.findByDepartmentName")
                .setParameter("departmentName", buscardeptxt.getText());
        department = (ViewDepartment) queryDep
                .getSingleResult();
        deptoIDlbl.setText(department.getDepartmentId()
                .toString());
        deptoNametxt.setText(department.getDepartmentName());
    }//GEN-LAST:event_buscarcmddepActionPerformed

    private void empladoscmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_empladoscmbItemStateChanged
        if (empladoscmb.getSelectedIndex() == 0){
            actualizarcmdemp.setEnabled(false);
            eliminarcmdemp.setEnabled(false);
            insertarcmdemp.setEnabled(true);    
            employeeIDlbl.setText("");
            empNamelbl.setText("");
            lastNamelbl.setText("");
            emaillbl.setText("");
            phonelbl.setText("");
            slrlbl.setText("");
            dchcontratacion.setCalendar(null);
            deptoempcmb.setSelectedIndex(0);
            managerempcmb.setSelectedIndex(0);
            puestocmb.setSelectedIndex(0);
        } else {
        }
    }//GEN-LAST:event_empladoscmbItemStateChanged

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarcmddep;
    private javax.swing.JButton actualizarcmddep1;
    private javax.swing.JButton actualizarcmdemp;
    private javax.swing.JButton buscarcmddep;
    private javax.swing.JButton buscarcmdemp;
    private javax.swing.JTextField buscardeptxt;
    private javax.swing.JTextField ciudadtxt;
    private javax.swing.JTextField comlbl;
    private javax.swing.JTextField cpostaltxt;
    private com.toedter.calendar.JDateChooser dchcontratacion;
    private javax.swing.JLabel deptoIDlbl;
    private javax.swing.JTextField deptoNametxt;
    private javax.swing.JComboBox<String> deptoempcmb;
    private javax.swing.JPanel deptospnl;
    private javax.swing.JTextField direcciontxt;
    private javax.swing.JButton eliminarcmddep;
    private javax.swing.JButton eliminarcmddep1;
    private javax.swing.JButton eliminarcmdemp;
    private javax.swing.JTextField emaillbl;
    private javax.swing.JTextField empNamelbl;
    private javax.swing.JComboBox<String> empladoscmb;
    private javax.swing.JLabel employeeIDlbl;
    private javax.swing.JPanel employeespnl;
    private javax.swing.JTextField estadotxt;
    private javax.swing.JButton insertarcmddep;
    private javax.swing.JButton insertarcmddep1;
    private javax.swing.JButton insertarcmdemp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lastNamelbl;
    private javax.swing.JPanel locacionespnl;
    private javax.swing.JLabel locationIDlbl;
    private javax.swing.JComboBox<String> locationcmb;
    private javax.swing.JComboBox<String> managercmb;
    private javax.swing.JComboBox<String> managerempcmb;
    private javax.swing.JComboBox<String> paiscmb;
    private javax.swing.JTextField phonelbl;
    private javax.swing.JComboBox<String> puestocmb;
    private javax.swing.JTextField slrlbl;
    // End of variables declaration//GEN-END:variables
}
