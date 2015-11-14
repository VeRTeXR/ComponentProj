/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KOKOKRUNCH
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByStdid", query = "SELECT r FROM Report r WHERE r.stdid = :stdid"),
    @NamedQuery(name = "Report.findByReport", query = "SELECT r FROM Report r WHERE r.report = :report"),
    @NamedQuery(name = "Report.findByApprove", query = "SELECT r FROM Report r WHERE r.approve = :approve")})
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STDID")
    private Integer stdid;
    @Size(max = 500)
    @Column(name = "REPORT")
    private String report;
    @Column(name = "APPROVE")
    private Boolean approve;

    public Report() {
    }

    public Report(Integer stdid) {
        this.stdid = stdid;
    }

    public Integer getStdid() {
        return stdid;
    }

    public void setStdid(Integer stdid) {
        this.stdid = stdid;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdid != null ? stdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.stdid == null && other.stdid != null) || (this.stdid != null && !this.stdid.equals(other.stdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Report[ stdid=" + stdid + " ]";
    }
    
}
