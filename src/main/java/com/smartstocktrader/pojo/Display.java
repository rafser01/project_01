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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "display")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Display.findAll", query = "SELECT d FROM Display d"),
    @NamedQuery(name = "Display.findByStockId", query = "SELECT d FROM Display d WHERE d.stockId = :stockId"),
    @NamedQuery(name = "Display.findByName", query = "SELECT d FROM Display d WHERE d.name = :name"),
    @NamedQuery(name = "Display.findByPrice", query = "SELECT d FROM Display d WHERE d.price = :price"),
    @NamedQuery(name = "Display.findByHighPrice", query = "SELECT d FROM Display d WHERE d.highPrice = :highPrice"),
    @NamedQuery(name = "Display.findByLowPrice", query = "SELECT d FROM Display d WHERE d.lowPrice = :lowPrice"),
    @NamedQuery(name = "Display.findByBonusCash", query = "SELECT d FROM Display d WHERE d.bonusCash = :bonusCash"),
    @NamedQuery(name = "Display.findByBonusShare", query = "SELECT d FROM Display d WHERE d.bonusShare = :bonusShare"),
    @NamedQuery(name = "Display.findByRightShare", query = "SELECT d FROM Display d WHERE d.rightShare = :rightShare")})
public class Display implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_id")
    @Id
    private int stockId;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "high_price")
    private Double highPrice;
    @Column(name = "low_price")
    private Double lowPrice;
    @Column(name = "bonus_cash")
    private Double bonusCash;
    @Column(name = "bonus_share")
    private Double bonusShare;
    @Column(name = "right_share")
    private Double rightShare;

    public Display() {
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getBonusCash() {
        return bonusCash;
    }

    public void setBonusCash(Double bonusCash) {
        this.bonusCash = bonusCash;
    }

    public Double getBonusShare() {
        return bonusShare;
    }

    public void setBonusShare(Double bonusShare) {
        this.bonusShare = bonusShare;
    }

    public Double getRightShare() {
        return rightShare;
    }

    public void setRightShare(Double rightShare) {
        this.rightShare = rightShare;
    }
    
}
