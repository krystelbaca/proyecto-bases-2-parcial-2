/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eopg9
 */
@Entity
@Table(name = "VIEW_ALL_EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewEmployee.findAll", query = "SELECT v FROM ViewEmployee v"),
    @NamedQuery(name = "ViewEmployee.findByEmployeeId", query = "SELECT v FROM ViewEmployee v WHERE v.employeeId = :employeeId"),
    @NamedQuery(name = "ViewEmployee.findByFirstName", query = "SELECT v FROM ViewEmployee v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "ViewEmployee.findByLastName", query = "SELECT v FROM ViewEmployee v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "ViewEmployee.findByEmail", query = "SELECT v FROM ViewEmployee v WHERE v.email = :email"),
    @NamedQuery(name = "ViewEmployee.findByPhoneNumber", query = "SELECT v FROM ViewEmployee v WHERE v.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "ViewEmployee.findByHireDate", query = "SELECT v FROM ViewEmployee v WHERE v.hireDate = :hireDate"),
    @NamedQuery(name = "ViewEmployee.findByJobId", query = "SELECT v FROM ViewEmployee v WHERE v.jobId = :jobId"),
    @NamedQuery(name = "ViewEmployee.findBySalary", query = "SELECT v FROM ViewEmployee v WHERE v.salary = :salary"),
    @NamedQuery(name = "ViewEmployee.findByCommissionPct", query = "SELECT v FROM ViewEmployee v WHERE v.commissionPct = :commissionPct"),
    @NamedQuery(name = "ViewEmployee.findByManagerId", query = "SELECT v FROM ViewEmployee v WHERE v.managerId = :managerId"),
    @NamedQuery(name = "ViewEmployee.findByDepartmentId", query = "SELECT v FROM ViewEmployee v WHERE v.departmentId = :departmentId")})
public class ViewEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Column(name = "JOB_ID")
    private String jobId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;

    public ViewEmployee() {
    }

    public ViewEmployee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public ViewEmployee(String firstName) {
        setEmployeeId(employeeId);
        this.firstName = firstName;
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setHireDate(hireDate);
        setJobId(jobId);
        setSalary(salary);
        setCommissionPct(commissionPct);
        setManagerId(managerId);
        setDepartmentId(departmentId);
    }
    
    

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewEmployee)) {
            return false;
        }
        ViewEmployee other = (ViewEmployee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ViewEmployee[ employeeId=" + employeeId + " ]";
    }
    
}
