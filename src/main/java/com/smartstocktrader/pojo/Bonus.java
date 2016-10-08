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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bonus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonus.findAll", query = "SELECT b FROM Bonus b"),
    @NamedQuery(name = "Bonus.findByBonusId", query = "SELECT b FROM Bonus b WHERE b.bonusId = :bonusId"),
    @NamedQuery(name = "Bonus.findByBonusShare", query = "SELECT b FROM Bonus b WHERE b.bonusShare = :bonusShare"),
    @NamedQuery(name = "Bonus.findByBonusCash", query = "SELECT b FROM Bonus b WHERE b.bonusCash = :bonusCash"),
    @NamedQuery(name = "Bonus.findByRightShare", query = "SELECT b FROM Bonus b WHERE b.rightShare = :rightShare"),
    @NamedQuery(name = "Bonus.findByRemark1", query = "SELECT b FROM Bonus b WHERE b.remark1 = :remark1"),
    @NamedQuery(name = "Bonus.findByRemark2", query = "SELECT b FROM Bonus b WHERE b.remark2 = :remark2")})
public class Bonus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bonus_id")
    private Integer bonusId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bonus_share")
    private Double bonusShare;
    @Column(name = "bonus_cash")
    private Double bonusCash;
    @Column(name = "right_share")
    private Double rightShare;
    @Column(name = "remark1")
    private Double remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    @ManyToOne
    private Stock stockId;

    public Bonus() {
    }

    public Bonus(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public Double getBonusShare() {
        return bonusShare;
    }

    public void setBonusShare(Double bonusShare) {
        this.bonusShare = bonusShare;
    }

    public Double getBonusCash() {
        return bonusCash;
    }

    public void setBonusCash(Double bonusCash) {
        this.bonusCash = bonusCash;
    }

    public Double getRightShare() {
        return rightShare;
    }

    public void setRightShare(Double rightShare) {
        this.rightShare = rightShare;
    }

    public Double getRemark1() {
        return remark1;
    }

    public void setRemark1(Double remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
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
        hash += (bonusId != null ? bonusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonus)) {
            return false;
        }
        Bonus other = (Bonus) object;
        if ((this.bonusId == null && other.bonusId != null) || (this.bonusId != null && !this.bonusId.equals(other.bonusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Bonus[ bonusId=" + bonusId + " ]";
    }
    
}
