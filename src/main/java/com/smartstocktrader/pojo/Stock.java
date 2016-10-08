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
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByStockId", query = "SELECT s FROM Stock s WHERE s.stockId = :stockId"),
    @NamedQuery(name = "Stock.findByName", query = "SELECT s FROM Stock s WHERE s.name = :name"),
    @NamedQuery(name = "Stock.findByLink", query = "SELECT s FROM Stock s WHERE s.link = :link"),
    @NamedQuery(name = "Stock.findBySector", query = "SELECT s FROM Stock s WHERE s.sector = :sector"),
    @NamedQuery(name = "Stock.findByCategory", query = "SELECT s FROM Stock s WHERE s.category = :category"),
    @NamedQuery(name = "Stock.findByRemark1", query = "SELECT s FROM Stock s WHERE s.remark1 = :remark1"),
    @NamedQuery(name = "Stock.findByRemark2", query = "SELECT s FROM Stock s WHERE s.remark2 = :remark2")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_id")
    private Integer stockId;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 150)
    @Column(name = "link")
    private String link;
    @Size(max = 100)
    @Column(name = "sector")
    private String sector;
    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @Size(max = 45)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 45)
    @Column(name = "remark2")
    private String remark2;
    @OneToMany(mappedBy = "stockId")
    private List<Bonus> bonusList;
    @OneToMany(mappedBy = "stockId")
    private List<Price> priceList;
    @OneToMany(mappedBy = "stockId")
    private List<Review> reviewList;
    @OneToMany(mappedBy = "stockId")
    private List<Purchase> purchaseList;
    @OneToMany(mappedBy = "stockId")
    private List<Eps> epsList;

    public Stock() {
    }

    public Stock(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @XmlTransient
    public List<Bonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<Bonus> bonusList) {
        this.bonusList = bonusList;
    }

    @XmlTransient
    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @XmlTransient
    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @XmlTransient
    public List<Eps> getEpsList() {
        return epsList;
    }

    public void setEpsList(List<Eps> epsList) {
        this.epsList = epsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockId != null ? stockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockId == null && other.stockId != null) || (this.stockId != null && !this.stockId.equals(other.stockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartstocktrader.pojo.Stock[ stockId=" + stockId + " ]";
    }
    
}
