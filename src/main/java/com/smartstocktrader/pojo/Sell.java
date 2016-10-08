/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstocktrader.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "sell")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sell.findAll", query = "SELECT s FROM Sell s"),
    @NamedQuery(name = "Sell.findBySellId", query = "SELECT s FROM Sell s WHERE s.sellId = :sellId"),
    @NamedQuery(name = "Sell.findByQuantity", query = "SELECT s FROM Sell s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Sell.findByDate", query = "SELECT s FROM Sell s WHERE s.date = :date"),
    @NamedQuery(name = "Sell.findByPrice", query = "SELECT s FROM Sell s WHERE s.price = :price"),
    @NamedQuery(name = "Sell.findByMargin", query = "SELECT s FROM Sell s WHERE s.margin = :margin"),
    @NamedQuery(name = "Sell.findByBrokerFee", query = "SELECT s FROM Sell s WHERE s.brokerFee = :brokerFee"),
    @NamedQuery(name = "Sell.findByRemark1", query = "SELECT s FROM Sell s WHERE s.remark1 = :remark1"),
    @NamedQuery(name = "Sell.findByRemark2", query = "SELECT s FROM Sell s WHERE s.remark2 = :remark2"),
    @NamedQuery(name = "Sell.findByRemark3", query = "SELECT s FROM Sell s WHERE s.remark3 = :remark3")})
public class Sell implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sell_id")
    private Integer sellId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "margin")
    private Double margin;
    @Column(name = "broker_fee")
    private Double brokerFee;
    @Column(name = "remark1")
    private Double remark1;
    @Column(name = "remark2")
    private Integer remark2;
    @Size(max = 45)
    @Column(name = "remark3")
    private String remark3;
    @OneToMany(mappedBy = "sellId")
    private List<Portfolio> portfolioList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "protfolio_id", referencedColumnName = "portfolio_id")
    @ManyToOne
    private Portfolio protfolioId;
    @JoinColumn(name = "purchase_id", referencedColumnName = "purchase_id")
    @ManyToOne
    private Purchase purchaseId;

    public Sell() {
    }

    public Sell(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public Double getBrokerFee() {
        return brokerFee;
    }

    public void setBrokerFee(Double brokerFee) {
        this.brokerFee = brokerFee;
    }

    public Double getRemark1() {
        return remark1;
    }

    public void setRemark1(Double remark1) {
        this.remark1 = remark1;
    }

    public Integer getRemark2() {
        return remark2;
    }

    public void setRemark2(Integer remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    @XmlTransient
    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void setPortfolioList(List<Portfolio> portfolioList) {
        this.portfolioList = portfolioList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Portfolio getProtfolioId() {
        return protfolioId;
    }

    public void setProtfolioId(Portfolio protfolioId) {
        this.protfolioId = protfolioId;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellId != null ? sellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sell)) {
            return false;
        }
        Sell other = (Sell) object;
        if ((this.sellId == null && other.sellId != null) || (this.sellId != null && !this.sellId.equals(other.sellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Sell[ sellId=" + sellId + " ]";
    }
    
}
