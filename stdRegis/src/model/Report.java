/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Sakdinan
 */

public class Report  {
   
    //@Column(name = "STDID")
    private Integer stdid;
    //@Column(name = "REPORT")
    private String report;
    //@Column(name = "APPROVE")
    private Boolean approve;

    

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

    /*@Override
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
    }*/
    
}
