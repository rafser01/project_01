/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstocktrader.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e"),
    @NamedQuery(name = "Eps.findByEpsId", query = "SELECT e FROM Eps e WHERE e.epsId = :epsId"),
    @NamedQuery(name = "Eps.findByEps", query = "SELECT e FROM Eps e WHERE e.eps = :eps"),
    @NamedQuery(name = "Eps.findByRevenue", query = "SELECT e FROM Eps e WHERE e.revenue = :revenue"),
    @NamedQuery(name = "Eps.findByProfit", query = "SELECT e FROM Eps e WHERE e.profit = :profit"),
    @NamedQuery(name = "Eps.findByRemark1", query = "SELECT e FROM Eps e WHERE e.remark1 = :remark1"),
    @NamedQuery(name = "Eps.findByRemark2", query = "SELECT e FROM Eps e WHERE e.remark2 = :remark2")})
public class Eps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eps_id")
    private Integer epsId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "eps")
    private Double eps;
    @Column(name = "revenue")
    private Double revenue;
    @Column(name = "profit")
    private Double profit;
    @Column(name = "remark1")
    private Double remark1;
    @Column(name = "remark2")
    private Double remark2;
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    @ManyToOne
    private Stock stockId;

    public Eps() {
    }

    public Eps(Integer epsId) {
        this.epsId = epsId;
    }

    public Integer getEpsId() {
        return epsId;
    }

    public void setEpsId(Integer epsId) {
        this.epsId = epsId;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getRemark1() {
        return remark1;
    }

    public void setRemark1(Double remark1) {
        this.remark1 = remark1;
    }

    public Double getRemark2() {
        return remark2;
    }

    public void setRemark2(Double remark2) {
        this.remark2 = remark2;
    }

    public Stock getStockId() {
        return stockId;
    }

    public void setStockId(Stock stockId) {
        this.stockId = stockId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epsId != null ? epsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.epsId == null && other.epsId != null) || (this.epsId != null && !this.epsId.equals(other.epsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Eps[ epsId=" + epsId + " ]";
    }
    
}
