package com.autorost.myfavoritecar.entity;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * документ - отражает затраты на покупку ЗЧ, ТО, ремонт, мойка, топливо, шиномонтаж
 * факт - план(возможность оповещения)
 */
public class Invoice {
    //   private Car car;
    private String services;
    private String seller;//продавец инвойса
    ; // вид услуги заправка, мойка, покупка запчастей, шиномонтаж,ремонт -ТО
    private GregorianCalendar dateInvoice;//дата инвойса
    private double sumInvoice;//сумма инвойса
    private int mileageInvoice;//пробег на момент инвойса

    public Invoice(String services, String seller, GregorianCalendar dateInvoice, double sumInvoice, int mileageInvoice) {
        this.services = services;
        this.seller = seller;
        this.dateInvoice = dateInvoice;
        this.sumInvoice = sumInvoice;
        this.mileageInvoice = mileageInvoice;
    }


    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public GregorianCalendar getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(GregorianCalendar dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public double getSumInvoice() {
        return sumInvoice;
    }

    public void setSumInvoice(double sumInvoice) {
        this.sumInvoice = sumInvoice;
    }

    public int getMileageInvoice() {
        return mileageInvoice;
    }

    public void setMileageInvoice(int mileageInvoice) {
        this.mileageInvoice = mileageInvoice;
    }
}
