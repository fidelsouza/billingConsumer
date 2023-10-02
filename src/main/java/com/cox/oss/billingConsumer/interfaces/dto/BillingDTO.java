package com.cox.oss.billingConsumer.interfaces.dto;

import java.util.Date;

public class BillingDTO {

    private Long id;
    private Long number;
    private String billingPeriod;
    private String customerName;
    private Double total;
    private Date dueDate;

    public BillingDTO() {
    }

    public BillingDTO(Long id, Long number, String billingPeriod, String customerName, Double total, Date dueDate) {
        this.id = id;
        this.number = number;
        this.billingPeriod = billingPeriod;
        this.customerName = customerName;
        this.total = total;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
