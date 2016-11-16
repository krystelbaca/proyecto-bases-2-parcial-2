/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eopg9
 */
@Entity
@Table(name = "DEPARTMENTS")
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")})
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @OneToMany(mappedBy = "departmentId")
    private Collection<Employees> employeesCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<JobHistory> jobHistoryCollection;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employees managerId;
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    @ManyToOne
    private Locations locationId;

    public Departments() {
    }

    public Departments(Short departmentId) {
        this.departmentId = departmentId;
    }

    public Departments(Short departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Collection<JobHistory> getJobHistoryCollection() {
        return jobHistoryCollection;
    }

    public void setJobHistoryCollection(Collection<JobHistory> jobHistoryCollection) {
        this.jobHistoryCollection = jobHistoryCollection;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Locations getLocationId() {
        return locationId;
    }

    public void setLocationId(Locations locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.fing.bases2.aplicacion.java.entities.Departments[ departmentId=" + departmentId + " ]";
    }
    
}
