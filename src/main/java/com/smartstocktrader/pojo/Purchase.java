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
@Table(name = "purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPurchaseId", query = "SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId"),
    @NamedQuery(name = "Purchase.findByQuantity", query = "SELECT p FROM Purchase p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Purchase.findByPrice", query = "SELECT p FROM Purchase p WHERE p.price = :price"),
    @NamedQuery(name = "Purchase.findByData", query = "SELECT p FROM Purchase p WHERE p.data = :data"),
    @NamedQuery(name = "Purchase.findByRemark1", query = "SELECT p FROM Purchase p WHERE p.remark1 = :remark1"),
    @NamedQuery(name = "Purchase.findByBorkerFee", query = "SELECT p FROM Purchase p WHERE p.borkerFee = :borkerFee"),
    @NamedQuery(name = "Purchase.findByRemark2", query = "SELECT p FROM Purchase p WHERE p.remark2 = :remark2"),
    @NamedQuery(name = "Purchase.findByRemark3", query = "SELECT p FROM Purchase p WHERE p.remark3 = :remark3")})
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_id")
    private Integer purchaseId;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 45)
    @Column(name = "remark1")
    private String remark1;
    @Column(name = "borker_fee")
    private Double borkerFee;
    @Column(name = "remark2")
    private Double remark2;
    @Column(name = "remark3")
    private Integer remark3;
    @OneToMany(mappedBy = "purchaseId")
    private List<Portfolio> portfolioList;
    @OneToMany(mappedBy = "purchaseId")
    private List<Review> reviewList;
    @OneToMany(mappedBy = "purchaseId")
    private List<Sell> sellList;
    @JoinColumn(name = "portfolio_id", referencedColumnName = "portfolio_id")
    @ManyToOne
    private Portfolio portfolioId;
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    @ManyToOne
    private Stock stockId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    public Purchase() {
    }

    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public Double getBorkerFee() {
        return borkerFee;
    }

    public void setBorkerFee(Double borkerFee) {
        this.borkerFee = borkerFee;
    }

    public Double getRemark2() {
        return remark2;
    }

    public void setRemark2(Double remark2) {
        this.remark2 = remark2;
    }

    public Integer getRemark3() {
        return remark3;
    }

    public void setRemark3(Integer remark3) {
        this.remark3 = remark3;
    }

    @XmlTransient
    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void setPortfolioList(List<Portfolio> portfolioList) {
        this.portfolioList = portfolioList;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @XmlTransient
    public List<Sell> getSellList() {
        return sellList;
    }

    public void setSellList(List<Sell> sellList) {
        this.sellList = sellList;
    }

    public Portfolio getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Portfolio portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Stock getStockId() {
        return stockId;
    }

    public void setStockId(Stock stockId) {
        this.stockId = stockId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Purchase[ purchaseId=" + purchaseId + " ]";
    }
    
}
