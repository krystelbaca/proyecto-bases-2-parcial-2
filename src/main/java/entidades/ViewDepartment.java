/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eopg9
 */
@Entity
@Table(name = "VIEW_ALL_DEPARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewDepartment.findAll", query = "SELECT v FROM ViewDepartment v"),
    @NamedQuery(name = "ViewDepartment.findByDepartmentId", query = "SELECT v FROM ViewDepartment v WHERE v.departmentId = :departmentId"),
    @NamedQuery(name = "ViewDepartment.findByDepartmentName", query = "SELECT v FROM ViewDepartment v WHERE v.departmentName = :departmentName"),
    @NamedQuery(name = "ViewDepartment.findByManagerId", query = "SELECT v FROM ViewDepartment v WHERE v.managerId = :managerId"),
    @NamedQuery(name = "ViewDepartment.findByLocationId", query = "SELECT v FROM ViewDepartment v WHERE v.locationId = :locationId")})
public class ViewDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "LOCATION_ID")
    private Short locationId;

    public ViewDepartment() {
    }

    public ViewDepartment(Short departmentId) {
        this.departmentId = departmentId;
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
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
        if (!(object instanceof ViewDepartment)) {
            return false;
        }
        ViewDepartment other = (ViewDepartment) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ViewDepartment[ departmentId=" + departmentId + " ]";
    }
    
}
