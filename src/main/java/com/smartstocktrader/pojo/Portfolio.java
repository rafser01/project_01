/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstocktrader.pojo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "portfolio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"),
    @NamedQuery(name = "Portfolio.findByPortfolioId", query = "SELECT p FROM Portfolio p WHERE p.portfolioId = :portfolioId"),
    @NamedQuery(name = "Portfolio.findByPurchasePower", query = "SELECT p FROM Portfolio p WHERE p.purchasePower = :purchasePower"),
    @NamedQuery(name = "Portfolio.findByProfit", query = "SELECT p FROM Portfolio p WHERE p.profit = :profit"),
    @NamedQuery(name = "Portfolio.findByRemark1", query = "SELECT p FROM Portfolio p WHERE p.remark1 = :remark1"),
    @NamedQuery(name = "Portfolio.findByRemark2", query = "SELECT p FROM Portfolio p WHERE p.remark2 = :remark2"),
    @NamedQuery(name = "Portfolio.findByRemark3", query = "SELECT p FROM Portfolio p WHERE p.remark3 = :remark3")})
public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "portfolio_id")
    private Integer portfolioId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchase_power")
    private Double purchasePower;
    @Column(name = "profit")
    private Double profit;
    @Column(name = "remark1")
    private Double remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @Column(name = "remark3")
    private Integer remark3;
    @JoinColumn(name = "sell_id", referencedColumnName = "sell_id")
    @ManyToOne
    private Sell sellId;
    @JoinColumn(name = "purchase_id", referencedColumnName = "purchase_id")
    @ManyToOne
    private Purchase purchaseId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "protfolioId")
    private List<Sell> sellList;
    @OneToMany(mappedBy = "portfolioId")
    private List<Purchase> purchaseList;

    public Portfolio() {
    }

    public Portfolio(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Double getPurchasePower() {
        return purchasePower;
    }

    public void setPurchasePower(Double purchasePower) {
        this.purchasePower = purchasePower;
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

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public Integer getRemark3() {
        return remark3;
    }

    public void setRemark3(Integer remark3) {
        this.remark3 = remark3;
    }

    public Sell getSellId() {
        return sellId;
    }

    public void setSellId(Sell sellId) {
        this.sellId = sellId;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Sell> getSellList() {
        return sellList;
    }

    public void setSellList(List<Sell> sellList) {
        this.sellList = sellList;
    }

    @XmlTransient
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (portfolioId != null ? portfolioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.portfolioId == null && other.portfolioId != null) || (this.portfolioId != null && !this.portfolioId.equals(other.portfolioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Portfolio[ portfolioId=" + portfolioId + " ]";
    }
    
}
