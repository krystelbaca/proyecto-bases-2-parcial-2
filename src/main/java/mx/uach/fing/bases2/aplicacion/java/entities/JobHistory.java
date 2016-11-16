/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eopg9
 */
@Entity
@Table(name = "JOB_HISTORY")
@NamedQueries({
    @NamedQuery(name = "JobHistory.findAll", query = "SELECT j FROM JobHistory j")})
public class JobHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobHistoryPK jobHistoryPK;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Departments departmentId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(optional = false)
    private Jobs jobId;

    public JobHistory() {
    }

    public JobHistory(JobHistoryPK jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public JobHistory(JobHistoryPK jobHistoryPK, Date endDate) {
        this.jobHistoryPK = jobHistoryPK;
        this.endDate = endDate;
    }

    public JobHistory(int employeeId, Date startDate) {
        this.jobHistoryPK = new JobHistoryPK(employeeId, startDate);
    }

    public JobHistoryPK getJobHistoryPK() {
        return jobHistoryPK;
    }

    public void setJobHistoryPK(JobHistoryPK jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobHistoryPK != null ? jobHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobHistory)) {
            return false;
        }
        JobHistory other = (JobHistory) object;
        if ((this.jobHistoryPK == null && other.jobHistoryPK != null) || (this.jobHistoryPK != null && !this.jobHistoryPK.equals(other.jobHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.fing.bases2.aplicacion.java.entities.JobHistory[ jobHistoryPK=" + jobHistoryPK + " ]";
    }
    
}
